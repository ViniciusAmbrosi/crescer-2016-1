using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LojaNinja.Dominio
{
    public class Usuario
    {
        public Usuario(string nome, string email, string senha, string permissao)
        {
            Nome = nome;
            Email = email;
            Senha = senha;
            Permissoes = new string[] { permissao };
        }

        public Usuario(string nome, string email, string senha)
        {
            Nome = nome;
            Email = email;
            Senha = senha;
        }

        public int ID { get; private set; }
        public string Nome { get; private set; }
        public string Email { get; private set; }
        public string Senha { get; private set; }
        public string[] Permissoes { get; private set; }

        public void AdicionarId(int id)
        {
            if (this.ID != 0)
            {
                throw new InvalidOperationException("Esse objeto já possuia Id, portanto ele já havia sido salvo no banco. Não é possível alterar esse valor.");
            }
            this.ID = id;
        }
    }
}
