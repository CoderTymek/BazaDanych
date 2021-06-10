package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.coderslab.Repository.InformationRepository;
import pl.coderslab.Repository.OfferRepository;
import pl.coderslab.exceptions.ResourceNotFoundException;
import pl.coderslab.model.Customer;
import pl.coderslab.services.CustomerService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin/customers")
public class ManageCustomerController {
    private final CustomerService customerService;
    private final OfferRepository offerRepository;
    private final InformationRepository informationRepository;


    public ManageCustomerController(CustomerService customerService, OfferRepository offerRepository, InformationRepository informationRepository) {
        this.customerService = customerService;
        this.offerRepository = offerRepository;
        this.informationRepository = informationRepository;
    }

    @GetMapping("/all")
    public String showPosts(Model model){
        List<Customer> customers = customerService.getCustomers();
        model.addAttribute("customers", customers);
        model.addAttribute("customerSearchForm", new CustomerSearchForm());
        model.addAttribute("informations", this.informationRepository.findAll());
        return "index";
    }

    @PostMapping("/all")
    public String searchCustomers(CustomerSearchForm form, Model model){
        List<Customer> customers = new ArrayList<>();

        String text = form.getText();
        if (text != null && text.length() == 11)
        {
            try
            {
                Long pesel = Long.parseLong(text);
                customers.add(customerService.getCustomerByPesel(pesel));
            }
            catch (NumberFormatException ignored)
            {
            }
        }
        if (text != null)
        {
            customers.addAll(customerService.getCustomersByKeyword(text));
        }
        Information information = form.getInformation();
        boolean hasInformation = information != null && information.getId() != -1;
        if (hasInformation)
        {
            customers.addAll(customerService.getCustomersByInformation(information));
        }
        if ((text == null || text.isBlank()) && !hasInformation)
        {
            customers.addAll(customerService.getCustomers());
        }
        model.addAttribute("customers", customers);
        model.addAttribute("customerSearchForm", form);
        model.addAttribute("informations", this.informationRepository.findAll());
        return "index";
    }

    @GetMapping(value = "/add")
    public String showAddForm(Model model) {
        model.addAttribute("customer", new Customer());
        model.addAttribute("offers", this.offerRepository.findAll());
        model.addAttribute("informations", this.informationRepository.findAll());
        return "add";
    }

    @PostMapping(value = "/add")
    public String saveCustomer(@Valid Customer customer, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("offers", this.offerRepository.findAll());
            model.addAttribute("informations", this.informationRepository.findAll());
            return "add";
        }
        customerService.addCustomer(customer);
        return "redirect:/admin/customers/all";
    }

    @GetMapping(value = "/edit/{pesel}")
    public String showEditForm(@PathVariable long pesel, Model model) {
        Customer customer = customerService.getCustomerByPesel(pesel);
        if (customer == null) {
            throw new ResourceNotFoundException();
        }
        model.addAttribute("customer", customer);
        model.addAttribute("offers", this.offerRepository.findAll());
        model.addAttribute("informations", this.informationRepository.findAll());
        return "edit";
    }

    @PostMapping(value = "/edit/{pesel}")
    public String editCustomer(@PathVariable long pesel, @Valid Customer customer, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("offers", this.offerRepository.findAll());
            model.addAttribute("informations", this.informationRepository.findAll());
            return "edit";
        }
        if (customer.getPesel() != pesel) {
            customerService.deleteCustomer(pesel);
            customerService.addCustomer(customer);

        } else {
            customerService.updateCustomer(customer);
        }
        return "redirect:/admin/customers/all";
    }

    @PostMapping("/delete/{pesel}")
    public String deleteCustomer(@PathVariable long pesel, RedirectAttributes redirectAttributes) {
        customerService.deleteCustomer(pesel);
        redirectAttributes.addFlashAttribute("notification", "Udało się usunąć klienta");
        return "redirect:/admin/customers/all";
    }
}
