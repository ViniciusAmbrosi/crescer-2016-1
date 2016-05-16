using LojaNinja.Dominio;
using LojaNinja.MVC.Filter;
using LojaNinja.MVC.Models;
using LojaNinja.MVC.Services;
using LojaNinja.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace LojaNinja.MVC.Controllers
{
    public class UsuarioController : Controller
    {
        private RepositorioUsuario repositorio = new RepositorioUsuario();
        private UsuarioServico usuarioServico;

        public UsuarioController()
        {
            usuarioServico = new UsuarioServico(repositorio);
        }

        //LOGIN---------------------------------------------------------------LOGIN------------------------------------------------------------------------LOGIN
        public ActionResult Index()
        {
            if (!ServicoDeSessao.EstaLogado)
            {
                return View();
            }
            return RedirectToAction("Detalhes");
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult LogIn(LoginModel model)
        {
            if (ModelState.IsValid)
            {
                var usuarioEncontrado = usuarioServico.BuscarUsuarioPorAutenticacao(model.Email, model.Senha);
                if (usuarioEncontrado != null)
                {
                    var usuarioLogado = new UsuarioLogadoModel(usuarioEncontrado);
                    ServicoDeSessao.CriarSessao(usuarioLogado);
                    return RedirectToAction("Detalhes");
                }
                else
                    ModelState.AddModelError("INVALID_USER", "Usuário ou senha inválido.");
            }
            return View("Index", model);
        }


        //CADASTRO---------------------------------------------------------------CADASTRO------------------------------------------------------------------------CADASTRO
        public ActionResult Cadastro()
        {
            return View();
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Salvar(UsuarioModel model)
        {
            if (model.Senha != model.ConfirmaSenha)
                ModelState.AddModelError("SENHAS_DIFERENTES", "Senha e confirmação são diferentes.");

            if (ModelState.IsValid)
            {
                Usuario user = new Usuario(model.Nome, model.Email, usuarioServico.Criptografar(model.Senha));
                repositorio.InserirUsuario(user);
                ViewBag.EfetuarLogin = "Cadastro completo, efetue login para continuar!";
                return View("Index");
            }
            return View("Cadastro", model);
        }

        [HttpGet]
        [UserToken]
        public ActionResult Detalhes()
        {
            UsuarioLogadoModel usuarioLogado = ServicoDeSessao.UsuarioLogado;
            return View("Detalhes", repositorio.ObterPorId(usuarioLogado.ID));
        }

        public PartialViewResult Menu()
        {
            if (ServicoDeSessao.UsuarioLogado != null)
                ViewBag.NomeSessao = ServicoDeSessao.UsuarioLogado.Nome;
            return PartialView("_Menu");
        }

    }
}