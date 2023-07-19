package pl.coderslab.invoices;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.contractors.ContractorsDao;
import pl.coderslab.customers.CustomerDao;
import pl.coderslab.production.ProductionDao;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/invoices")
public class InvoiceController {

//    private final InvoicesDao invoicesDao;
//    private final CustomerDao customerDao;
//
//    private final ContractorsDao contractorsDao;
//
//    public InvoiceController(InvoicesDao invoicesDao, ProductionDao productionDao, CustomerDao customerDao, ContractorsDao contractorsDao) {
//        this.invoicesDao = invoicesDao;
//        this.customerDao = customerDao;
//        this.contractorsDao = contractorsDao;
//    }

//    @GetMapping("/add1")
//    public String test1(Model model) {
//        model.addAttribute("invoices", new Invoices());
//        model.addAttribute("customers", customerDao.findAllCustomers());
//        return "invoicesAdd";
//    }
//    @GetMapping("/add2")
//    public String test2(Model model) {
//        model.addAttribute("invoices", new Invoices());
//        model.addAttribute("contractors", contractorsDao.findAllContractors());
//        return "invoicesAdd1";
//    }
//
//    @GetMapping("/add1/{id}")
//    public String add(@PathVariable long id, Model model) {
//        model.addAttribute("invoices", new Invoices());
//        model.addAttribute("customer", customerDao.find(id));
//        return "invoices/invoicesAddCustomer";
//    }
//    @GetMapping("/add2/{id}")
//    public String add2(@PathVariable long id, Model model) {
//        model.addAttribute("invoices", new Invoices());
//        model.addAttribute("contractors", contractorsDao.findAllContractors());
//        return "invoices/invoicesAddContractor";
//    }

//    @PostMapping("/add1")
//    public String save(Invoices invoices) {
//        invoicesDao.save(invoices);
//        return "redirect:/invoices/list1";
//    }

    @GetMapping("/list")
    public String list() {
        //model.addAttribute("invoices", invoicesDao.findAllInvoices());
        return "invoices/chooseInvoice";
    }

//    @GetMapping("/list1")
//    public String list1(Model model) {
//        model.addAttribute("invoices", invoicesDao.findAllInvoices());
//        return "invoicesList";
//    }
//    @GetMapping("/list2")
//    public String list2(Model model) {
//        model.addAttribute("invoices", invoicesDao.findAllInvoices());
//        return "contractorInvoices/invoicesList2";
//    }
//    @GetMapping("/edit1/{id}")
//    public String edit(@PathVariable long id, Model model) {
//        model.addAttribute("invoices", invoicesDao.find(id));
//        model.addAttribute("customers", customerDao.findAllCustomers());
//        return "invoices/invoicesEdit1";
//    }
//    @GetMapping("/edit2/{id}")
//    public String edit2(@PathVariable long id, Model model) {
//        model.addAttribute("invoices", invoicesDao.find(id));
//        model.addAttribute("contractors", contractorsDao.findAllContractors());
//        return "invoices/invoicesEdit2";
//    }
//
//    @PostMapping("/edit")
//    public String updateInvoices(Invoices invoices) {
//        invoicesDao.update(invoices);
//        return "redirect:/invoices/list";
//    }
//    @GetMapping("/delete-confirm/{id}")
//    public String deleteConfirm(@PathVariable long id, Model model) {
//        model.addAttribute("invoices", invoicesDao.find(id));
//        return "invoices/delete";
//    }
//
//    @GetMapping("/delete/{id}")
//    public String delete(@PathVariable long id) {
//        Invoices invoices = invoicesDao.find(id);
//        invoicesDao.delete(invoices);
//        return "redirect:/invoices/list";
//    }
//
//    @GetMapping("/details/{id}")
//    public String invoicesDetails(@PathVariable long id, Model model) {
//        model.addAttribute("invoices", invoicesDao.find(id));
//        return "invoices/invoicesDetails";
//    }
//
//    @ModelAttribute("invoicesType")
//    public List<String> invoicesType() {
//        return Arrays.asList("Sprzedażowa", "Zakupowa");
//    }
//
//    @ModelAttribute("invoicesStatus")
//    public List<String> invoicesStatus() {
//        return Arrays.asList("Wystawiona", "W trakcie realizacji", "Przesłana do klienta", "Czeka na płatność", "Opłacona");
//    }
}
