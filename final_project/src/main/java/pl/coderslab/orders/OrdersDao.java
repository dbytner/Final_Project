package pl.coderslab.orders;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.customers.Customer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class OrdersDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void save(Orders orders){
        entityManager.persist(orders);
    }

    public Orders find(long id){
        return entityManager.find(Orders.class ,id);
    }


    public void update(Orders orders){
        entityManager.merge(orders);
    }

    public void delete(Orders orders){
        entityManager.remove(entityManager.contains(orders) ? orders: entityManager.merge(orders));
    }

    public List<Customer> findAllOrders(){
        return entityManager.createQuery("SELECT o FROM Orders o").getResultList();
    }
    public List<Orders> findCustomerOrders(long customerId){
        Query query = entityManager.createQuery("select o from Orders o where o.customer =: customerId");
        query.setParameter("customerId", customerId);
        return (List<Orders>) query;
    }
}
