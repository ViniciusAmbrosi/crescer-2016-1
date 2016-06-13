package br.com.tarefa4.DAO;

import br.com.cwi.tarefa4.interfaces.IPedidoItem;
import br.com.cwi.tarefa4.utils.CSVUtils;
import br.com.tarefa4.entity.Cidade;
import br.com.tarefa4.entity.Cliente;
import br.com.tarefa4.entity.PedidoItem;
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
public class PedidoItemDAO implements IPedidoItem {

    static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRESCER16");
    static final EntityManager em = emf.createEntityManager();

    public EntityTransaction getTransaction() {
        return em.getTransaction();
    }

    @Override
    public void insert(PedidoItem pedidoItem) {
        EntityTransaction transaction = getTransaction();
        transaction.begin();
        Session session = em.unwrap(Session.class);
        session.save(pedidoItem);
        transaction.commit();
    }

    @Override
    public void update(PedidoItem pedidoItem) {
        if (pedidoItem.getIdPedidoItem() == null) {
            throw new IllegalArgumentException();
        }
        EntityTransaction transaction = getTransaction();
        transaction.begin();
        Session session = em.unwrap(Session.class);
        session.update(pedidoItem);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(PedidoItem pedidoItem) {
        if (pedidoItem.getIdPedidoItem() == null) {
            throw new IllegalArgumentException();
        }
        EntityTransaction transaction = getTransaction();
        transaction.begin();
        em.remove(em.contains(pedidoItem) ? pedidoItem : em.merge(pedidoItem));
        transaction.commit();
    }

    @Override
    public List<PedidoItem> listAll() {
        Session session = em.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Cidade.class);
        List<PedidoItem> pedidosItens = criteria.list();
        session.close();
        return pedidosItens;
    }

    @Override
    public List<PedidoItem> findBySituacao(boolean situacao) {
        Session session = em.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Cidade.class);
        criteria.add(Restrictions.like("situacao", situacao));
        List<PedidoItem> pedidosItens = criteria.list();
        session.close();
        return pedidosItens;
    }

    public void exportarCsv(String caminho) throws IOException {
        List<PedidoItem> pedidosItens = listAll();
        CSVUtils.gerarCsvPedidoItem(pedidosItens, caminho);
    }
}
