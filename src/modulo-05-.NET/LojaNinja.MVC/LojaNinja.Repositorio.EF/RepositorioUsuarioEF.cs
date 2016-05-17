using LojaNinja.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LojaNinja.Repositorio.EF
{
    public class RepositorioUsuarioEF : IUsuarioRepositorio
    {
        public Usuario BuscarUsuarioPorAutenticacao(string email, string senha)
        {
            throw new NotImplementedException();
        }

        public void InserirUsuario(Usuario user)
        {
            throw new NotImplementedException();
        }

        public List<string> ObterListaDeUsuarios()
        {
            throw new NotImplementedException();
        }
    }
}
