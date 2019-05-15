package villagepeoplecottages.varaus;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VarausController {

	@GetMapping("/varaukset")
	public String getVaraukset(Model model) {
		
		return "varaus";
	}
}
