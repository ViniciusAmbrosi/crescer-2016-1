using CdZ.Dominio;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;

namespace CdZ.Repositorio.EF
{
    /*
     * Criamos nosso repositório de pedidos aqui, implementando nossa
     * interface de regras de repositório de pedidos.
     */
    public class CavaleiroRepositorioEF : ICavaleiroRepositorio
    {
        public int Adicionar(Cavaleiro cavaleiro)
        {
            using (var db = new ContextoDeDados())
            {
                /*
                 * Para informarmos um INSERT, devemos setar o State como Added.
                 */
                db.Entry<Cavaleiro>(cavaleiro).State = EntityState.Added;
                db.SaveChanges();
                return cavaleiro.Id;
            }
        }

        public Cavaleiro Buscar(int id)
        {
            using (var db = new ContextoDeDados())
            {
                return db.Cavaleiro
                     .Include(_ => _.LocalNascimento)
                     .Include(_ => _.LocalTreinamento)
                     .Include(_ => _.Golpes)
                     .Include(_ => _.Imagens)
                     .SingleOrDefault(_ => _.Id == id);
            }
        }

        public IEnumerable<Cavaleiro> Todos()
        {
            using (var db = new ContextoDeDados())
            {
                //TODO: paginar
                return db.Cavaleiro.ToList();
            }
        }

        public void Excluir(int id)
        {
            using (var db = new ContextoDeDados())
            {
                //TODO: arrumar, ta deixando restos no banco sem key, possivel soluçao como comentario no contextoDeDados.
                var cavaleiroASerExcluido = db.Cavaleiro.Find(id);
                var localNascimento = db.Cavaleiro.Include(_ => _.LocalNascimento).Single(_ => _.Id == id).LocalNascimento;
                var localTreinamento = db.Cavaleiro.Include(_ => _.LocalTreinamento).Single(_ => _.Id == id).LocalTreinamento;
                db.Entry<Cavaleiro>(cavaleiroASerExcluido).State = EntityState.Deleted;
                db.Entry<Local>(localNascimento).State = EntityState.Deleted;
                db.Entry<Local>(localTreinamento).State = EntityState.Deleted;
                db.SaveChanges();
            }
        }

        public void Atualizar(Cavaleiro cavaleiro)
        {
            using (var db = new ContextoDeDados())
            {
                db.Entry<Local>(cavaleiro.LocalNascimento).State = cavaleiro.LocalNascimento.Id == default(int) ? EntityState.Added : EntityState.Modified;
                db.Entry<Local>(cavaleiro.LocalTreinamento).State = cavaleiro.LocalTreinamento.Id == default(int) ? EntityState.Added : EntityState.Modified;
                foreach (var golpe in cavaleiro.Golpes)
                {
                    if (string.IsNullOrWhiteSpace(golpe.Nome))
                    {
                        db.Entry<Golpe>(golpe).State = EntityState.Deleted;
                        continue;
                    }
                    db.Entry<Golpe>(golpe).State = golpe.Id == default(int) ? EntityState.Added : EntityState.Modified;
                }
                foreach (var imagem in cavaleiro.Imagens)
                {
                    if (string.IsNullOrWhiteSpace(imagem.Url))
                    {
                        db.Entry<Imagem>(imagem).State = EntityState.Deleted;
                        continue;
                    }
                    db.Entry<Imagem>(imagem).State = imagem.Id == default(int) ? EntityState.Added : EntityState.Modified;
                }
                db.Entry<Cavaleiro>(cavaleiro).State = EntityState.Modified;
                db.SaveChanges();
            }
        }
    }
}
