package villagepeoplecottages.lasku;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
