package villagepeoplecottages.toimipiste;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import villagepeoplecottages.palvelu.Palvelu;
import villagepeoplecottages.varaus.Varaus;

@Controller
public class ToimipisteController {

	@Autowired
	ToimipisteRepository toimipisteRepository;
	
	@GetMapping("/toimipisteet")
	public String getToimipiste(Model model) {
		
		model.addAttribute("module", "toimipisteet");
		
		model.addAttribute("toimipisteet", toimipisteRepository.findAll());
		
		return "toimipiste";
	}
	
	@GetMapping("/toimipisteet/uusi")
	public String uusiToimipiste(Model model) {
		
		model.addAttribute("module", "toimipisteet");
		
		return "toimipiste_uusi";
	}
	
	@PostMapping("/toimipisteet/uusi")
	public String postToimipiste(@RequestParam String nimi, @RequestParam String lahiosoite, @RequestParam String postitoimipaikka, 
			@RequestParam String postinro, @RequestParam String email, @RequestParam String puhelinnro) {
		Toimipiste t = new Toimipiste(nimi, lahiosoite, postitoimipaikka, postinro, email, puhelinnro, new ArrayList<Palvelu>(), new ArrayList<Varaus>());
		toimipisteRepository.save(t);
		
		return "redirect:/toimipisteet";
		
	}
	
	@GetMapping("/toimipisteet/{id}/poista")
	public String poistaToimipiste(@PathVariable Long id) {
		toimipisteRepository.deleteById(id);
		return "redirect:/toimipisteet";
	}
}
