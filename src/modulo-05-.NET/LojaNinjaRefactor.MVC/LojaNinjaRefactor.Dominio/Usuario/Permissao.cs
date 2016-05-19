using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LojaNinjaRefactor.Dominio.Usuario
{
    public class Permissao
    {
        public Permissao()
        {
        }

        public Permissao(int id, string nome)
        {
            this.ID = id;
            this.Nome = nome;
        }

        public int ID { get; private set; }
        public string Nome { get; private set; }
        public IList<Usuario> Usuarios { get; private set; }
    }
}
