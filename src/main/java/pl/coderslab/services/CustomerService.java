package pl.coderslab.services;

import pl.coderslab.model.Customer;


import java.util.List;

public interface CustomerService {

    Customer getCustomerByPesel(Long pesel);

    Customer addCustomer(Customer customerToAdd);

    void updateCustomer(Customer customerToUpdated);

    void deleteCustomer (Long pesel);

    List<Customer> getCustomers();
}
