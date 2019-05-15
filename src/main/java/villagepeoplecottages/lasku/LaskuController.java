package villagepeoplecottages.lasku;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import villagepeoplecottages.asiakas.Asiakas;
import villagepeoplecottages.toimipiste.Toimipiste;

@Controller
public class LaskuController {
	
	@Autowired
	LaskuRepository laskuRepository;

	@GetMapping("/laskut")
	public String getLaskut(Model model) {
		
		model.addAttribute("module", "laskut");
		
		model.addAttribute("laskut", laskuRepository.findAll());
		
		return "lasku";
	}
	
	@GetMapping("/laskut/uusi")
	public String uusiLasku(Model model) {
		
		model.addAttribute("module", "laskut");
		
		return "lasku_uusi";
	}
	
	@PostMapping("/laskut/uusi")
	public String postLasku(@RequestParam String toimipiste) {
		
		
		return "redirect:/varaukset";
		
	}
	
	@GetMapping("/laskut/{id}/poista")
	public String poistaLasku(@PathVariable Long id) {
		laskuRepository.deleteById(id);
		return "redirect:/laskut";
	}
}
