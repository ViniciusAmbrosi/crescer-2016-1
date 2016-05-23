namespace CdZ.MVC.Models.Cavaleiro
{
    public class GolpeViewModel
    {
        public int Id { get; set; }
        public string Nome { get; set; }

        public Dominio.Golpe ToModel()
        {
            return new Dominio.Golpe(Id, Nome);
        }

        public GolpeViewModel toViewModel(Dominio.Golpe golpe)
        {
            var golpeVM = new GolpeViewModel();
            golpeVM.Id = golpe.Id;
            golpeVM.Nome = golpe.Nome;
            return golpeVM;
        }
    }
}