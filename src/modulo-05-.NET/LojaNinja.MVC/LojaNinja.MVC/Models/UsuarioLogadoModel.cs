using LojaNinja.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace LojaNinja.MVC.Models
{
    public class UsuarioLogadoModel
    {
        public UsuarioLogadoModel(Usuario usuario)
        {
            Nome = usuario.PrimeiroNome;
            Email = usuario.Email;
            Permissoes = usuario.Permissoes;
            ID = usuario.ID;
        }

        public string Email { get; private set; }
        public string Nome { get; private set; }
        public string[] Permissoes { get; private set;}
        public int ID { get; private set; }

        public bool TemPermissao(string permissao)
        {
            return Permissoes != null
                   && Permissoes.Any(p => p.Equals(permissao));
        }
    }
}