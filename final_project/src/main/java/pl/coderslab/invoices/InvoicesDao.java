//package pl.coderslab.invoices;
//
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//import pl.coderslab.customers.Customer;
//import pl.coderslab.orders.Orders;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.persistence.Query;
//import java.util.List;
//
//@Repository
//@Transactional
//public class InvoicesDao {
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    public void save(Invoices invoices){
//        entityManager.persist(invoices);
//    }
//
//    public Invoices find(long id){
//        return entityManager.find(Invoices.class ,id);
//    }
//
//
//    public void update(Invoices invoices){
//        entityManager.merge(invoices);
//    }
//
//    public void delete(Invoices invoices){
//        entityManager.remove(entityManager.contains(invoices) ? invoices: entityManager.merge(invoices));
//    }
//
//    public List<Customer> findAllInvoices(){
//        return entityManager.createQuery("SELECT i FROM CustomerInvoices i").getResultList();
//    }
//    public List<Invoices> findCustomerInvoices(long customerId){
//        Query query = entityManager.createQuery("select i from CustomerInvoices i where i.customer =: customerId");
//        query.setParameter("customerId", customerId);
//        return (List<Invoices>) query;
//    }
//}
