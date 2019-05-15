package villagepeoplecottages.varaus;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import villagepeoplecottages.asiakas.Asiakas;
import villagepeoplecottages.asiakas.AsiakasRepository;
import villagepeoplecottages.palvelu.Palvelu;
import villagepeoplecottages.toimipiste.Toimipiste;
import villagepeoplecottages.toimipiste.ToimipisteRepository;

@Controller
public class VarausController {

	@Autowired
	VarausRepository varausRepository;
	
	@Autowired
	ToimipisteRepository toimipisteRepository;
	
	@Autowired
	AsiakasRepository asiakasRepository;
	
	@GetMapping("/varaukset")
	public String getVaraukset(Model model) {
		
		model.addAttribute("module", "varaukset");
		
		model.addAttribute("varaukset", varausRepository.findAll());
		
		return "varaus";
	}
	
	@GetMapping("/varaukset/uusi")
	public String uusiVaraus(Model model) {
		
		model.addAttribute("module", "varaukset");
		
		model.addAttribute("toimipisteet", toimipisteRepository.findAll());
		
		model.addAttribute("asiakkaat", asiakasRepository.findAll());
		
		return "varaus_uusi";
	}
	
	@PostMapping("/varaukset/uusi")
	public String postVaraus(@RequestParam String toimipiste, @RequestParam String asiakas, @RequestParam String varattu, @RequestParam String vahvistus) {
		
		String[] asiakasIdString = asiakas.split(" ");
		long asiakasId = Long.parseLong(asiakasIdString[0]);
		Asiakas a = asiakasRepository.getOne(asiakasId);
		
		Toimipiste t = toimipisteRepository.findByNimi(toimipiste);
		
		Varaus v = new Varaus(LocalDate.parse(varattu), LocalDate.parse(vahvistus), new ArrayList<>(), new ArrayList<>(), a, t);
		
		varausRepository.save(v);
		
		return "redirect:/varaukset";
		
	}
	
	@GetMapping("/varaukset/{id}/poista")
	public String poistaVaraus(@PathVariable Long id) {
		varausRepository.deleteById(id);
		return "redirect:/varaukset";
	}
}
