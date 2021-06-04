package pl.coderslab.services.web;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pl.coderslab.Repository.CustomerRepository;
import pl.coderslab.model.Customer;
import pl.coderslab.services.CustomerService;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class JpaCustomerService implements CustomerService {

    private final CustomerRepository customerRepository;


    public JpaCustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerByPesel(Long pesel) {
        return null;
    }

    @Override
    public Customer addCustomer(Customer customerToAdd) {
        return customerRepository.save(customerToAdd);
    }

    @Override
    public void updateCustomer(Customer customerToUpdated) {

    }

    @Override
    public void deleteCustomer(Long pesel) {

    }




}
