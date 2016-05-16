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

        public RepositorioUsuario()
        {
            if (Usuarios.Count == 0)
            {
                Usuario admin = new Usuario("Administrador", "admin@admin.com", "63874adc5789a6e2e1fc51e40871dd53", "ADMIN");
                InserirUsuario(admin);
            }
        }

        public void InserirUsuario(Usuario user)
        {
            foreach (var usuarioNoBanco in Usuarios)
            {
                if (usuarioNoBanco.Email == user.Email)
                    throw new ArgumentException("Já existe um usuario com esse email!");
            }
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

        public List<string> ObterListaDeUsuarios()
        {
            List<string> infoUsuarios = new List<string>();
            foreach (var user in Usuarios)
            {
                infoUsuarios.Add(user.ToString());
            }
            return infoUsuarios;
        }
    }
}
