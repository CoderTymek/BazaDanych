package pl.coderslab.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
