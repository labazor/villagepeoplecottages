package villagepeoplecottages.toimipiste;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ToimipisteRepository extends JpaRepository<Toimipiste, Long> {

	Toimipiste findByNimi(String nimi);
}
