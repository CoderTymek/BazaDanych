package pl.coderslab.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.model.Offer;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {

}
