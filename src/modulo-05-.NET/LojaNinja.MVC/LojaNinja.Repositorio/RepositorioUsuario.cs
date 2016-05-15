using LojaNinja.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LojaNinja.Repositorio
{
    public class RepositorioUsuario : IUsuarioRepositorio
    {
        static List<Usuario> Usuarios = new List<Usuario>();

        public void InserirUsuario(Usuario user)
        {
            user.AdicionarId(Usuarios.Count + 1);
            Usuarios.Add(user);
        }

        public Usuario BuscarUsuarioPorAutenticacao(string email, string senha)
        {
            return Usuarios.FirstOrDefault(user => user.Email.Equals(email) && senha.Equals(senha));
        }

        public Usuario ObterPorId(int id)
        {
            return Usuarios[id - 1];
        }
    }
}
