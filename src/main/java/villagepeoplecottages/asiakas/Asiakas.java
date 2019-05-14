package villagepeoplecottages.asiakas;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import villagepeoplecottages.Lasku.Lasku;
import villagepeoplecottages.varaus.Varaus;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Asiakas extends AbstractPersistable<Long> {

    private String etunimi;
    private String sukunimi;
    private String lahiosoite;
    private String postitoimipaikka;
    private String postinro;
    private String email;
    private String puhelinnro;
    
    @OneToMany
    private List<Varaus> varaukset;
    
    @OneToMany
    private List<Lasku> laskut;
}
