package pl.coderslab.customers;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class CustomerDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Customer customer){
        entityManager.persist(customer);
    }

    public Customer find(long id){
        return entityManager.find(Customer.class ,id);
    }

    public void update(Customer customer){
        entityManager.merge(customer);
    }

    public void delete(Customer customer){
        entityManager.remove(entityManager.contains(customer) ? customer: entityManager.merge(customer));
    }

    public List<Customer> findAllCustomers(){
        return entityManager.createQuery("SELECT c FROM Customer c").getResultList();
    }
}
