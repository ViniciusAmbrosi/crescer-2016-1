using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace LojaNinjaRefactor.MVC.Models
{
    public class LoginModel
    {
        [Required]
        [EmailAddress]
        [DisplayName("Email")]
        public string Email { get; set; }

        [Required]
        [DisplayName("Senha")]
        public string Senha { get; set; }
    }
}