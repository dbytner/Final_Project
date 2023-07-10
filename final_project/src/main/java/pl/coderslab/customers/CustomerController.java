package pl.coderslab.customers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerDao customerDao;

    public CustomerController(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }


    @GetMapping("/add")
    public String test(Model model) {
        model.addAttribute("customers", new Customer());
        return "customer/form";
    }

    @PostMapping("/add")
    public String save(Customer customer) {
        customerDao.save(customer);
        return "redirect:/customer/list";
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("customers", customerDao.findAllCustomers());
        return "customer/list";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable long id, Model model) {
        model.addAttribute("customers", customerDao.find(id));
        return "customer/edit";
    }

    @PostMapping("/edit")
    public String updateCategory(Customer customer) {
        customerDao.update(customer);
        return "redirect:/customer/list";
    }
    @GetMapping("/delete-confirm/{id}")
    public String deleteConfirm(@PathVariable long id, Model model) {
        model.addAttribute("customers", customerDao.find(id));
        return "customer/delete";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        Customer customer = customerDao.find(id);
        customerDao.delete(customer);
        return "redirect:/customer/list";
    }
}
