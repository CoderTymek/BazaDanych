package pl.coderslab.services.web;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pl.coderslab.Repository.CustomerRepository;
import pl.coderslab.model.Customer;
import pl.coderslab.model.Information;
import pl.coderslab.services.CustomerService;

import java.util.List;

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
    public List<Customer> getCustomersByKeyword(String keyword) {
        return customerRepository.findByNameOrSurnameOrPhoneNumber(keyword, keyword, keyword);
    }

    @Override
    public Customer getCustomerByPesel(Long pesel) {
        return this.customerRepository.findById(pesel).orElse(null);
    }

    @Override
    public Customer addCustomer(Customer customerToAdd) {
        return customerRepository.save(customerToAdd);
    }

    @Override
    public void updateCustomer(Customer customerToUpdated) {
        customerRepository.save(customerToUpdated);
    }

    @Override
    public void deleteCustomer(Long pesel) {
        customerRepository.deleteById(pesel);
    }

    @Override
    public List<Customer> getCustomersByInformation(Information information) {
        return customerRepository.findByInformation(information);
    }
}
