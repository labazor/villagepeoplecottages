package villagepeoplecottages.raportit;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RaportitController {

	@GetMapping("/raportit")
	@ResponseBody
	public String getRaportit() {
		return "Tänne tulee raportit";
	}
}
