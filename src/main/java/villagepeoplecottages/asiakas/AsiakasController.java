package villagepeoplecottages.asiakas;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AsiakasController {

	@GetMapping("/asiakkaat")
	public String getAsiakkaat(Model model) {
		return "asiakas";
	}
}
