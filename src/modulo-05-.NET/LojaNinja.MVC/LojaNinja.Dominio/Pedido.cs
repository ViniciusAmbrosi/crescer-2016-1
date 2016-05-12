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
        }

        public DateTime DataEntrega { get; private set; }
        public DateTime DataPedido { get; private set; }
        public string NomeProduto { get; private set; }
        public decimal Valor { get; private set; }
        public TipoPagamento TipoDePagamento { get; private set; }
        public string NomeCliente { get; private set; }
        public string Cidade { get; private set; }
        public string Estado { get; private set; }
        public int NumeroPedido { get; private set; }
    }
}
