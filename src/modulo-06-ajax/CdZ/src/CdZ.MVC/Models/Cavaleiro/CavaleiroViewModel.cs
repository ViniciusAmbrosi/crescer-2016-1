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
        [UIHint("LocalNascimento")]
        public LocalViewModel LocalNascimento { get; set; }
        [UIHint("LocalTreinamento")]
        public LocalViewModel LocalTreinamento { get; set; }
        [UIHint("Golpes")]
        public IList<GolpeViewModel> Golpes { get; set; }
        [UIHint("Imagens")]
        public IList<ImagemViewModel> Imagens { get; set; }

        public Dominio.Cavaleiro ToModel()
        {
            var IdCavaleiro = Id;
            var golpesObj = new List<Golpe>();
            var imagensObj = new List<Imagem>();
            if (Golpes != null)
                golpesObj = Golpes.Select(_ => _.ToModel()).ToList();
            if (Imagens != null)
                imagensObj = Imagens.Select(_ => new Imagem(_.Id, _.Url, _.IsThumb)).ToList();
            var localNascimento = LocalNascimento.ToModel();
            var localTreinamento = LocalTreinamento.ToModel();
            return new Dominio.Cavaleiro(Id, Nome, AlturaCm, PesoLb, DataNascimentoObj, Signo, TipoSanguineo, localNascimento, localTreinamento, golpesObj, imagensObj);
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
            var local = new LocalViewModel();
            cavaleiroViewModel.LocalNascimento = local.ToViewModel(cavaleiro.LocalNascimento);
            cavaleiroViewModel.LocalTreinamento = local.ToViewModel(cavaleiro.LocalTreinamento);
            var imagensViewModel = new List<ImagemViewModel>();
            imagensViewModel = cavaleiro.Imagens.Select(img => new ImagemViewModel().imagemToViewModel(img)).ToList();
            cavaleiroViewModel.Imagens = imagensViewModel;
            var golpeVM = new GolpeViewModel();
            cavaleiroViewModel.Golpes = cavaleiro.Golpes.Select(golpe => golpeVM.toViewModel(golpe)).ToList();
            return cavaleiroViewModel;
        }
    }
}