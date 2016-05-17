using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LojaNinja.Dominio
{
    public class Usuario
    {
        public int ID { get; set; }
        public string Nome { get; set; }
        public string Email { get; set; }
        public string Senha { get; set; }
        public string[] Permissoes { get; set; }

        public void AdicionarId(int id)
        {
            if (this.ID != 0)
            {
                throw new InvalidOperationException("Esse objeto já possuia Id, portanto ele já havia sido salvo no banco. Não é possível alterar esse valor.");
            }
            this.ID = id;
        }

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
