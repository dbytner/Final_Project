//package pl.coderslab.invoices;
//
//import pl.coderslab.contractors.Contractors;
//import pl.coderslab.customers.Customer;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotNull;
//import java.sql.Date;
//
//@Entity
//public class Invoices {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id", nullable = false)
//    private Long id;
//    private String invoicesNumber;
//    private String type;
//    private Double value;
//    private String status;
//    private String paymentTime;
//
//    @ManyToOne
//    private Customer customer;
//
//    @ManyToOne
//    private Contractors contractors;
//
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getInvoicesNumber() {
//        return invoicesNumber;
//    }
//
//    public void setInvoicesNumber(String invoicesNumber) {
//        this.invoicesNumber = invoicesNumber;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    public Double getValue() {
//        return value;
//    }
//
//    public void setValue(Double value) {
//        this.value = value;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public String getPaymentTime() {
//        return paymentTime;
//    }
//
//    public void setPaymentTime(String paymentTime) {
//        this.paymentTime = paymentTime;
//    }
//
//    public Customer getCustomer() {
//        return customer;
//    }
//
//    public void setCustomer(Customer customer) {
//        this.customer = customer;
//    }
//
//    public Contractors getContractors() {
//        return contractors;
//    }
//
//    public void setContractors(Contractors contractors) {
//        this.contractors = contractors;
//    }
//}
