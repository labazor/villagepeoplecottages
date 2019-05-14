package villagepeoplecottages.palvelu;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import villagepeoplecottages.toimipiste.Toimipiste;
import villagepeoplecottages.varaus.Varaus;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Palvelu extends AbstractPersistable<Long> {
	
    private String nimi;
    private String tyyppi;
    private String kuvaus;
    private double hinta;
    private double alv;
    
    @ManyToOne
    private Toimipiste toimipiste;
    
    @ManyToMany
    private List<Varaus> varaukset;

}
