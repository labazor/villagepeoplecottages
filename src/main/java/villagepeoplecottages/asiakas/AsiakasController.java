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
	public String uusiAsiakas(Model model) {
		model.addAttribute("module", "asiakkaat");
		
		return "asiakas_uusi";
	}
	
	@PostMapping("asiakkaat/uusi")
	public String postAsiakas(@RequestParam String enimi, @RequestParam String snimi,
			@RequestParam String lahiosoite, @RequestParam String postinro, @RequestParam String postitoimipaikka,
			@RequestParam String puhelinnro, @RequestParam String email) {
		
		Asiakas a = new Asiakas(enimi, snimi, lahiosoite, postitoimipaikka, postinro, email, puhelinnro, new ArrayList<>(), new ArrayList<>());
		
		asiakasRepository.save(a);
		
		return "redirect:/asiakkaat";
	}
	
	@GetMapping("/asiakkaat/{id}/poista")
	public String poistaAsiakas(@PathVariable Long id) {
		asiakasRepository.deleteById(id);
		return "redirect:/asiakkaat";
	}
	
	@GetMapping("/asiakkaat/{id}/muokkaa")
	public String muokkaaAsiakas(Model model, @PathVariable Long id) {
		model.addAttribute("module", "asiakkaat");

		model.addAttribute("asiakas", asiakasRepository.getOne(id));
		
		return "asiakas_muokkaa";
	}
	
	@PostMapping("/asiakkaat/{id}/muokkaa")
	public String postMuokkaaAsiakas(@PathVariable Long id, @RequestParam String enimi, @RequestParam String snimi,
			@RequestParam String lahiosoite, @RequestParam String postinro, @RequestParam String postitoimipaikka,
			@RequestParam String puhelinnro, @RequestParam String email) {
		
		Asiakas a = asiakasRepository.getOne(id);
		
		a.setEtunimi(enimi);
		a.setSukunimi(snimi);
		a.setLahiosoite(lahiosoite);
		a.setPostinro(postinro);
		a.setPostitoimipaikka(postitoimipaikka);
		a.setPuhelinnro(puhelinnro);
		a.setEmail(email);
		
		asiakasRepository.save(a);
		
		return "redirect:/asiakkaat";
		
	}
}
