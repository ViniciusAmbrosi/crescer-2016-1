using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace CdZ.MVC.Controllers
{
    public class MenuController : Controller
    {
        public PartialViewResult Menu()
        {
            return PartialView("Menu");
        }
    }
}