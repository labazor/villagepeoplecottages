package villagepeoplecottages.lasku;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LaskuController {

	@GetMapping("/laskut")
	public String getLaskut(Model model) {
		
		return "lasku";
	}
}
