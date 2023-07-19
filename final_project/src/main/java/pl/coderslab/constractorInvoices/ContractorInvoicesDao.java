package pl.coderslab.constractorInvoices;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.customerInvoices.CustomerInvoices;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class ContractorInvoicesDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(ContractorInvoices contractorInvoices){
        entityManager.persist(contractorInvoices);
    }

    public ContractorInvoices find(long id){
        return entityManager.find(ContractorInvoices.class ,id);
    }


    public void update(ContractorInvoices contractorInvoices){
        entityManager.merge(contractorInvoices);
    }

    public void delete(ContractorInvoices contractorInvoices){
        entityManager.remove(entityManager.contains(contractorInvoices) ? contractorInvoices: entityManager.merge(contractorInvoices));
    }

    public List<CustomerInvoices> findAllInvoices(){
        return entityManager.createQuery("SELECT i FROM ContractorInvoices i").getResultList();
    }
    public List<ContractorInvoices> findContractorInvoices(long contractorId){
        Query query = entityManager.createQuery("select i from ContractorInvoices i where i.contractors =: contractorId");
        query.setParameter("contractorId", contractorId);
        return (List<ContractorInvoices>) query;
    }
}
