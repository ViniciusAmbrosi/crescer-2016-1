using LojaNinja.Dominio;
using LojaNinja.MVC.Filter;
using LojaNinja.MVC.Models;
using LojaNinja.MVC.Services;
using LojaNinja.Repositorio.EF;
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
        private IUsuarioRepositorio repositorio = new RepositorioUsuarioADO();
        //private IUsuarioRepositorio repositorio = new RepositorioUsuarioEF();
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

        [ValidateAntiForgeryToken]
        public ActionResult Salvar(UsuarioModel model)
        {
            if (model.Senha != model.ConfirmaSenha)
                ModelState.AddModelError("SENHAS_DIFERENTES", "Senha e confirmação são diferentes.");

            try
            {
                if (ModelState.IsValid)
                {
                    Usuario user = new Usuario();
                    user.Nome = model.Nome;
                    user.Email = model.Email;
                    user.Senha = model.Senha;
                    usuarioServico.InserirUsuario(user);
                    ViewBag.EfetuarLogin = "Cadastro completo, efetue login para continuar!";//TODO: ARRUMAR VIEWBAG
                    return View("Index");
                }
            }
            catch (ArgumentException ex)
            {
                ModelState.AddModelError("", ex.Message);
                return View("Cadastro", model);
            }
            return View("Cadastro", model);
        }

        //COTNENT---------------------------------------------------------------CONTENT-----------------------------------------------------------------------------CONTENT
        [UserToken(Roles = "COMUM")]
        public ActionResult Detalhes()
        {
            try
            {
                UsuarioLogadoModel usuarioLogado = ServicoDeSessao.UsuarioLogado;
                return View(usuarioLogado);
            }
            catch (ArgumentException ex)
            {
                ViewBag.Erro = ex.Message;
                return View("Erro");
            }
        }

        public PartialViewResult Menu()
        {
            if (ServicoDeSessao.UsuarioLogado != null)
                ViewBag.NomeSessao = ServicoDeSessao.UsuarioLogado.Nome;
            return PartialView("_Menu");
        }

        [UserToken(Roles = "ADMIN")]
        public ActionResult Listagem()
        {
            var usuarios = repositorio.ObterListaDeUsuarios();
            return View(usuarios);
        }

        public ActionResult Logout()
        {
            ServicoDeSessao.Logout();
            return View("Index");
        }

    }
}