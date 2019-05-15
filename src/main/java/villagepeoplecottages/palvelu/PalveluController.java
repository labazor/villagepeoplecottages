package villagepeoplecottages.palvelu;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import villagepeoplecottages.toimipiste.Toimipiste;
import villagepeoplecottages.toimipiste.ToimipisteRepository;

@Controller
public class PalveluController {
	
	@Autowired
	PalveluRepository palvelurepository;
	
	@Autowired
	ToimipisteRepository toimipisteRepository;

	@GetMapping("/palvelut")
	public String getPalvelu(Model model) {
		
		model.addAttribute("module", "palvelut");
		
		model.addAttribute("palvelut", palvelurepository.findAll());
		
		return "palvelu";
	}
	
	@GetMapping("/palvelut/uusi")
	public String uusiPalvelu(Model model) {
		
		model.addAttribute("module", "palvelut");
		
		model.addAttribute("toimipisteet", toimipisteRepository.findAll());
		
		return "palvelu_uusi";
	}
	
	@PostMapping("palvelut/uusi")
	public String postPalvelu(@RequestParam String nimi, @RequestParam String tyyppi, 
			@RequestParam String kuvaus, @RequestParam String hinta, @RequestParam String alv,
			@RequestParam String toimipiste) {
		
		Toimipiste t = toimipisteRepository.findByNimi(toimipiste);
		
		Palvelu p = new Palvelu(nimi, tyyppi, kuvaus, Double.parseDouble(hinta), Double.parseDouble(alv), t, new ArrayList<>());
		
		palvelurepository.save(p);
		
		return "redirect:/palvelut";
	}
	
	@GetMapping("/palvelut/{id}/poista")
	public String poistaPalvelu(@PathVariable Long id) {
		palvelurepository.deleteById(id);
		return "redirect:/palvelut";
	}
	
	@GetMapping("/palvelut/{id}/muokkaa")
	public String muokkaaPalvelu(Model model, @PathVariable Long id) {
		
		model.addAttribute("module", "palvelut");

		model.addAttribute("toimipisteet", toimipisteRepository.findAll());
		
		model.addAttribute("palvelu", palvelurepository.getOne(id));
		
		return "palvelu_muokkaa";
	}
	
	@PostMapping("/palvelut/{id}/muokkaa")
	public String postMuokkaaPalvelu(@PathVariable Long id, @RequestParam String toimipiste, @RequestParam String tyyppi, @RequestParam String nimi, 
			@RequestParam String kuvaus, @RequestParam String hinta, @RequestParam String alv) {
		
		Toimipiste t = toimipisteRepository.findByNimi(toimipiste);
		
		Palvelu p = palvelurepository.getOne(id);
		
		p.setToimipiste(t);
		p.setTyyppi(tyyppi);
		p.setNimi(nimi);
		p.setKuvaus(kuvaus);
		p.setHinta(Double.parseDouble(hinta));
		p.setAlv(Double.parseDouble(alv));
		
		palvelurepository.save(p);
		
		return "redirect:/palvelut";
		
	}
	
}
