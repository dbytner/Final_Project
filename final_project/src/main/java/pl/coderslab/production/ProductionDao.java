package pl.coderslab.production;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.customers.Customer;
import pl.coderslab.orders.Orders;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class ProductionDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void save(Production production){
        entityManager.persist(production);
    }

    public Production find(long id){
        return entityManager.find(Production.class ,id);
    }

    public void update(Production production){
        entityManager.merge(production);
    }

    public void delete(Production production){
        entityManager.remove(entityManager.contains(production) ? production: entityManager.merge(production));
    }

    public List<Production> findAllProductions(){
        return entityManager.createQuery("SELECT p FROM Production p").getResultList();
    }
}
