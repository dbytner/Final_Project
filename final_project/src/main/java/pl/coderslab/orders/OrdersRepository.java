package pl.coderslab.orders;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.customers.Customer;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
    @Query("select o from Orders o where o.customer=?1")
    List<Orders> findByCustomer(Customer customer);
}
