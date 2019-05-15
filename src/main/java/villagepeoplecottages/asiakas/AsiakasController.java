package villagepeoplecottages.asiakas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
