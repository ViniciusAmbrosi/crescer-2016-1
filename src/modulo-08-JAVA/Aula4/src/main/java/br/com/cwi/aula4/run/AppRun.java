package br.com.cwi.aula4.run;

import br.com.cwi.aula4.entity.Pessoa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class AppRun {

    static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRESCER16");
    static final EntityManager em = emf.createEntityManager();

    public static void main(String[] args) {
        
        em.isOpen();
        em.close();
        /*
        Query query = em.createNamedQuery("findAll");
        query.setMaxResults(1);
        */
        
        /*
        String Carlos = "Carlos";
        String nmPessoa = "nmPessoa";
        Session session = em.unwarp(Session.class);
        Criteria criteria = session.createCriteria(Pessoa.class);
        criteria.add(Restrictions.islike(nmPessoa, Carlos, MatchMode.ANYWHERE);
        */
        
        /*em.getTransaction().begin();
        Pessoa pessoa = new Pessoa("Carlos");
        em.persist(pessoa);
        em.getTransaction().commit();*/

        //Query query = em.createQuery("SELECT p FROM Pessoa p");
        //List<Pessoa> pessoas = query.getResultList();
        //exibir dados

        /*Query query = em.createNamedQuery("Pessoa.findByName");
        query.setParameter("nmPessoa", "%Carlos%".toUpperCase());
        List<Pessoa> list = query.getResultList();*/
        
        /*em.getTransaction().begin();
        list.stream().forEach((p) -> {
            em.remove(p);
        });
        em.getTransaction().commit();*/
        
        /*
        em.getTransaction().begin();
        Pessoa pessoa = new Pessoa("Carlos");
        em.persist(pessoa);
        em.getTransaction().commit();*/
        
        /*em.getTransaction().begin();
        Pessoa pessoa = new Pessoa("CarlosHibernate");
        em.persist(pessoa);
        em.getTransaction().commit();
        
        em.close();
        emf.close();*/

    }
}
