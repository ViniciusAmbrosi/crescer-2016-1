using CdZ.Dominio;
using System;
using System.Linq;
using System.Collections.Generic;
using Dominio = CdZ.Dominio;
using System.ComponentModel.DataAnnotations;
using System.Web.Script.Serialization;
using CdZ.MVC.Extensions;

namespace CdZ.MVC.Models.Cavaleiro
{
    public class CavaleiroViewModel
    {
        public int Id { get; set; }
        public string Nome { get; set; }
        public double AlturaCm { get; set; }
        public double PesoLb { get; set; }
        public string DataNascimento { get; set; }
        [ScriptIgnore]
        public DateTime DataNascimentoObj
        {
            get { return DataNascimento.FromISOToDateTime(); }
            set { DataNascimento = value.FromDateTimeToISOString(); }
        }
        public Signo Signo { get; set; }
        public TipoSanguineo TipoSanguineo { get; set; }
        public Local LocalNascimento { get; set; }
        public Local LocalTreinamento { get; set; }
        public IList<string> Golpes { get; set; }
        public IList<ImagemViewModel> Imagens { get; set; }

        public Dominio.Cavaleiro ToModel()
        {
            var golpesObj = new List<Golpe>();
            var imagensObj = new List<Imagem>();
            if (Golpes != null)
                golpesObj = Golpes.Select(_ => new Golpe(_)).ToList();
            if (Imagens != null)
                imagensObj = Imagens.Select(_ => _.ToModel()).ToList();

            return new Dominio.Cavaleiro(Nome, AlturaCm, PesoLb, DataNascimentoObj, Signo, TipoSanguineo, LocalNascimento, LocalTreinamento, golpesObj, imagensObj);
        }
    }
}