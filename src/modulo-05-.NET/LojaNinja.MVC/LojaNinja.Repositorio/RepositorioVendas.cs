using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using LojaNinja.Dominio;

namespace LojaNinja.Repositorio
{
    public class RepositorioVendas
    {
        private const string PATH_ARQUIVO = @"D:\Vendas.txt";

        public void IncluirPedido(Pedido pedido)
        {
            var thislock = new Object();
            var id = PegarUltimoId() + 1;
            try
            {
                pedido.AtualizarId(id);
            }
            catch (InvalidOperationException ex)
            { }
            finally
            {
                lock (thislock)
                {
                    using (var stream = new StreamWriter(PATH_ARQUIVO, true))
                    {
                        var newLine = GerarStringNoFormato(pedido);
                        stream.WriteLine(newLine);
                    };
                }
            }
        }

        private int PegarUltimoId()
        {
            var linhas = File.ReadAllLines(PATH_ARQUIVO).ToList();
            linhas.RemoveAt(0);
            int ultimoId;
            if (linhas.Count != 0)
                ultimoId = Convert.ToInt32(linhas.Last().Split(';')[0]);
            else
                ultimoId = 0;
            return ultimoId;
        }

        private string GerarStringNoFormato(Pedido pedido)
        {
            var newLine = string.Format("{0}; {1}; {2}; {3}; {4}; {5}; {6}; {7}; {8}; {9}",
            pedido.NumeroPedido,
            pedido.DataPedido.ToString("dd/MM/yyyy hh:mm"),
            pedido.DataEntrega.ToString("dd/MM/yyyy hh:mm"),
            pedido.NomeProduto,
            pedido.Valor,
            pedido.TipoDePagamento,
            pedido.NomeCliente,
            pedido.Cidade,
            pedido.Estado,
            pedido.PedidoUrgente);
            return newLine;
        }

        private List<Pedido> ConverteLinhasEmPedidos(List<string> linhasArquivo)
        {
            var listaPedidos = new List<Pedido>();

            //Remove linha do cabeçalho
            linhasArquivo.RemoveAt(0);

            foreach (var linha in linhasArquivo)
            {
                var id = Convert.ToInt32(linha.Split(';')[0]);
                var dataPedido = Convert.ToDateTime(linha.Split(';')[1]);
                var dataEntregaDesejada = Convert.ToDateTime(linha.Split(';')[2]);
                var nomeProduto = linha.Split(';')[3];
                var valorVenda = Convert.ToDecimal(linha.Split(';')[4]);
                TipoPagamento tipoPagamento;
                Enum.TryParse(linha.Split(';')[5], out tipoPagamento);
                var nomeCliente = linha.Split(';')[6];
                var cidade = linha.Split(';')[7];
                var estado = linha.Split(';')[8];
                var urgente = Convert.ToBoolean(linha.Split(';')[9]);
                var pedido = new Pedido(id, dataPedido, dataEntregaDesejada, nomeProduto, valorVenda, tipoPagamento, nomeCliente, cidade, estado, urgente);
                listaPedidos.Add(pedido);
            }
            return listaPedidos;
        }

        public List<Pedido> ObterPedidos()
        {
            var linhasArquivo = File.ReadAllLines(PATH_ARQUIVO).ToList();

            return ConverteLinhasEmPedidos(linhasArquivo);
        }

        public Pedido ObterPedidoPorId(int id)
        {
            return this.ObterPedidos().FirstOrDefault(x => x.NumeroPedido == id);
        }

        public void AlterarPedido(int id, DateTime dataEntrega, string nomeProduto, decimal valor, TipoPagamento tipoDePagamento, string nomeCliente, string cidade, string estado)
        {
            var pedidos = ObterPedidos();
            var cabecalho = File.ReadLines(PATH_ARQUIVO).First();
            File.WriteAllText(PATH_ARQUIVO, string.Empty);
            File.AppendAllText(PATH_ARQUIVO, cabecalho + Environment.NewLine);
            foreach (var pedido in pedidos)
            {
                if (pedido.NumeroPedido == id)
                {
                    Pedido pedidoAAlterar = new Pedido(id, pedido.DataPedido, dataEntrega, nomeProduto, valor, tipoDePagamento, nomeCliente, cidade, estado, pedido.PedidoUrgente);
                    IncluirPedido(pedidoAAlterar);
                }
                else
                    IncluirPedido(pedido);
            }
        }

        public void RemoverPedido(int id)
        {
            var pedidos = ObterPedidos();
            var linhas = pedidos.Where(pedido => pedido.NumeroPedido != id).ToList();
            var cabecalho = File.ReadLines(PATH_ARQUIVO).First();
            File.WriteAllText(PATH_ARQUIVO, string.Empty);
            File.AppendAllText(PATH_ARQUIVO, cabecalho + Environment.NewLine);
            foreach (var linha in linhas)
            {
                IncluirPedido(linha);
            }
        }

        public List<Pedido> ObterPedidosComDeterminadoProduto(string produto)
        {
            var pedidos = ObterPedidos().Where(pedido => pedido.NomeProduto.IndexOf(produto, StringComparison.OrdinalIgnoreCase) >= 0).ToList();
            return pedidos;
        }

        public List<Pedido> ObterPedidosComDeterminadoCliente(string cliente)
        {
            var pedidos = ObterPedidos().Where(pedido => pedido.NomeCliente.IndexOf(cliente, StringComparison.OrdinalIgnoreCase) >= 0).ToList();
            return pedidos;
        }
    }
}

