using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace LojaNinja.MVC.Models
{
    public class LoginModel
    {
        [Required]
        [DisplayName("Email")]
        [EmailAddress]
        public string Email { get; set; }
        [Required]
        [DisplayName("Senha")]
        [StringLength(20, MinimumLength = 6, ErrorMessage = "Senhas possuem de 6 a 20 caracteres")]
        public string Senha { get; set; }
    }
}