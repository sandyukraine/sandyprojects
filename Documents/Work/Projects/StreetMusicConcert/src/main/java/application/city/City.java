package application.city;

import application.instrument.MusicalInstrument;
import application.place.Place;
import application.util.Schedule;

import java.util.List;

public class City {

    private String name;
    private String country;
    private boolean permissionNeeded;
    private List<Place> places;
    private List<MusicalInstrument> forbiddenInstruments;
    private boolean hasSchedule;
    private Schedule shedule;
    private String rules;
}
