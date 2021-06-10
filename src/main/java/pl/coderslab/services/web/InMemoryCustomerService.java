package pl.coderslab.services.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pl.coderslab.exceptions.BadResourceException;
import pl.coderslab.exceptions.ResourceNotFoundException;
import pl.coderslab.model.Customer;
import pl.coderslab.model.Information;
import pl.coderslab.services.CustomerService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class InMemoryCustomerService implements CustomerService {
    private static final Logger log = LoggerFactory.getLogger(InMemoryCustomerService.class);


    private final List<Customer> list;

    public InMemoryCustomerService() {
        log.info("Tworzenie listy klientow...");
        list = new ArrayList<>();

//        list.add(new Customer(11111111111L, "Tymek", "Pazur", "Wrocław",
//                "123456789", "Przedstaw ofertę",false));
//        list.add(new Customer(21111111111L, "Tymekk", "Pazurr", "Wrocławw",
//                "1234567891", "Oddzwoń",true));
//        list.add(new Customer(31111111111L, "Tymekkk", "Pazurrr", "Wrocławww",
//                "12345678911", "Formularz",true));
    }
    @Override
    public List<Customer> getCustomers (){
        return list;
    }

    @Override
    public Customer getCustomerByPesel(Long pesel){
        log.debug("Pobieranie książki o id:{}", pesel);
        Customer foundCustomer = list.stream()
                .filter(customer -> customer.getPesel().equals(pesel))
                .findFirst()
                .orElseThrow(ResourceNotFoundException::new);
        log.debug("Znaleziony klient: {}",foundCustomer);
        return foundCustomer;
    }

    @Override
    public List<Customer> getCustomersByKeyword(String keyword) {
        return Collections.emptyList();
    }

    @Override
    public Customer addCustomer(Customer customerToAdd){
        log.debug("Dodawanie klienta:{}", customerToAdd);
        if(customerToAdd.getName() == null) {
            throw new BadResourceException("Customer must have an name");
        }
        log.debug("Ustalone id dla klienta:{}",customerToAdd.getPesel());
        list.add(customerToAdd);
        return customerToAdd;
    }

    @Override
    public void updateCustomer(Customer customerToUpdated){
        log.debug("Aktualizacja klienta: {}", customerToUpdated);
        log.debug("Liczba klientów przed aktualizacją: {}", list.size());
        list.stream()
                .filter(customer -> customer.getPesel().equals(customerToUpdated.getPesel()))
                .map(list::indexOf)
                .findFirst()
                .ifPresentOrElse(index -> list.set(index, customerToUpdated), () ->{
                    throw new ResourceNotFoundException();
                });
    }

    @Override
    public void deleteCustomer(Long pesel){
        log.debug("Liczba klientów przed usunięciem: {}", list.size());
        list.stream()
                .filter(customer -> customer.getPesel().equals(pesel))
                .findFirst()
                .ifPresentOrElse(list::remove,() ->{
                    throw new ResourceNotFoundException();
                });
        log.debug("Liczba klientów po usunięciu: {}", list.size());
    }

    @Override
    public List<Customer> getCustomersByInformation(Information information) {
        return Collections.emptyList();
    }
}
