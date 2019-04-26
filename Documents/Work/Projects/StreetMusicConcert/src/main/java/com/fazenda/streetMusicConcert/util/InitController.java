package com.fazenda.streetMusicConcert.util;

import com.fazenda.streetMusicConcert.city.City;
import com.fazenda.streetMusicConcert.city.CityRepository;
import com.fazenda.streetMusicConcert.event.PerformanceEventRepository;
import com.fazenda.streetMusicConcert.instrument.MusicalInstrument;
import com.fazenda.streetMusicConcert.performer.Performer;
import com.fazenda.streetMusicConcert.performer.PerformerRepository;
import com.fazenda.streetMusicConcert.place.Place;
import com.fazenda.streetMusicConcert.place.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class InitController {

    public static final String DUMMY_RULES = "Rules. Blah blah blah";

    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private PlaceRepository placeRepository;
    @Autowired
    private PerformerRepository performerRepository;
    @Autowired
    private PerformanceEventRepository performanceEventRepository;

    @RequestMapping("/init")
    public void init() {
        placeRepository.deleteAll();
        performerRepository.deleteAll();
        cityRepository.deleteAll();
        performanceEventRepository.deleteAll();

        Place place1 = Place.newBuilder("Place_DE_Dresden_1").build();
        placeRepository.save(place1);

        List<Place> places = new ArrayList<>();
        places.add(place1);

        Performer performer1 = Performer.newBuilder("Performer_1", "Fazenda").build();
        performerRepository.save(performer1);

        List<MusicalInstrument> musicalInstruments = new ArrayList<>();
        Schedule schedule = new Schedule();

        cityRepository.save(new City("Munich", "Germany", true, places, musicalInstruments, false, schedule, DUMMY_RULES));
        cityRepository.save(new City("Dresden", "Germany", true, places, musicalInstruments, true, schedule, DUMMY_RULES));
        cityRepository.save(new City("Krakow", "Poland", true, places, musicalInstruments, true, schedule, DUMMY_RULES));
        cityRepository.save(new City("Wroclaw", "Poland", true, places, musicalInstruments, true, schedule, DUMMY_RULES));
        cityRepository.save(new City("Prague", "Czech Republic", true, places, musicalInstruments, true, schedule, DUMMY_RULES));
        cityRepository.save(new City("Ivano-Frankivsk", "Ukraine", true, places, musicalInstruments, true, schedule, DUMMY_RULES));
        cityRepository.save(new City("Lviv", "Ukraine", true, places, musicalInstruments, true, schedule, DUMMY_RULES));
    }
}