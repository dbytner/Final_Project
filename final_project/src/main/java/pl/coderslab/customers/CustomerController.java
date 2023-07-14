package pl.coderslab.customers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

    public CustomerController(CustomerDao customerDao, OrdersDao ordersDao, OrdersRepository ordersRepository) {
        this.customerDao = customerDao;
        this.ordersDao = ordersDao;
        this.ordersRepository = ordersRepository;
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
        List<Orders> ordersList = (List<Orders>) ordersRepository.findByCustomer(customer);
            if(ordersList.size()>0){
                model.addAttribute("customers", customer);
                return "customer/deleteError";
            }
//        for (Orders o: ordersList) {
//            ordersDao.delete(o);
//        }
        customerDao.delete(customer);
        return "redirect:/customer/list";
    }

    @GetMapping("/delete2/{id}")
    public String delete2(@PathVariable long id) {
        Customer customer = customerDao.find(id);
        List<Orders> ordersList = (List<Orders>) ordersRepository.findByCustomer(customer);
        for (Orders o: ordersList) {
            ordersDao.delete(o);
        }
        customerDao.delete(customer);
        return "redirect:/customer/list";
    }
}
