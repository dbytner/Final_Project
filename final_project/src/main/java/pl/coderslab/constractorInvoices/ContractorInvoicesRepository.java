package pl.coderslab.constractorInvoices;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractorInvoicesRepository extends JpaRepository<ContractorInvoices, Long> {
}
