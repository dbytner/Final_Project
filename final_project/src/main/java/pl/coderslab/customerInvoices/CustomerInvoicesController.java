package pl.coderslab.customerInvoices;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.customers.CustomerDao;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/customerInvoices")
public class CustomerInvoicesController {
    private final CustomerInvoicesDao customerInvoicesDao;
    private final CustomerDao customerDao;

    public CustomerInvoicesController(CustomerInvoicesDao invoicesDao, CustomerDao customerDao) {
        this.customerInvoicesDao = invoicesDao;
        this.customerDao = customerDao;
    }


    @GetMapping("/add")
    public String test1(Model model) {
        model.addAttribute("customerInvoices", new CustomerInvoices());
        model.addAttribute("customers", customerDao.findAllCustomers());
        return "customerInvoices/invoicesAdd";
    }

    @GetMapping("/add/{id}")
    public String add(@PathVariable long id, Model model) {
        model.addAttribute("customerInvoices", new CustomerInvoices());
        model.addAttribute("customer", customerDao.find(id));
        return "customerInvoices/invoicesAddCustomer";
    }

    @PostMapping("/add")
    public String save(CustomerInvoices customerInvoices) {
        customerInvoicesDao.save(customerInvoices);
        return "redirect:/customerInvoices/list";
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("customerInvoices", customerInvoicesDao.findAllInvoices());
        return "customerInvoices/invoicesList";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable long id, Model model) {
        model.addAttribute("customerInvoices", customerInvoicesDao.find(id));
        model.addAttribute("customers", customerDao.findAllCustomers());
        return "customerInvoices/invoicesEdit";
    }

    @PostMapping("/edit")
    public String updateInvoices(CustomerInvoices customerInvoices) {
        customerInvoicesDao.update(customerInvoices);
        return "redirect:/customerInvoices/list";
    }
    @GetMapping("/delete-confirm/{id}")
    public String deleteConfirm(@PathVariable long id, Model model) {
        model.addAttribute("customerInvoices", customerInvoicesDao.find(id));
        return "customerInvoices/delete";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        CustomerInvoices customerInvoices = customerInvoicesDao.find(id);
        customerInvoicesDao.delete(customerInvoices);
        return "redirect:/customerInvoices/list";
    }

    @GetMapping("/details/{id}")
    public String invoicesDetails(@PathVariable long id, Model model) {
        model.addAttribute("customerInvoices", customerInvoicesDao.find(id));
        return "customerInvoices/invoicesDetails";
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
