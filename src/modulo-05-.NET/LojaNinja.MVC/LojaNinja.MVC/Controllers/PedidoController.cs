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

        public ActionResult Editar(int id)
        {
            var pedido = repositorio.ObterPedidoPorId(id);
            PedidoModel pedidoModel = new PedidoModel
            {
                NomeCliente = pedido.NomeCliente,
                NomeProduto = pedido.NomeProduto,
                NumeroPedido = pedido.NumeroPedido,
                Cidade = pedido.Cidade,
                DataEntrega = pedido.DataEntrega,
                Estado = pedido.Estado,
                TipoDePagamento = pedido.TipoDePagamento,
                Valor = pedido.Valor
            };
            return View("Cadastro", pedidoModel);
        }

        public ActionResult Salvar(PedidoModel model)
        {
            if (ModelState.IsValid)
            {
                Pedido pedido;
                try
                {
                    pedido = new Pedido(model.DataEntrega, model.NomeProduto, model.Valor, model.TipoDePagamento,
                        model.NomeCliente, model.Cidade, model.Estado);
                    if (model.NumeroPedido.HasValue)
                    {
                        int id = (int)model.NumeroPedido;
                        repositorio.AlterarPedido(id, model.DataEntrega, model.NomeProduto, model.Valor, model.TipoDePagamento,
                            model.NomeCliente, model.Cidade, model.Estado);
                        return View("Detalhes", pedido);
                    }
                    else {
                        repositorio.IncluirPedido(pedido);
                        return View("Detalhes", pedido);
                    }
                }
                catch (ArgumentException ex)
                {
                    ModelState.AddModelError("", ex.Message);
                    return View("Cadastro", model);
                }
            }
            else
            {
                return View("Cadastro", model);
            }
        }

        public ActionResult Detalhes(int? id)
        {
            int idPedido;
            try
            {
                idPedido = (int)id;
                if (repositorio.ObterPedidoPorId(idPedido) == null)
                {
                    return Content("<script language='javascript' type='text/javascript'>alert('Pedido não existe!');</script>");
                }
            
            }
            catch (Exception ex){
                return Content("<script language='javascript' type='text/javascript'>alert('Pedido não existe!');</script>");
    }
            return View(repositorio.ObterPedidoPorId(idPedido));
        }

public ActionResult Listagem()
{
    var pedidos = repositorio.ObterPedidos();
    return View(pedidos);
}

public ActionResult Excluir(int id)
{
    repositorio.RemoverPedido(id);
    var pedidos = repositorio.ObterPedidos();

    return View("Listagem", pedidos);
}
    }
}