using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace MVC_StreetFighter.Models.StreetFighter
{
    public class SobreMimModel
    {
        public string Nome { get; set; }
        public DateTime DataNascimento { get; set; }
        public string Email { get; set; }
        public List<String> Hobbies { get; set; }
        public string SrcFoto { get; set; }

    }
}