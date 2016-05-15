using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace LojaNinja.MVC.Models
{
    public class UsuarioModel
    {
        [Required(ErrorMessage = "Você deve informar o primeiro nome.")]
        [DisplayName("Primeiro Nome")]
        public string PrimeiroNome { get; set; }

        [Required(ErrorMessage = "Você deve informar o ultimo nome")]
        [DisplayName("Último Nome")]
        public string UltimoNome { get; set; }

        [Required(ErrorMessage = "Você deve informar o cpf")]
        [MaxLength(11, ErrorMessage = "CPF deve ter no máximo 11 digitos")]
        [MinLength(11, ErrorMessage = "CPF deve ter no minimo 11 digitos")]
        [RegularExpression("^[0-9]*$", ErrorMessage = "CPF deve ser numérico")]
        [DisplayName("CPF")]
        public string CPF { get; set; }

        [Required(ErrorMessage = "Você deve informar sua data de nascimento")]
        [DisplayName("Data de nascimento")]
        public DateTime DataNascimento { get; set; }

        [Required(ErrorMessage = "Você deve informar seu email")]
        [DisplayName("Email")]
        [EmailAddress]
        public string Email { get; set; }

        [Required(ErrorMessage = "Você deve informar seu email")]
        [StringLength(20, MinimumLength = 6, ErrorMessage = "A senha deve conter de 6 a 20 caracteres")]
        [DisplayName("Senha")]
        public string Senha { get; set; }
    }
}