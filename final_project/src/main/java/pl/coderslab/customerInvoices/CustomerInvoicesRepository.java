package pl.coderslab.customerInvoices;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.customers.Customer;

import java.util.List;

@Repository
public interface CustomerInvoicesRepository extends JpaRepository<CustomerInvoices, Long> {


    List<CustomerInvoices> findByCustomer(Customer customer);
}
