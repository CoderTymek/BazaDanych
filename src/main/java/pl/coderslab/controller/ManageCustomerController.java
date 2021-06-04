package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.model.Customer;
import pl.coderslab.services.CustomerService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin/customers")
public class ManageCustomerController {
    private final CustomerService customerService;

    public ManageCustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/all")
    public String showPosts(Model model){
        List<Customer> customers = customerService.getCustomers();
        model.addAttribute("customers", customers);
        return "index";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showAddForm(Model model){
        model.addAttribute("customer", new Customer());
        return "add";
    }

    @RequestMapping(value="/add", method = RequestMethod.POST)
    public String saveBook(@Valid Customer customer, BindingResult result){
        if(result.hasErrors()){
            return "/add";
        }
        customerService.addCustomer(customer);
        return "redirect:/admin/customers/all";
    }
}
