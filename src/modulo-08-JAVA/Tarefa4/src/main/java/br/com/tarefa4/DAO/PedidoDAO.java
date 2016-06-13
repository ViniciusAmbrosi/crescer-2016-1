package br.com.tarefa4.DAO;

import br.com.cwi.tarefa4.interfaces.IPedido;
import br.com.cwi.tarefa4.utils.CSVUtils;
import br.com.tarefa4.entity.Cidade;
import br.com.tarefa4.entity.Cliente;
import br.com.tarefa4.entity.Pedido;
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
public class PedidoDAO implements IPedido {

    static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRESCER16");
    static final EntityManager em = emf.createEntityManager();

    public EntityTransaction getTransaction() {
        return em.getTransaction();
    }

    @Override
    public void insert(Pedido pedido) {
        EntityTransaction transaction = getTransaction();
        transaction.begin();
        Session session = em.unwrap(Session.class);
        session.save(pedido);
        transaction.commit();
    }

    @Override
    public void update(Pedido pedido) {
        if (pedido.getIdPedido() == null) {
            throw new IllegalArgumentException();
        }
        EntityTransaction transaction = getTransaction();
        transaction.begin();
        Session session = em.unwrap(Session.class);
        session.update(pedido);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Pedido pedido) {
        if (pedido.getIdPedido() == null) {
            throw new IllegalArgumentException();
        }
        EntityTransaction transaction = getTransaction();
        transaction.begin();
        em.remove(em.contains(pedido) ? pedido : em.merge(pedido));
        transaction.commit();
    }

    @Override
    public List<Pedido> listAll() {
        Session session = em.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Cidade.class);
        List<Pedido> pedidos = criteria.list();
        session.close();
        return pedidos;
    }

    @Override
    public List<Pedido> findBySituacao(boolean situacao) {
        Session session = em.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Cidade.class);
        criteria.add(Restrictions.like("sitaucao", situacao));
        List<Pedido> pedidos = criteria.list();
        session.close();
        return pedidos;
    }

    @Override
    public void exportarCsv(String caminho) throws IOException {
        List<Pedido> pedidos = listAll();
        CSVUtils.gerarCsvPedido(pedidos, caminho);
    }
}
