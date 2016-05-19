using LojaNinjaRefactor.MVC.Extensios;
using LojaNinjaRefactor.MVC.Models;
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
            HttpCookie cookieDeAutenticacao = HttpContext.Current.Request.Cookies.Get(COOKIE_AUTENTICACAO);
            _usuariosLogados.Remove(cookieDeAutenticacao.Value);
            LimparCookieAutenticacaoServidor(cookieDeAutenticacao);
            LimparCookieSessionServidor();
            InvalidarCacheDoCliente();
            HttpContext.Current.Session.Abandon();
        }

        private static void LimparCookieAutenticacaoServidor(HttpCookie cookie)
        {
            cookie.Expirar();
            HttpContext.Current.Response.Cookies.Add(cookie);
        }

        private static void LimparCookieSessionServidor()
        {
            HttpCookie sessionCookie = new HttpCookie("ASP.NET_SessionId", "");
            sessionCookie.Expirar();
            HttpContext.Current.Response.Cookies.Add(sessionCookie);
        }

        private static void InvalidarCacheDoCliente()
        {
            HttpContext.Current.Response.Cache.SetCacheability(HttpCacheability.NoCache);
            HttpContext.Current.Response.Cache.SetNoStore();
        }
    }
}