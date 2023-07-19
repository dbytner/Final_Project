package pl.coderslab.customers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.customerInvoices.CustomerInvoices;
import pl.coderslab.customerInvoices.CustomerInvoicesRepository;
import pl.coderslab.orders.Orders;
import pl.coderslab.orders.OrdersDao;
import pl.coderslab.orders.OrdersRepository;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerDao customerDao;
    private final OrdersDao ordersDao;
    private final OrdersRepository ordersRepository;
    private final CustomerInvoicesRepository customerInvoicesRepository;


    public CustomerController(CustomerDao customerDao, OrdersDao ordersDao, OrdersRepository ordersRepository, CustomerInvoicesRepository customerInvoicesRepository) {
        this.customerDao = customerDao;
        this.ordersDao = ordersDao;
        this.ordersRepository = ordersRepository;
        this.customerInvoicesRepository = customerInvoicesRepository;
    }


    @GetMapping("/add")
    public String test(Model model) {
        model.addAttribute("customers", new Customer());
        return "customer/customerAdd";
    }

    @PostMapping("/add")
    public String save(Customer customer) {
        customerDao.save(customer);
        return "redirect:/customer/list";
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("customers", customerDao.findAllCustomers());
        return "customer/customerList";
    }
    @GetMapping("/ordersList/{id}")
    public String list1(@PathVariable long id, Model model) {
        Customer customer = customerDao.find(id);
        List<Orders> ordersList = ordersRepository.findByCustomer(customer);
        model.addAttribute("orders", ordersList);
        return "customer/ordersList";
    }
    @GetMapping("/invoicesList/{id}")
    public String list2(@PathVariable long id, Model model) {
        Customer customer = customerDao.find(id);
        List<CustomerInvoices> customerInvoicesList = customerInvoicesRepository.findByCustomer(customer);
        model.addAttribute("invoices", customerInvoicesList);
        return "customer/invoicesList";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable long id, Model model) {
        model.addAttribute("customers", customerDao.find(id));
        return "customer/customerEdit";
    }

    @PostMapping("/edit")
    public String updateCustomer(Customer customer) {
        customerDao.update(customer);
        return "redirect:/customer/list";
    }
    @GetMapping("/delete-confirm/{id}")
    public String deleteConfirm(@PathVariable long id, Model model) {
        model.addAttribute("customers", customerDao.find(id));
        return "customer/delete";
    }
    @GetMapping("/delete-confirm2/{id}")
    public String deleteConfirm2(@PathVariable long id, Model model) {
        model.addAttribute("customers", customerDao.find(id));
        return "customer/delete";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id, Model model) {
        Customer customer = customerDao.find(id);
        List<Orders> ordersList = ordersRepository.findByCustomer(customer);
        List<CustomerInvoices> customerInvoicesList = customerInvoicesRepository.findByCustomer(customer);
            if(ordersList.size()>0 || customerInvoicesList.size()>0){
                return "customer/deleteError";
            }
        customerDao.delete(customer);
        return "redirect:/customer/list";
    }

//    @GetMapping("/delete2/{id}")
//    public String delete2(@PathVariable long id) {
//        Customer customer = customerDao.find(id);
//        List<Orders> ordersList = (List<Orders>) ordersRepository.findByCustomer(customer);
//        for (Orders o: ordersList) {
//            ordersDao.delete(o);
//        }
//        customerDao.delete(customer);
//        return "redirect:/customer/list";
//    }
}
