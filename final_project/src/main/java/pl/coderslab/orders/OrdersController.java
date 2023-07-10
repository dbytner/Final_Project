package pl.coderslab.orders;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.customers.Customer;
import pl.coderslab.customers.CustomerDao;

import java.awt.print.Book;

@Controller
@RequestMapping("/orders")
public class OrdersController {
    private final OrdersDao ordersDao;
    private final CustomerDao customerDao;

    public OrdersController(OrdersDao ordersDao, CustomerDao customerDao) {
        this.ordersDao = ordersDao;
        this.customerDao = customerDao;
    }


    @GetMapping("/add")
    public String test(Model model) {
        model.addAttribute("orders", new Orders());
        model.addAttribute("customers", customerDao.findAllCustomers());
        return "orders/form";
    }

    @PostMapping("/add")
    public String save(Orders orders) {
        orders.setCreated(orders.getCreated());
        ordersDao.save(orders);
        return "redirect:/orders/list";
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("orders", ordersDao.findAllOrders());
        return "orders/list";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable long id, Model model) {
        model.addAttribute("orders", ordersDao.find(id));
        model.addAttribute("customers", customerDao.findAllCustomers());
        return "orders/edit";
    }

    @PostMapping("/edit")
    public String updateOrders(Orders orders) {
        orders.setUpdated(orders.getUpdated());
        ordersDao.update(orders);
        return "redirect:/orders/list";
    }
    @GetMapping("/delete-confirm/{id}")
    public String deleteConfirm(@PathVariable long id, Model model) {
        model.addAttribute("orders", ordersDao.find(id));
        return "orders/delete";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        Orders orders = ordersDao.find(id);
        ordersDao.delete(orders);
        return "redirect:/orders/list";
    }
}
