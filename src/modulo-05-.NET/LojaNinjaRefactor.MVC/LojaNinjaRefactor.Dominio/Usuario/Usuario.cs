using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LojaNinjaRefactor.Dominio.Usuario
{
    public class Usuario
    {
        public Usuario()
        {
        }

        public Usuario(int id, string email, string senha, string nome, IList<Permissao> permissoes)
        {
            this.ID = id;
            this.Email = email;
            this.Senha = senha;
            this.Nome = nome;
            this.Permissoes = permissoes;
        }

        public int ID { get; private set; }
        public string Nome { get; private set; }
        public string Email { get; private set; }
        public string Senha { get; private set; }
        public IList<Permissao> Permissoes { get; private set; }

        public override string ToString()
        {
            string permissoesToString = "Não tem permissões especiais";
            if (Permissoes != null)
            {
                permissoesToString = "";
                foreach (var perm in Permissoes)
                {
                    permissoesToString += perm + " ";
                }
            }
            return Nome + "," + Email + "," + permissoesToString;
        }
    }
}
