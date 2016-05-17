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

        public SqlParameter CriarParametro(string nomeParametro, object valorParametro)
        {
            return new SqlParameter(nomeParametro, valorParametro);
        }

        public Usuario BuscarUsuarioPorAutenticacao(string email, string senha)
        {
            SqlConnection conexao = CriarConexao();
            Usuario userAutorizado = null;
            List<string> permissoesUsuario = new List<string>();
            using (conexao)
            {
                string sql = "SELECT nome, email, senha, usuarioId FROM Usuario WHERE email=@p_email and senha=@p_senha";
                var comando = new SqlCommand(sql, conexao);
                comando.Parameters.Add(CriarParametro("p_email", email));
                comando.Parameters.Add(CriarParametro("p_senha", senha));
                conexao.Open();
                SqlDataReader leitor = comando.ExecuteReader();
                if (leitor.Read())
                {
                    userAutorizado = new Usuario();
                    userAutorizado.ID = Convert.ToInt32(leitor["usuarioId"]);
                    userAutorizado.Nome = leitor["nome"].ToString();
                    userAutorizado.Email = leitor["email"].ToString();
                    userAutorizado.Senha = leitor["senha"].ToString();
                    var permissoes = LePermissoesUsuario(userAutorizado.ID);
                    if (permissoes != null)
                        userAutorizado.permRepDB = permissoes;
                }
                return userAutorizado;
            }
        }

        private bool ExisteCadastroComEmailFornecido(Usuario user)
        {
            SqlConnection conexao = CriarConexao();
            using (conexao)
            {
                string sql = "SELECT email FROM Usuario WHERE email=@p_email";
                var comando = new SqlCommand(sql, conexao);
                comando.Parameters.Add(CriarParametro("p_email", user.Email));
                conexao.Open();
                SqlDataReader leitor = comando.ExecuteReader();
                if (leitor.Read())
                {
                    throw new ArgumentException("Já existe um usuario com esse email!");
                }
                return false;
            }
        }

        public void InserirUsuario(Usuario user)
        {
            if (!ExisteCadastroComEmailFornecido(user))
            {
                SqlConnection conexao = CriarConexao();
                using (TransactionScope scope = new TransactionScope())
                {
                    try
                    {
                        string sqlInserirUsuario = "INSERT INTO Usuario (nome, email, senha) VALUES(@p_nome, @p_email, @p_senha)";
                        string sqlInserirPermissao = "INSERT INTO PermissaoUsuario (usuarioId, permissaoId) VALUES(IDENT_CURRENT('Usuario'),@p_id)";
                        var comandoInserirUsuario = new SqlCommand(sqlInserirUsuario, conexao);
                        var comandoInserirPermissao = new SqlCommand(sqlInserirPermissao, conexao);
                        comandoInserirUsuario.Parameters.Add(CriarParametro("p_nome", user.Nome));
                        comandoInserirUsuario.Parameters.Add(CriarParametro("p_email", user.Email));
                        comandoInserirUsuario.Parameters.Add(CriarParametro("p_senha", user.Senha));
                        comandoInserirPermissao.Parameters.Add(CriarParametro("p_id", 1));
                        conexao.Open();
                        comandoInserirUsuario.ExecuteNonQuery();
                        comandoInserirPermissao.ExecuteNonQuery();
                        scope.Complete();
                    }
                    catch (Exception)
                    {
                        throw;
                    }
                }

            }
        }

        public List<string> ObterListaDeUsuarios()
        {
            SqlConnection conexao = CriarConexao();
            Usuario userEncontrado = null;
            List<string> usuariosEncontrados = new List<string>();
            using (conexao)
            {
                string sqlBuscaUsuario = "SELECT usuario.nome, usuario.email, usuario.senha, usuario.usuarioId FROM Usuario usuario";
                var comandoBuscaUsuario = new SqlCommand(sqlBuscaUsuario, conexao);

                conexao.Open();
                SqlDataReader leitorUsuario = comandoBuscaUsuario.ExecuteReader();
                while (leitorUsuario.Read())
                {
                    userEncontrado = new Usuario();
                    userEncontrado.ID = Convert.ToInt32(leitorUsuario["usuarioId"]);
                    userEncontrado.Nome = leitorUsuario["nome"].ToString();
                    userEncontrado.Email = leitorUsuario["email"].ToString();
                    var permissoes = LePermissoesUsuario(userEncontrado.ID);
                    if (permissoes != null)
                        userEncontrado.permRepDB = permissoes;
                    usuariosEncontrados.Add(userEncontrado.ToString());
                }
            }
            return usuariosEncontrados;
        }

        private string[] LePermissoesUsuario(int id)
        {
            List<string> permissoesUsuario = new List<string>();
            SqlConnection conexao = CriarConexao();
            using (conexao)
            {
                string sqlBuscaPermissoes = "SELECT permissao.permissao FROM Permissao permissao INNER JOIN PermissaoUsuario perm_usuario ON permissao.permissaoId = perm_usuario.permissaoId WHERE perm_usuario.usuarioId = @p_userId";
                var comandoBuscaPermissoes = new SqlCommand(sqlBuscaPermissoes, conexao);
                comandoBuscaPermissoes.Parameters.Add(CriarParametro("p_userId", id));
                conexao.Open();
                SqlDataReader leitorPermissoes = comandoBuscaPermissoes.ExecuteReader();
                while (leitorPermissoes.Read())
                    permissoesUsuario.Add(leitorPermissoes["permissao"].ToString());
            };
            return permissoesUsuario.ToArray();
        }

    }
}

