package com.fazenda.streetMusicConcert.city;

import com.fazenda.streetMusicConcert.instrument.MusicalInstrument;
import com.fazenda.streetMusicConcert.place.Place;
import com.fazenda.streetMusicConcert.util.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CityController {

    @Autowired
    private CityRepository cityRepository;

    @RequestMapping("/city/{name}")
    public City getCityByName(@PathVariable("name") String name) {
        return cityRepository.findByName(name);
    }

    @RequestMapping("/cities")
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    /*@RequestMapping("/initCities")
    public void initCities() {
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
    }*/
}