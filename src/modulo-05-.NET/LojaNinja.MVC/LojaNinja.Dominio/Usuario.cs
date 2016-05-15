using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LojaNinja.Dominio
{
    public class Usuario
    {
        public Usuario(string primeiroNome, string ultimoNome, string cpf, DateTime dataNascimento, string email, string senha)
        {
            PrimeiroNome = primeiroNome;
            UltimoNome = ultimoNome;
            CPF = cpf;
            DataNascimento = dataNascimento;
            Email = email;
            Senha = senha;
            DataRegistro = DateTime.Now;
            Permissoes = new string[] {"Manager"};
        }

        public int ID { get; private set; }
        public string PrimeiroNome { get; private set; }
        public string UltimoNome { get; private set; }
        public string CPF { get; private set; }
        public DateTime DataNascimento { get; private set; }
        public string Email { get; private set; }
        public string Senha { get; private set; }
        public DateTime DataRegistro { get; private set; }
        public string[] Permissoes { get; private set; }

        public void AdicionarId(int id)
        {
            if (this.ID != 0)
            {
                throw new InvalidOperationException("Esse objeto já possuia Id, portanto ele já havia sido salvo no banco. Não é possível alterar esse valor.");
            }
            this.ID = id;
        }

        public void DarPermissao(string perm)
        {
            Permissoes[Permissoes.Length] = perm;
        }
    }
}
