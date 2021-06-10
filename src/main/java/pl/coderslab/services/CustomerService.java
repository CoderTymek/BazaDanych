package pl.coderslab.services;

import pl.coderslab.model.Customer;
import pl.coderslab.model.Information;


import java.util.List;

public interface CustomerService {

    Customer getCustomerByPesel(Long pesel);

    List<Customer> getCustomersByKeyword(String keyword);

    Customer addCustomer(Customer customerToAdd);

    void updateCustomer(Customer customerToUpdated);

    void deleteCustomer (Long pesel);

    List<Customer> getCustomers();

    List<Customer> getCustomersByInformation(Information information);
}
