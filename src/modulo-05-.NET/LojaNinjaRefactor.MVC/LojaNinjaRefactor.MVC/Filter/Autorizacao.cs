using LojaNinja.MVC.Services;
using LojaNinjaRefactor.MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Web.Routing;

namespace LojaNinjaRefactor.MVC.Filter
{
    public class Autorizacao : AuthorizeAttribute
    {
        public Autorizacao()
        {
        }

        private string[] _permissoesRequeridas = null;
        private string[] PermissoesRequeridas
        {
            get
            {
                if (_permissoesRequeridas == null)
                {
                    _permissoesRequeridas = String.IsNullOrWhiteSpace(this.Roles) ?
                                        new string[0] :
                                        this.Roles.Split(',');
                }
                return _permissoesRequeridas;
            }
        }

        private bool TemAutorizacao
        {
            get
            {
                UsuarioLogadoModel usuarioLogado = ServicoDeSessao.UsuarioLogado;

                if (this.PermissoesRequeridas.Length > 0)
                {
                    foreach (string permissao in _permissoesRequeridas)
                    {
                        if (usuarioLogado.TemPermissao(permissao))
                        {
                            return true;
                        }
                    }
                }
                else
                {
                    return true;
                }
                return false;
            }
        }

        protected override bool AuthorizeCore(HttpContextBase httpContext)
        {
            return ServicoDeSessao.EstaLogado && TemAutorizacao;
        }

        public override void OnAuthorization(AuthorizationContext filterContext)
        {
            bool estaAutenticadoEAutorizado = this.AuthorizeCore(filterContext.HttpContext);

            if (!estaAutenticadoEAutorizado)
            {
                filterContext.Result = new RedirectToRouteResult(
                                   new RouteValueDictionary
                                   {
                                       { "action", "Index" },
                                       { "controller", "Login" }
                                   });
            }
        }
    }
}