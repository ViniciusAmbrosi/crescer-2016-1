using LojaNinja.Dominio;
using LojaNinja.MVC.Models;
using LojaNinja.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace LojaNinja.MVC.Controllers
{
    public class PedidoController : Controller
    {
        private RepositorioVendas repositorio = new RepositorioVendas();

        public ActionResult Cadastro()
        {
            return View();
        }

        public ActionResult Salvar(PedidoModel model)
        {
            var pedido = new Pedido(model.DataEntrega, model.NomeProduto, model.Valor, model.TipoDePagamento,
                                    model.NomeCliente, model.Cidade, model.Estado);
            repositorio.IncluirPedido(pedido);
            return View("Detalhes", model);
        }
    }
}