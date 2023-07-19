package pl.coderslab.constractorInvoices;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.contractors.Contractors;

import java.util.List;

@Repository
public interface ContractorInvoicesRepository extends JpaRepository<ContractorInvoices, Long> {


    List<ContractorInvoices> findByContractors(Contractors contractors);
}
