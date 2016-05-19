using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace LojaNinjaRefactor.MVC.Extensios
{
    public static class HttpCookieExtension
    {
        public static void Expirar(this HttpCookie cookie)
        {
            cookie.Expires = DateTime.Now.AddDays(-1d);
        }
    }
}