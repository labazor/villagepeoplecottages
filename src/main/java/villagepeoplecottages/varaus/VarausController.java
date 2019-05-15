package villagepeoplecottages.varaus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VarausController {

	@Autowired
	VarausRepository varausRepository;
	
	@GetMapping("/varaukset")
	public String getVaraukset(Model model) {
		
		model.addAttribute("module", "varaukset");
		
		model.addAttribute("varaukset", varausRepository.findAll());
		
		return "varaus";
	}
}
