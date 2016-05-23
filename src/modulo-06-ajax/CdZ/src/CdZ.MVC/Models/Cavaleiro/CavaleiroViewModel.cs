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

        public CavaleiroViewModel()
        {
            Imagens = new List<ImagemViewModel>();
        }
        public int Id { get; set; }
        public string Nome { get; set; }
        public double AlturaCm { get; set; }
        public double PesoLb { get; set; }
        public string DataNascimento { get; set; }
        [ScriptIgnore]
        public DateTime DataNascimentoObj
        {
            get { return DataNascimento.FromISOToDateTime(); }
            set { DataNascimento = value.Date.FromDateTimeToISOString(); }
        }
        public Signo Signo { get; set; }
        public TipoSanguineo TipoSanguineo { get; set; }
        public string LocalNascimento { get; set; }
        public string LocalTreinamento { get; set; }
        [UIHint("Golpes")]
        public IList<string> Golpes { get; set; }
        [UIHint("Imagens")]
        public IList<ImagemViewModel> Imagens { get; set; }

        public Dominio.Cavaleiro ToModel()
        {
            var golpesObj = new List<Golpe>();
            var imagensObj = new List<Imagem>();
            if (Golpes != null)
                golpesObj = Golpes.Select(_ => new Golpe(_)).ToList();
            if (Imagens != null)
                imagensObj = Imagens.Select(_ => new Imagem(_.Url, _.IsThumb)).ToList();
            var localNascimento = new Local(LocalNascimento);
            var localTreinamento = new Local(LocalTreinamento);
            return new Dominio.Cavaleiro(Nome, AlturaCm, PesoLb, DataNascimentoObj, Signo, TipoSanguineo, localNascimento, localTreinamento, golpesObj, imagensObj);
        }

        public CavaleiroViewModel toViewModel(Dominio.Cavaleiro cavaleiro)
        {
            var cavaleiroViewModel = new CavaleiroViewModel();
            cavaleiroViewModel.Id = cavaleiro.Id;
            cavaleiroViewModel.Nome = cavaleiro.Nome;
            cavaleiroViewModel.AlturaCm = cavaleiro.AlturaCm;
            cavaleiroViewModel.PesoLb = cavaleiro.PesoLb;
            cavaleiroViewModel.DataNascimentoObj = cavaleiro.DataNascimento;
            cavaleiroViewModel.Signo = cavaleiro.Signo;
            cavaleiroViewModel.TipoSanguineo = cavaleiro.TipoSanguineo;
            cavaleiroViewModel.LocalNascimento = cavaleiro.LocalNascimento.Texto;
            cavaleiroViewModel.LocalTreinamento = cavaleiro.LocalTreinamento.Texto;
            var imagensViewModel = new List<ImagemViewModel>();
            imagensViewModel = cavaleiro.Imagens.Select(img => new ImagemViewModel().imagemToViewModel(img)).ToList();
            cavaleiroViewModel.Imagens = imagensViewModel;
            cavaleiroViewModel.Golpes = cavaleiro.Golpes.Select(golpe => golpe.Nome).ToList();
            return cavaleiroViewModel;
        }
    }
}