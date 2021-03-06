package villagepeoplecottages.varaus;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import villagepeoplecottages.asiakas.Asiakas;
import villagepeoplecottages.lasku.Lasku;
import villagepeoplecottages.palvelu.Palvelu;
import villagepeoplecottages.toimipiste.Toimipiste;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Varaus extends AbstractPersistable<Long> {
	
	private LocalDate varattuPvm;
    private LocalDate vahvistusPvm;
    
    @ManyToMany
    private List<Palvelu> palvelut;
    
    @OneToMany
    private List<Lasku> laskut;
    
    @ManyToOne
    private Asiakas asiakas;
    
    @ManyToOne
    private Toimipiste toimipiste;

}
