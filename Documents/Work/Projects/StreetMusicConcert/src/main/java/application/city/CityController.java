package application.city;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {

    @RequestMapping("/cities")
    public String showCities() {
        return "Dresden, Munich";
    }
}