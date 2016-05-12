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
        private const string PATH_ARQUIVO = @"C:\Users\vinicius.ambrosi\Desktop\Vendas.txt";

        public void IncluirPedido(Pedido pedido)
        {
            var thislock = new Object();
            var id = GerarId() + 1;
            lock (thislock)
            {
                using (var stream = new StreamWriter(PATH_ARQUIVO, true))
                {
                    var newLine = string.Format("{0}; {1}; {2}; {3}; {4}; {5}; {6}; {7}; {8}",
                        id,
                        pedido.DataPedido.ToString("d"),
                        pedido.DataEntrega.ToString("d"),
                        pedido.NomeProduto,
                        pedido.Valor,
                        pedido.TipoDePagamento,
                        pedido.NomeCliente,
                        pedido.Cidade,
                        pedido.Estado);
                    stream.WriteLine(newLine);
                };
            }
        }

        private int GerarId()
        {
            var linhas = File.ReadAllLines(PATH_ARQUIVO).ToList();
            var ultimoLinha = Convert.ToInt32(linhas.Last().Split(';')[0]);
            return ultimoLinha;
        }
    }
}

