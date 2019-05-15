package villagepeoplecottages.palvelu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PalveluController {
	
	@Autowired
	PalveluRepository palvelurepository;

	@GetMapping("/palvelut")
	public String getPalvelu(Model model) {
		
		model.addAttribute("module", "palvelut");
		
		model.addAttribute("palvelut", palvelurepository.findAll());
		
		return "palvelu";
	}
	
}
