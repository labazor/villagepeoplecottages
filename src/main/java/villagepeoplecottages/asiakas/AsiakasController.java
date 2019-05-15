package villagepeoplecottages.asiakas;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import villagepeoplecottages.palvelu.Palvelu;
import villagepeoplecottages.toimipiste.Toimipiste;

@Controller
public class AsiakasController {
	
	@Autowired
	AsiakasRepository asiakasRepository;

	@GetMapping("/asiakkaat")
	public String getAsiakkaat(Model model) {
		
		model.addAttribute("module", "asiakkaat");
		
		model.addAttribute("asiakkaat", asiakasRepository.findAll());
		
		return "asiakas";
	}
	
	@GetMapping("/asiakkaat/uusi")
	public String uusiPalvelu(Model model) {
		
		return "asiakas_uusi";
	}
	
	@PostMapping("asiakkaat/uusi")
	public String postPalvelu(@RequestParam String enimi, @RequestParam String snimi,
			@RequestParam String lahiosoite, @RequestParam String postinro, @RequestParam String postitoimipaikka,
			@RequestParam String puhelinnro, @RequestParam String email) {
		
		Asiakas a = new Asiakas(enimi, snimi, lahiosoite, postitoimipaikka, postinro, email, puhelinnro, new ArrayList<>(), new ArrayList<>());
		
		asiakasRepository.save(a);
		
		return "redirect:/asiakkaat";
	}
	
	@GetMapping("/asiakkaat/{id}/poista")
	public String poistaPalvelu(@PathVariable Long id) {
		asiakasRepository.deleteById(id);
		return "redirect:/asiakkaat";
	}
}
