using LojaNinjaRefactor.MVC.Filter;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace LojaNinjaRefactor.MVC.Controllers
{
    public class UsuarioController : Controller
    {
        //TODO: implementar tratamento dos métodos

        public ActionResult CadastroDeUsuario()
        {
            return View();
        }

        [Autorizacao(Roles = "COMUM")]
        public ActionResult DetalhesUsuario()
        {
            return View();
        }

        [Autorizacao(Roles = "ADMIN")]
        public ActionResult Listagemusuarios()
        {
            return View();
        }
    }
}