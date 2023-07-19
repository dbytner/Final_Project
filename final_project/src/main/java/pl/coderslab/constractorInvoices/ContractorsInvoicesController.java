package pl.coderslab.constractorInvoices;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.contractors.ContractorsDao;
import pl.coderslab.customerInvoices.CustomerInvoices;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/contractorInvoices")
public class ContractorsInvoicesController {
    private final ContractorInvoicesDao contractorInvoicesDao;
    private final ContractorsDao contractorsDao;

    public ContractorsInvoicesController(ContractorInvoicesDao contractorInvoicesDao, ContractorsDao contractorsDao) {
        this.contractorInvoicesDao = contractorInvoicesDao;
        this.contractorsDao = contractorsDao;
    }


    @GetMapping("/add")
    public String test1(Model model) {
        model.addAttribute("contractorInvoices", new ContractorInvoices());
        model.addAttribute("contractors", contractorsDao.findAllContractors());
        return "contractorInvoices/invoicesAdd";
    }

    @GetMapping("/add/{id}")
    public String add(@PathVariable long id, Model model) {
        model.addAttribute("contractorInvoices", new ContractorInvoices());
        model.addAttribute("contractor", contractorsDao.find(id));
        return "contractorInvoices/invoicesAddContractor";
    }

    @PostMapping("/add")
    public String save(ContractorInvoices contractorInvoices) {
        contractorInvoicesDao.save(contractorInvoices);
        return "redirect:/contractorInvoices/list";
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("contractorInvoices", contractorInvoicesDao.findAllInvoices());
        return "contractorInvoices/invoicesList";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable long id, Model model) {
        model.addAttribute("contractorInvoices", contractorInvoicesDao.find(id));
        model.addAttribute("contractors", contractorsDao.findAllContractors());
        return "contractorInvoices/invoicesEdit";
    }

    @PostMapping("/edit")
    public String updateInvoices(ContractorInvoices contractorInvoices) {
        contractorInvoicesDao.update(contractorInvoices);
        return "redirect:/contractorInvoices/list";
    }
    @GetMapping("/delete-confirm/{id}")
    public String deleteConfirm(@PathVariable long id, Model model) {
        model.addAttribute("contractorInvoices", contractorInvoicesDao.find(id));
        return "contractorInvoices/delete";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        ContractorInvoices contractorInvoices = contractorInvoicesDao.find(id);
        contractorInvoicesDao.delete(contractorInvoices);
        return "redirect:/contractorInvoices/list";
    }

    @GetMapping("/details/{id}")
    public String invoicesDetails(@PathVariable long id, Model model) {
        model.addAttribute("contractorInvoices", contractorInvoicesDao.find(id));
        return "contractorInvoices/invoicesDetails";
    }

    @ModelAttribute("invoicesType")
    public List<String> invoicesType() {
        return Arrays.asList("Sprzedażowa", "Zakupowa");
    }

    @ModelAttribute("invoicesStatus")
    public List<String> invoicesStatus() {
        return Arrays.asList("Wystawiona", "W trakcie realizacji", "Przesłana do klienta", "Czeka na płatność", "Opłacona");
    }
}
