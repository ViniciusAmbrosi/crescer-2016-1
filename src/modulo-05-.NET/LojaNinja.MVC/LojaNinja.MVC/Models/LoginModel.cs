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
        public string Senha { get; set; }
    }
}