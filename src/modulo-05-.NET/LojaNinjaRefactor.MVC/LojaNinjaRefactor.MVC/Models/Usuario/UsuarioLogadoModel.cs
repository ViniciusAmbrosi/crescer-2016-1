using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace LojaNinjaRefactor.MVC.Models
{
    public class UsuarioLogadoModel
    {
        //TODO: implementar construtor baseado na class Usuario immplementada para o EF
        //public UsuarioLogadoModel(Usuario usuario)
        //{
        //    Nome = usuario.Nome;
        //    Email = usuario.Email;
        //    Permissoes = usuario.permRepDB;
        //    ID = usuario.ID;
        //}

        public int ID { get; private set; }
        public string Email { get; private set; }
        public string Nome { get; private set; }
        public IList<string> Permissoes { get; private set; }

        public bool TemPermissao(string permissao)
        {
            return Permissoes != null
                   && Permissoes.Any(p => p.Equals(permissao));
        }
    }
}