package pl.coderslab.controller;



import org.springframework.web.bind.annotation.*;

import pl.coderslab.model.Customer;
import pl.coderslab.services.CustomerService;

import java.util.List;


@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getCustomers(){
        return customerService.getCustomers();
    }

    @GetMapping("/{pesel:\\d+}")
    public Customer getByPesel(@PathVariable Long pesel){
        return customerService.getCustomerByPesel(pesel);
    }

    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }

    @PutMapping("/{pesel:\\d+}")
    public Customer updateCustomer(@RequestBody Customer customer){
        customerService.updateCustomer(customer);
        return customer;
    }

    @DeleteMapping("/{pesel:\\d+}")
    public void deleteCustomer(@PathVariable Long pesel){
        customerService.deleteCustomer(pesel);
    }

}
