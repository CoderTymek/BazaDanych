package pl.coderslab.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.model.Customer;
import pl.coderslab.model.Information;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByInformation(Information information);

    List<Customer> findByNameOrSurnameOrPhoneNumber(String name, String surname, String phoneNumber);
}
