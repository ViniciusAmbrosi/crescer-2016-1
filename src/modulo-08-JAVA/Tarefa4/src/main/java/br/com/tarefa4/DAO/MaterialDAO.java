package br.com.tarefa4.DAO;

import br.com.cwi.tarefa4.interfaces.IMaterial;
import br.com.cwi.tarefa4.utils.CSVUtils;
import br.com.tarefa4.entity.Cidade;
import br.com.tarefa4.entity.Cliente;
import br.com.tarefa4.entity.Material;
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
public class MaterialDAO implements IMaterial {

    static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRESCER16");
    static final EntityManager em = emf.createEntityManager();

    public EntityTransaction getTransaction() {
        return em.getTransaction();
    }

    @Override
    public void insert(Material material) {
        if (material.getIdMaterial() == null) {
            throw new IllegalArgumentException();
        }
        EntityTransaction transaction = getTransaction();
        transaction.begin();
        Session session = em.unwrap(Session.class);
        session.save(material);
        transaction.commit();
    }

    @Override
    public void update(Material material) {
        if (material.getIdMaterial() == null) {
            throw new IllegalArgumentException();
        }
        EntityTransaction transaction = getTransaction();
        transaction.begin();
        Session session = em.unwrap(Session.class);
        session.update(material);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Material material) {
        if (material.getIdMaterial() == null) {
            throw new IllegalArgumentException();
        }
        EntityTransaction transaction = getTransaction();
        transaction.begin();
        em.remove(em.contains(material) ? material : em.merge(material));
        transaction.commit();
    }

    @Override
    public List<Material> listAll() {
        Session session = em.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Cidade.class);
        List<Material> material = criteria.list();
        session.close();
        return material;
    }

    @Override
    public List<Material> findDescricao(String descricao) {
        Session session = em.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Cidade.class);
        criteria.add(Restrictions.like("descricao", descricao));
        List<Material> material = criteria.list();
        session.close();
        return material;
    }
    
    @Override
    public void exportarCsv(String caminho) throws IOException {
        List<Material> materiais = listAll();
        CSVUtils.gerarCsvMaterial(materiais, caminho);
    }
}
