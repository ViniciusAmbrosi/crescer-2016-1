namespace CdZ.MVC.Models.Cavaleiro
{
    public class LocalViewModel
    {
        public int Id { get; set; }
        public string Texto { get; set; }

        public Dominio.Local ToModel()
        {
            return new Dominio.Local(Id, Texto);
        }

        public LocalViewModel ToViewModel(Dominio.Local local)
        {
            var localVm = new LocalViewModel();
            localVm.Id = local.Id;
            localVm.Texto = local.Texto;
            return localVm;
        } 
    }
}