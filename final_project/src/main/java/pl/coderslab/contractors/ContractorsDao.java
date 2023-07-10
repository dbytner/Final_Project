package pl.coderslab.contractors;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.customers.Customer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class ContractorsDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void save(Contractors contractors){
        entityManager.persist(contractors);
    }

    public Contractors find(long id){
        return entityManager.find(Contractors.class ,id);
    }

    public void update(Contractors contractors){
        entityManager.merge(contractors);
    }

    public void delete(Contractors contractors){
        entityManager.remove(entityManager.contains(contractors) ? contractors: entityManager.merge(contractors));
    }

    public List<Customer> findAllContractors(){
        return entityManager.createQuery("SELECT c FROM Contractors c").getResultList();
    }
}
