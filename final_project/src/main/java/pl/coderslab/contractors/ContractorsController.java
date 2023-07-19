package pl.coderslab.contractors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.constractorInvoices.ContractorInvoices;
import pl.coderslab.constractorInvoices.ContractorInvoicesRepository;
import pl.coderslab.customerInvoices.CustomerInvoices;
import pl.coderslab.customerInvoices.CustomerInvoicesRepository;
import pl.coderslab.production.Production;
import pl.coderslab.production.ProductionRepository;

import java.util.List;

@Controller
@RequestMapping("/contractors")
public class ContractorsController {

    private final ContractorsDao contractorsDao;
    private final ProductionRepository productionRepository;
    private final ContractorInvoicesRepository contractorInvoicesRepository;


    public ContractorsController(ContractorsDao contractorsDao, ProductionRepository productionRepository, ContractorInvoicesRepository contractorInvoicesRepository) {
        this.contractorsDao = contractorsDao;
        this.productionRepository = productionRepository;
        this.contractorInvoicesRepository = contractorInvoicesRepository;
    }


    @GetMapping("/add")
    public String test(Model model) {
        model.addAttribute("contractors", new Contractors());
        return "contractors/contractorsAdd";
    }

    @PostMapping("/add")
    public String save(Contractors contractors) {
        contractorsDao.save(contractors);
        return "redirect:/contractors/list";
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("contractors", contractorsDao.findAllContractors());
        return "contractors/contractorsList";
    }

    @GetMapping("/productionList/{id}")
    public String list1(@PathVariable long id, Model model) {
        Contractors contractors = contractorsDao.find(id);
        List<Production> productionList = productionRepository.findByContractors(contractors);
        model.addAttribute("productions", productionList);
        return "contractors/productionsList";
    }
    @GetMapping("/invoicesList/{id}")
    public String list2(@PathVariable long id, Model model) {
        Contractors contractors = contractorsDao.find(id);
        List<ContractorInvoices> contractorInvoicesList = contractorInvoicesRepository.findByContractors(contractors);
        model.addAttribute("invoices", contractorInvoicesList);
        return "contractors/invoicesList";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable long id, Model model) {
        model.addAttribute("contractors", contractorsDao.find(id));
        return "contractors/contractorsEdit";
    }

    @PostMapping("/edit")
    public String updateContractors(Contractors contractors) {
        contractorsDao.update(contractors);
        return "redirect:/contractors/list";
    }
    @GetMapping("/delete-confirm/{id}")
    public String deleteConfirm(@PathVariable long id, Model model) {
        model.addAttribute("contractors", contractorsDao.find(id));
        return "contractors/delete";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        Contractors contractors = contractorsDao.find(id);
        contractorsDao.delete(contractors);
        return "redirect:/contractors/list";
    }
    @GetMapping("/details/{id}")
    public String contractorsDetails(@PathVariable long id, Model model) {
        model.addAttribute("contractors", contractorsDao.find(id));
        return "contractors/contractorsDetails";
    }
}
