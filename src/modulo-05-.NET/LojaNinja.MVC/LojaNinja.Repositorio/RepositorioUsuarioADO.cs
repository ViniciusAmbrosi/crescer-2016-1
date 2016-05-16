using LojaNinja.Dominio;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Configuration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Transactions;

namespace LojaNinja.Repositorio
{
    public class RepositorioUsuarioADO : IUsuarioRepositorio
    {
        private SqlConnection CriarConexao()
        {
            return new SqlConnection(ConfigurationManager.ConnectionStrings["UserDB"].ConnectionString);
        }

        public SqlParameter CriarParametro (string nomeParametro, object valorParametro)
        {
            return new SqlParameter(nomeParametro, valorParametro);
        }

        public Usuario BuscarUsuarioPorAutenticacao(string email, string senha)
        {
            SqlConnection conexao =  CriarConexao();
            Usuario userAutorizado = null;
            List<string> perm = new List<string>();
            using (conexao)
            {
                string sql = "SELECT usuario.nome, usuario.email, usuario.senha, usuario.usuarioId, permissao.permissao FROM Usuario usuario INNER JOIN PermissaoUsuario permissao_usuario ON usuario.usuarioId = permissao_usuario.usuarioId INNER JOIN Permissao permissao ON permissao_usuario.permissaoId = permissao.permissaoId WHERE email=@p_email and senha=@p_senha";
                var comando = new SqlCommand(sql, conexao);
                comando.Parameters.Add(CriarParametro("p_email", email));
                comando.Parameters.Add(CriarParametro("p_senha", senha));
                conexao.Open();
                SqlDataReader leitor = comando.ExecuteReader();
                while (leitor.Read())
                {
                    if(userAutorizado == null)
                        //TODO: refatorar
                        userAutorizado = new Usuario(leitor["nome"].ToString(), leitor["email"].ToString(), leitor["senha"].ToString());
                    perm.Add(leitor["permissao"].ToString());
                };
                userAutorizado.Permissoes = perm.ToArray();
            }

            return userAutorizado;
        }

        public void InserirUsuario(Usuario user)
        {
            throw new NotImplementedException();
        }
    }
}
