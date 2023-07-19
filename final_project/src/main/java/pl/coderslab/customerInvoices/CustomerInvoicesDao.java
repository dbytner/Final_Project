package pl.coderslab.customerInvoices;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class CustomerInvoicesDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(CustomerInvoices customerInvoices){
        entityManager.persist(customerInvoices);
    }

    public CustomerInvoices find(long id){
        return entityManager.find(CustomerInvoices.class ,id);
    }


    public void update(CustomerInvoices customerInvoices){
        entityManager.merge(customerInvoices);
    }

    public void delete(CustomerInvoices customerInvoices){
        entityManager.remove(entityManager.contains(customerInvoices) ? customerInvoices: entityManager.merge(customerInvoices));
    }

    public List<CustomerInvoices> findAllInvoices(){
        return entityManager.createQuery("SELECT i FROM CustomerInvoices i").getResultList();
    }
    public List<CustomerInvoices> findCustomerInvoices(long customerId){
        Query query = entityManager.createQuery("select i from CustomerInvoices i where i.customer =: customerId");
        query.setParameter("customerId", customerId);
        return (List<CustomerInvoices>) query;
    }
}
