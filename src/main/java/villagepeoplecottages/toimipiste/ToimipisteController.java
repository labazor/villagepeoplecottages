package villagepeoplecottages.toimipiste;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ToimipisteController {

	@Autowired
	ToimipisteRepository toimipisteRepository;
	
	@GetMapping("/toimipiste")
	public String getToimipiste(Model model) {
		
		model.addAttribute("toimipisteet", toimipisteRepository.findAll());
		
		return "toimipiste";
	}
}
