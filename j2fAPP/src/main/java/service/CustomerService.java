package service;

//CustomerService class provides methods to process the business logic using @Service annotation.

import model.Customer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.dao.CustomerDAO;

import java.util.List;

@Service("CustomerService")
@Transactional(readOnly = true)
public class CustomerService {

    //customerDAO is injected
    CustomerDAO customerDAO;

    @Transactional(readOnly = false)
    public void addCustomer(Customer customer) {
        getCustomerDAO().addCustomer(customer);
    }

    @Transactional(readOnly = false)
    public void deleteCustomer(Customer customer) {
        getCustomerDAO().deleteCustomer(customer);
    }

    @Transactional(readOnly = false)
    public void updateCustomer(Customer customer) {
        getCustomerDAO().updateCustomer(customer);
    }

    public Customer getCustomerById(int id) {
        return getCustomerDAO().getCustomerById(id);
    }

    public List<Customer> getCustomers() {
        return getCustomerDAO().getCustomers();
    }

    public CustomerDAO getCustomerDAO() {
        return customerDAO;
    }

    public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }
}
