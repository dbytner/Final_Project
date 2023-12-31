package pl.coderslab.orders;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.customers.Customer;
import pl.coderslab.customers.CustomerDao;

import java.awt.print.Book;
import java.util.Arrays;
import java.util.List;

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
        return "orders/ordersAdd";
    }

    @GetMapping("/add/{id}")
    public String add(@PathVariable long id, Model model) {
        model.addAttribute("orders", new Orders());
        model.addAttribute("customer", customerDao.find(id));
        return "orders/ordersAddCustomer";
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
        return "orders/ordersList";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable long id, Model model) {
        model.addAttribute("orders", ordersDao.find(id));
        model.addAttribute("customers", customerDao.findAllCustomers());
        return "orders/ordersEdit";
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

    @GetMapping("/details/{id}")
    public String ordersDetails(@PathVariable long id, Model model) {
        model.addAttribute("orders", ordersDao.find(id));
        return "orders/ordersDetails";
    }

    @ModelAttribute("ordersType")
    public List<String> ordersType() {
        return Arrays.asList("Wizytówki", "Banery", "Ulotki", "Plakaty", "Rollup");
    }

    @ModelAttribute("ordersStatus")
    public List<String> ordersStatus() {
        return Arrays.asList("Rozpoczęte", "W trakcie realizacji", "Montaż", "U klienta", "Czeka na płatność", "Zakończone");
    }
}
