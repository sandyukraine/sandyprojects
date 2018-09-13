package application.city;

import application.instrument.MusicalInstrument;
import application.place.Place;
import application.util.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CityController {

    @Autowired
    private CityRepository cityRepository;

    @RequestMapping("/cityByName")
    public String getCityByName() {

        City city = cityRepository.findByName("Dresden");

        String result = "{\"id\":" + 123 + ",\"content\":\"" + city.getName() + "\"}";

        return result;
    }

    @RequestMapping("/cities")
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    @RequestMapping("/addCities")
    public void addCities() {
        List<Place> places = new ArrayList<>();
        List<MusicalInstrument> musicalInstruments = new ArrayList<>();
        Schedule shedule = new Schedule();

        cityRepository.deleteAll();

        cityRepository.save(new City("Munich", "Germany", true, places, musicalInstruments, false, shedule, "Rules. Blah blah blah"));
        cityRepository.save(new City("Dresden", "Germany", true, places, musicalInstruments, true, shedule, "Rules. Blah blah blah"));
        cityRepository.save(new City("Krakow", "Poland", true, places, musicalInstruments, true, shedule, "Rules. Blah blah blah"));
        cityRepository.save(new City("Wroclaw", "Poland", true, places, musicalInstruments, true, shedule, "Rules. Blah blah blah"));
        cityRepository.save(new City("Prague", "Czech Republic", true, places, musicalInstruments, true, shedule, "Rules. Blah blah blah"));
        cityRepository.save(new City("Ivano-Frankivsk", "Ukraine", true, places, musicalInstruments, true, shedule, "Rules. Blah blah blah"));
        cityRepository.save(new City("Lviv", "Ukraine", true, places, musicalInstruments, true, shedule, "Rules. Blah blah blah"));
    }
}