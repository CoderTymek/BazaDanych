package pl.coderslab.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.model.Information;

@Repository
public interface InformationRepository extends JpaRepository<Information,Long> {
}
