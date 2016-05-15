using LojaNinja.Dominio;
using LojaNinja.MVC.Filter;
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

        [UserToken(Roles = "Manager")]
        public ActionResult Cadastro()
        {
            return View();
        }

        [UserToken(Roles = "Manager")]
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

        [UserToken(Roles = "Manager")]
        [HttpPost]
        [ValidateAntiForgeryToken]
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

        [UserToken(Roles = "Manager")]
        public ActionResult Detalhes(int? id)
        {
            int idPedido;
            try
            {
                idPedido = (int)id;
                if (repositorio.ObterPedidoPorId(idPedido) == null)
                {
                    ViewBag.ErroIDPedido = "Nao existe nenhum pedido com este ID, tente novamente!";
                    return View("Erro");
                }

            }
            catch (Exception)
            {
                ViewBag.ErroIDPedido = "Nenhum ID possui letras, tente novamente!";
                return View("Erro"); ;
            }
            return View(repositorio.ObterPedidoPorId(idPedido));
        }

        [UserToken(Roles = "Manager")]
        public ActionResult Listagem(string produto, string cliente)
        {
            if (String.IsNullOrWhiteSpace(produto) && String.IsNullOrWhiteSpace(cliente))
            {
                var pedidos = repositorio.ObterPedidos();
                return View(pedidos);
            }
            else if (String.IsNullOrWhiteSpace(produto))
            {
                var pedidosComClienteTal = repositorio.ObterPedidosComDeterminadoCliente(cliente);
                return View(pedidosComClienteTal);
            }
            else
            {
                var pedidosComProdutoTal = repositorio.ObterPedidosComDeterminadoProduto(produto);
                return View(pedidosComProdutoTal);
            }
        }

        [UserToken(Roles = "Manager")]
        public ActionResult Excluir(int id)
        {
            repositorio.RemoverPedido(id);
            var pedidos = repositorio.ObterPedidos();
            return View("Listagem", pedidos);
        }
    }
}