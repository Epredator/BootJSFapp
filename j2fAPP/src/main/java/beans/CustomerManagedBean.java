package beans;

import model.Customer;
import org.springframework.dao.DataAccessException;
import service.CustomerService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "customerMB")
@RequestScoped
public class CustomerManagedBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final String SUCCESS = "success";
    private static final String ERROR = "error";

    //spring customer service is injected
    @ManagedProperty(value = "#{CustomerService")
    CustomerService customerService;
    List<Customer> customerList;

    private int id;
    private String name;
    private String surname;

    public String addCustomer() {
        try {
            Customer customer = new Customer();
            customer.setId(getId());
            customer.setName(getName());
            customer.setSurname(getSurname());
            getCustomerService().addCustomer(customer);
            return SUCCESS;
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return ERROR;
    }

    public void reset() {
        this.setId(0);
        this.setName("");
        this.setSurname("");
    }

    public List<Customer> getCustomerList() {
        customerList = new ArrayList<Customer>();
        customerList.addAll((getCustomerService().getCustomers()));
        return customerList;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public CustomerService getCustomerService() {
        return customerService;
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
