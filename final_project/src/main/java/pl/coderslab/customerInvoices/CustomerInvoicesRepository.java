package pl.coderslab.customerInvoices;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerInvoicesRepository extends JpaRepository<CustomerInvoices, Long> {
}
