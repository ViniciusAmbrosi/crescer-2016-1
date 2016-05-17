using LojaNinja.MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Security;

namespace LojaNinja.MVC.Services
{
    public class ServicoDeSessao
    {
        private const string COOKIE_AUTENTICACAO = "COOKIE_AUTENTICACAO";
        private const string USUARIO_LOGADO = "USUARIO_LOGADO";

        private static Dictionary<string, string> _usuariosLogados = new Dictionary<string, string>();

        public static void CriarSessao(UsuarioLogadoModel usuario)
        {
            string numeroToken = Guid.NewGuid().ToString();
            _usuariosLogados.Add(numeroToken, usuario.Email);
            HttpContext.Current.Session[USUARIO_LOGADO] = usuario;
            var cookieDeAutenticacao = new HttpCookie(COOKIE_AUTENTICACAO, numeroToken);
            HttpContext.Current.Response.Cookies.Set(cookieDeAutenticacao);
        }

        public static UsuarioLogadoModel UsuarioLogado
        {
            get
            {
                return (UsuarioLogadoModel)HttpContext.Current.Session[USUARIO_LOGADO];
            }
        }

        public static bool EstaLogado
        {
            get
            {
                if (UsuarioLogado != null)
                {
                    HttpCookie cookieDeAutenticacao = HttpContext.Current.Request.Cookies.Get(COOKIE_AUTENTICACAO);
                    bool cookieEstaOk = _usuariosLogados.Any(
                            u => u.Key.Equals(cookieDeAutenticacao.Value)
                            && u.Value.Equals(UsuarioLogado.Email)
                        );
                    return cookieEstaOk;
                }
                return false;
            }
        }

        public static void Logout()
        {
            FormsAuthentication.SignOut();
            HttpContext.Current.Session.Abandon();
            LimparCookieAutenticacaoServidor();
            LimparCookieSessionServidor();
            InvalidarCacheDoCliente();
        }

        private static void LimparCookieAutenticacaoServidor()
        {
            HttpCookie authCookie = new HttpCookie(FormsAuthentication.FormsCookieName, "");
            authCookie.Expires = DateTime.Now.AddYears(-1);
            HttpContext.Current.Response.Cookies.Add(authCookie);
        }

        private static void LimparCookieSessionServidor()
        {
            HttpCookie sessionCookie = new HttpCookie("ASP.NET_SessionId", "");
            sessionCookie.Expires = DateTime.Now.AddYears(-1);
            HttpContext.Current.Response.Cookies.Add(sessionCookie);
        }

        private static void InvalidarCacheDoCliente()
        {
            HttpContext.Current.Response.Cache.SetCacheability(HttpCacheability.NoCache);
            HttpContext.Current.Response.Cache.SetNoStore();
        }
    }
}