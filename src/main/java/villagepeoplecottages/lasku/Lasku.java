package villagepeoplecottages.lasku;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import villagepeoplecottages.asiakas.Asiakas;
import villagepeoplecottages.varaus.Varaus;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Lasku extends AbstractPersistable<Long> {

	private String tila;
    private String nimi;
    private String lahiosoite;
    private String postitoimipaikka;
    private String postinro;
    private double summa;
    private double alv;
    private LocalDate paivays;
    
    private String toimipiste;
    
    @ManyToOne
    private Asiakas asiakas;
    
    @ManyToOne
    private Varaus varaus;
    
}
