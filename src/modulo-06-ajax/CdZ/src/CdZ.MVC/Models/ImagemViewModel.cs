using CdZ.Dominio;

namespace CdZ.MVC.Models
{
    public class ImagemViewModel
    {
        public int Id { get; set; }
        public string Url { get; set; }
        public bool IsThumb { get; set; }

        public ImagemViewModel() { }

        public Imagem ToModel()
        {
            return new Imagem(Url, IsThumb);
        }

        public ImagemViewModel imagemToViewModel(Imagem img)
        {
            var imgViewModel = new ImagemViewModel();
            imgViewModel.Id = img.Id;
            imgViewModel.Url = img.Url;
            imgViewModel.IsThumb = img.IsThumb;
            return imgViewModel;
        }
    }
}