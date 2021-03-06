package villagepeoplecottages.toimipiste;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import villagepeoplecottages.palvelu.Palvelu;
import villagepeoplecottages.varaus.Varaus;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Setter
public class Toimipiste extends AbstractPersistable<Long>{

	private String nimi;
    private String lahiosoite;
    private String postitoimipaikka;
    private String postinro;
    private String email;
    private String puhelinnro;
    
    @OneToMany(mappedBy="toimipiste")
    private List<Palvelu> palvelut;
    
    @OneToMany
    private List<Varaus> varaukset;
    
}
