package br.com.tarefa4.DAO;

import br.com.cwi.tarefa4.interfaces.IProdutoMaterial;
import br.com.tarefa4.entity.Cidade;
import br.com.tarefa4.entity.ProdutoMaterial;
import java.util.ArrayList;
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
public class ProdutoMaterialDAO implements IProdutoMaterial {

    static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRESCER16");
    static final EntityManager em = emf.createEntityManager();

    public EntityTransaction getTransaction() {
        return em.getTransaction();
    }

    @Override
    public void insert(ProdutoMaterial produtoMaterial) {
        if (produtoMaterial.getIdProdutoMaterial() == null) {
            throw new IllegalArgumentException();
        }
        EntityTransaction transaction = getTransaction();
        transaction.begin();
        Session session = em.unwrap(Session.class);
        session.save(produtoMaterial);
        transaction.commit();
    }

    @Override
    public void update(ProdutoMaterial produtoMaterial) {
        if (produtoMaterial.getIdProdutoMaterial() == null) {
            throw new IllegalArgumentException();
        }
        EntityTransaction transaction = getTransaction();
        transaction.begin();
        Session session = em.unwrap(Session.class);
        session.update(produtoMaterial);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(ProdutoMaterial produtoMaterial) {
        if (produtoMaterial.getIdProdutoMaterial() == null) {
            throw new IllegalArgumentException();
        }
        EntityTransaction transaction = getTransaction();
        transaction.begin();
        em.remove(em.contains(produtoMaterial) ? produtoMaterial : em.merge(produtoMaterial));
        transaction.commit();

    }

    @Override
    public List<ProdutoMaterial> listAll() {
        Session session = em.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Cidade.class);
        List<ProdutoMaterial> produtosMateriais = criteria.list();
        session.close();
        return produtosMateriais;
    }

    @Override
    public List<ProdutoMaterial> findByQuantidade(double quantidade, boolean maior, boolean menor) {
        List<ProdutoMaterial> produtosMateriais = new ArrayList();
        if (maior) {
            Session session = em.unwrap(Session.class);
            Criteria criteria = session.createCriteria(Cidade.class);
            criteria.add(Restrictions.between("quantidade", quantidade, Double.MAX_VALUE));
            produtosMateriais = criteria.list();
            session.close();
        } else if (menor) {
            Session session = em.unwrap(Session.class);
            Criteria criteria = session.createCriteria(Cidade.class);
            criteria.add(Restrictions.between("quantidade", 0, quantidade));
            produtosMateriais = criteria.list();
            session.close();
        } else {
            Session session = em.unwrap(Session.class);
            Criteria criteria = session.createCriteria(Cidade.class);
            criteria.add(Restrictions.like("quantidade", quantidade));
            produtosMateriais = criteria.list();
            session.close();
        }
        return produtosMateriais;
    }

}
