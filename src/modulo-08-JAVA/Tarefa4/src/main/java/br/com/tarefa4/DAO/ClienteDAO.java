package br.com.tarefa4.DAO;

import br.com.cwi.tarefa4.interfaces.ICliente;
import br.com.cwi.tarefa4.utils.CSVUtils;
import br.com.tarefa4.entity.Cidade;
import br.com.tarefa4.entity.Cliente;
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
public class ClienteDAO implements ICliente {

    static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRESCER16");
    static final EntityManager em = emf.createEntityManager();

    public EntityTransaction getTransaction() {
        return em.getTransaction();
    }

    @Override
    public void insert(Cliente cliente) {
        EntityTransaction transaction = getTransaction();
        transaction.begin();
        Session session = em.unwrap(Session.class);
        session.save(cliente);
        transaction.commit();
    }

    @Override
    public void update(Cliente cliente) {
        if (cliente.getIdCliente() == null) {
            throw new IllegalArgumentException();
        }
        EntityTransaction transaction = getTransaction();
        transaction.begin();
        Session session = em.unwrap(Session.class);
        session.update(cliente);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Cliente cliente) {
        if (cliente.getIdCliente() == null) {
            throw new IllegalArgumentException();
        }
        EntityTransaction transaction = getTransaction();
        transaction.begin();
        em.remove(em.contains(cliente) ? cliente : em.merge(cliente));
        transaction.commit();
    }

    @Override
    public List<Cliente> listAll() {
        Session session = em.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Cidade.class);
        List<Cliente> clientes = criteria.list();
        session.close();
        return clientes;
    }

    @Override
    public List<Cliente> findNome(String nome) {
        Session session = em.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Cidade.class);
        criteria.add(Restrictions.like("nome", nome));
        List<Cliente> clientes = criteria.list();
        session.close();
        return clientes;
    }

    public void exportarCsv(String caminho) throws IOException{
        List<Cliente> clientes = listAll();
        CSVUtils.gerarCsvCliente(clientes, caminho);
    }
}
