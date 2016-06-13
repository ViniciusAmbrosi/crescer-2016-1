package br.com.tarefa4.DAO;

import br.com.cwi.tarefa4.interfaces.ICidade;
import br.com.tarefa4.entity.Cidade;
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
public class CidadeDAO implements ICidade {

    static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRESCER16");
    static final EntityManager em = emf.createEntityManager();

    public EntityTransaction getTransaction() {
        return em.getTransaction();
    }

    @Override
    public void insert(Cidade cidade) {
        EntityTransaction transaction = getTransaction();
        transaction.begin();
        Session session = em.unwrap(Session.class);
        session.save(cidade);
        transaction.commit();
    }

    @Override
    public void update(Cidade cidade) {
        EntityTransaction transaction = getTransaction();
        transaction.begin();
        Session session = em.unwrap(Session.class);
        session.update(cidade);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Cidade cidade) {
        EntityTransaction transaction = getTransaction();
        transaction.begin();
        em.remove(em.contains(cidade) ? cidade : em.merge(cidade));
        transaction.commit();
    }

    @Override
    public List<Cidade> listAll() {
        Session session = em.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Cidade.class);
        List<Cidade> cidades = criteria.list();
        session.close();
        return cidades;
    }

    @Override
    public List<Cidade> findNome(String nome) {
        Session session = em.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Cidade.class);
        criteria.add(Restrictions.like("nome", nome));
        List<Cidade> cidades = criteria.list();
        session.close();
        return cidades;
    }
}
