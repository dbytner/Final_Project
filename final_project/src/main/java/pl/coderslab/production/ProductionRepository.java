package pl.coderslab.production;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.contractors.Contractors;

import java.util.List;

@Repository
public interface ProductionRepository extends JpaRepository<Production, Long> {

    List<Production> findByContractors(Contractors contractors);
}
