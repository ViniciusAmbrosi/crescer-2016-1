using LojaNinja.Dominio;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace LojaNinja.MVC.Models
{
    public class PedidoModel
    {
        [Required(ErrorMessage = "Deve informar data de entrega")]
        [DisplayName("Data de Entrega")]
        public DateTime DataEntrega { get; set; }

        [Required(ErrorMessage = "Deve ser informado o nome do produto")]
        [DisplayName("Nome do Produto")]
        public string NomeProduto { get; set; }

        [Required(ErrorMessage = "Deve ser informado o valor")]
        public decimal Valor { get; set; }

        [Required(ErrorMessage = "Deve ser informado o tipo de pagamento")]
        [DisplayName("Tipo de Pagamento")]
        public TipoPagamento TipoDePagamento { get; set; }

        [Required(ErrorMessage = "Deve ser informado o nome do cliente")]
        [DisplayName("Nome do Cliente")]
        public string NomeCliente { get; set; }

        [Required(ErrorMessage = "Deve ser informado a cidade")]
        public string Cidade { get; set; }

        [Required(ErrorMessage = "Deve ser informado o estado")]
        public string Estado { get; set; }
    }
}