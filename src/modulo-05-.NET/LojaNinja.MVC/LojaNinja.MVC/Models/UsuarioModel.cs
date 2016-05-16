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
        [Required(ErrorMessage = "Você deve informar um nome.")]
        [DisplayName("Nome")]
        public string Nome { get; set; }

        //[Required(ErrorMessage = "Você deve informar o cpf")]
        //[MaxLength(11, ErrorMessage = "CPF deve ter no máximo 11 digitos")]
        //[MinLength(11, ErrorMessage = "CPF deve ter no minimo 11 digitos")]
        //[RegularExpression("^[0-9]*$", ErrorMessage = "CPF deve ser numérico")]
        //[DisplayName("CPF")]
        //public string CPF { get; set; }

        [Required(ErrorMessage = "Você deve informar seu email")]
        [DisplayName("Email")]
        [EmailAddress]
        public string Email { get; set; }

        [Required(ErrorMessage = "Você deve informar sua senha")]
        [DisplayName("Senha")]
        public string Senha { get; set; }

        [Required(ErrorMessage = "Você deve informar uma confirmação para a senha")]
        [DisplayName("Confirmar senha")]
        public string ConfirmaSenha { get; set; }
    }
}