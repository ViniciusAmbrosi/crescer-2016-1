using MVC_StreetFighter.Models.StreetFighter;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace MVC_StreetFighter.Controllers
{
    public class StreetFighterController : Controller
    {
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult FichaTecnica()
        {
            return View();
        }

        public ActionResult SobreMim()
        {
            SobreMimModel pessoa = new SobreMimModel { 
                Nome = "Vinicius Ambrosi",
                DataNascimento = new DateTime(1993, 4, 11),
                Email = "ambrosi.vinicius@gmail.com",
                Hobbies = new List<string> { "Guitarra", "Esportes", "Jogos" },
                SrcFoto = "foto-vinicius.jpg" 
            };
            return View(pessoa);
        }
    }
}