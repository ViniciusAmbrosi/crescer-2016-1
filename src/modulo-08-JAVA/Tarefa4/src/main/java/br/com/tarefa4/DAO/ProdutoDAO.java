package br.com.tarefa4.DAO;

import br.com.cwi.tarefa4.interfaces.IProduto;
import br.com.cwi.tarefa4.utils.CSVUtils;
import br.com.tarefa4.entity.Cidade;
import br.com.tarefa4.entity.Cliente;
import br.com.tarefa4.entity.Produto;
import java.io.IOException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 * @author Vinicius
 */
public class ProdutoDAO implements IProduto {

    static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRESCER16");
    static final EntityManager em = emf.createEntityManager();

    public EntityTransaction getTransaction() {
        return em.getTransaction();
    }

    @Override
    public void insert(Produto produto) {
        if (produto.getIdProduto() == null) {
            throw new IllegalArgumentException();
        }
        EntityTransaction transaction = getTransaction();
        transaction.begin();
        Session session = em.unwrap(Session.class);
        session.save(produto);
        transaction.commit();
    }

    @Override
    public void update(Produto produto) {
        if (produto.getIdProduto() == null) {
            throw new IllegalArgumentException();
        }
        EntityTransaction transaction = getTransaction();
        transaction.begin();
        Session session = em.unwrap(Session.class);
        session.update(produto);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Produto produto) {
        if (produto.getIdProduto() == null) {
            throw new IllegalArgumentException();
        }
        EntityTransaction transaction = getTransaction();
        transaction.begin();
        em.remove(em.contains(produto) ? produto : em.merge(produto));
        transaction.commit();
    }

    @Override
    public List<Produto> listAll() {
        Session session = em.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Cidade.class);
        List<Produto> produtos = criteria.list();
        session.close();
        return produtos;
    }

    @Override
    public List<Produto> findNome(String nome) {
        Session session = em.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Cidade.class);
        criteria.add(Restrictions.like("nome", nome));
        List<Produto> produtos = criteria.list();
        session.close();
        return produtos;
    }

    public void exportarCsv(String caminho) throws IOException {
        List<Produto> produtos = listAll();
        CSVUtils.gerarCsvProduto(produtos, caminho);
    }
}
