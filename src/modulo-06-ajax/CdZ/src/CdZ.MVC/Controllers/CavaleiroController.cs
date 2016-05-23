using CdZ.Dominio;
using CdZ.MVC.Models.Cavaleiro;
using CdZ.MVC.Services;
using System.Net;
using System.Web.Mvc;

namespace CdZ.MVC.Controllers
{
    public class CavaleiroController : Controller
    {
        private ICavaleiroRepositorio _cavaleiros = ServicoInjecaoDeDependecia.CriarCavaleiroRepositorio();

        [HttpGet]
        public ActionResult ListagemCavaleiros()
        {
            return View();
        }

        [HttpGet]
        public ActionResult CadastroCavaleiro()
        {
            return View();
        }

        [HttpGet]
        public ActionResult CadastroCavaleiro2()
        {
            return View();
        }

        //[HttpPut]
        public ActionResult EditarCavaleiro(CavaleiroViewModel cavaleiro)
        {
            return View("CadastroCavaleiro2", cavaleiro);
        }

        public ActionResult EditarCavaleiroPorId(int cavaleiro)
        {
            Cavaleiro cavaleiroModel = _cavaleiros.Buscar(cavaleiro);
            CavaleiroViewModel cavaleiroViewModel = new CavaleiroViewModel();
            cavaleiroViewModel = cavaleiroViewModel.toViewModel(cavaleiroModel);
            return View("CadastroCavaleiro2", cavaleiroViewModel);
        }

        [HttpGet]
        [ActionName("GetById")]
        public JsonResult Get(int? id)
        {
            var cavaleiro = _cavaleiros.Buscar((int)id);
            var cavaleiroModel = new CavaleiroViewModel();
            cavaleiroModel = cavaleiroModel.toViewModel(cavaleiro);
            return Json(new { data = cavaleiroModel }, JsonRequestBehavior.AllowGet);
        }

        //[Http]
        public ActionResult AlterarCavaleiro(CavaleiroViewModel cavaleiro)
        {
            _cavaleiros.Atualizar(cavaleiro.ToModel());
            return View("ListagemCavaleiros");
            //return View("CadastroCavaleiro2", cavaleiroModel);
        }

        [HttpGet]
        public JsonResult Get()
        {
            /* Para simular erro, descomente
                var status = (int)HttpStatusCode.InternalServerError;
                throw new HttpException(status, "Ops");
            */
            //System.Threading.Thread.Sleep(3000);
            return Json(new { data = _cavaleiros.Todos() }, JsonRequestBehavior.AllowGet);
        }

        [HttpPost]
        public JsonResult Post(CavaleiroViewModel cavaleiro)
        {
            if (cavaleiro.Id == 0)
            {
                var novoId = _cavaleiros.Adicionar(cavaleiro.ToModel());
                Response.StatusCode = (int)HttpStatusCode.Created;
                return Json(new { id = novoId });
            }
            else
            {
                _cavaleiros.Atualizar(cavaleiro.ToModel());
                Response.StatusCode = (int)HttpStatusCode.Accepted;
                return Json(new { id = cavaleiro.Id });
            }
        }

        [HttpDelete]
        public JsonResult Delete(int id)
        {
            _cavaleiros.Excluir(id);
            return NoContentJsonVazio();
        }

        private JsonResult NoContentJsonVazio()
        {
            Response.StatusCode = (int)HttpStatusCode.NoContent;
            return Json(new { });
        }
    }
}
