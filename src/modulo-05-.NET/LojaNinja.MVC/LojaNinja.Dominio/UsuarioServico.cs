using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Cryptography;
using System.Text;
using System.Threading.Tasks;

namespace LojaNinja.Dominio
{
    public class UsuarioServico
    {
        private IUsuarioRepositorio repoUsuarios;

        public UsuarioServico(IUsuarioRepositorio usuarioRepositorio)
        {
            repoUsuarios = usuarioRepositorio;
        }

        private string Criptografar(string texto)
        {
            using (MD5 md5Hash = MD5.Create())
            {
                byte[] data = md5Hash.ComputeHash(Encoding.UTF8.GetBytes(texto));
                StringBuilder sBuilder = new StringBuilder();

                for (int i = 0; i < data.Length; i++)
                {
                    sBuilder.Append(data[i].ToString("x2"));
                }

                return sBuilder.ToString();
            }
        }

        public Usuario BuscarUsuarioPorAutenticacao(string email, string senha)
        {
            var senhaCripto = Criptografar(senha);
            return repoUsuarios.BuscarUsuarioPorAutenticacao(email, senhaCripto);
        }

        public void InserirUsuario(Usuario user)
        {
            user.Senha = Criptografar(user.Senha);
            repoUsuarios.InserirUsuario(user);
        }
    }
}
