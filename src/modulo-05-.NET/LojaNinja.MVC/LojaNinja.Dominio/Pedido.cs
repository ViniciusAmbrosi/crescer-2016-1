using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LojaNinja.Dominio
{
    public class Pedido
    {
        public Pedido(DateTime dataEntrega, string nomeProduto, decimal valor, TipoPagamento tipoDePagamento, string nomeCliente, string cidade, string estado)
        {
            DataEntrega = dataEntrega;
            NomeProduto = nomeProduto;
            Valor = valor;
            TipoDePagamento = tipoDePagamento;
            NomeCliente = nomeCliente;
            Cidade = cidade;
            Estado = estado;
            DataPedido = DateTime.Now;

            var diasRestantesParaConcluirEntrega = (DataEntrega - DataPedido).TotalDays;
            ValidaPossibilidadeEntrega(diasRestantesParaConcluirEntrega);
            DefineUrgenciaDoPedido(diasRestantesParaConcluirEntrega);
        }

        public Pedido(int numeroPedido, DateTime dataPedido, DateTime dataEntrega, string nomeProduto, decimal valor, TipoPagamento tipoDePagamento, string nomeCliente, string cidade, string estado, bool urgente)
        {
            NumeroPedido = numeroPedido;
            DataPedido = dataPedido;
            DataEntrega = dataEntrega;
            NomeProduto = nomeProduto;
            Valor = valor;
            TipoDePagamento = tipoDePagamento;
            NomeCliente = nomeCliente;
            Cidade = cidade;
            Estado = estado;
            DataPedido = dataPedido;
            PedidoUrgente = urgente;
        }

        public DateTime DataEntrega { get; private set; }
        public DateTime DataPedido { get; private set; }
        public string NomeProduto { get; private set; }
        public decimal Valor { get; private set; }
        public TipoPagamento TipoDePagamento { get; private set; }
        public string NomeCliente { get; private set; }
        public string Cidade { get; private set; }
        public string Estado { get; private set; }
        public int? NumeroPedido { get; private set; }
        public bool PedidoUrgente { get; private set; }


        private void ValidaPossibilidadeEntrega(double diasRestantesParaConcluirEntrega)
        {
            if (diasRestantesParaConcluirEntrega < 1)
                throw new ArgumentException("A data de entrega deve ser no mínimo 1 dia maior do que a data atual.");
        }

        private void DefineUrgenciaDoPedido(double diasRestantesParaConcluirEntrega)
        {
            PedidoUrgente = diasRestantesParaConcluirEntrega < 7;
        }

        public void AtualizarId(int id)
        {
            if (NumeroPedido.HasValue)
                throw new InvalidOperationException("Esse objeto já possuia Id, portanto ele já havia sido salvo no banco. Não é possível alterar esse valor.");
            NumeroPedido = id;
        }
    }

}
