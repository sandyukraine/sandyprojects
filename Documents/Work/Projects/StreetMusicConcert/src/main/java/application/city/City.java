package application.city;

import application.instrument.MusicalInstrument;
import application.place.Place;
import application.util.Schedule;

import java.util.List;

import org.springframework.data.annotation.Id;

public class City {

    public City() {}

    public City(String name, String country, boolean permissionNeeded, List<Place> places,
                List<MusicalInstrument> forbiddenInstruments, boolean hasSchedule, Schedule shedule, String rules) {
        this.name = name;
        this.country = country;
        this.permissionNeeded = permissionNeeded;
        this.places = places;
        this.forbiddenInstruments = forbiddenInstruments;
        this.hasSchedule = hasSchedule;
        this.shedule = shedule;
        this.rules = rules;
    }

    @Id
    private String id;
    private String name;
    private String country;
    private boolean permissionNeeded;
    private List<Place> places;
    private List<MusicalInstrument> forbiddenInstruments;
    private boolean hasSchedule;
    private Schedule shedule;
    private String rules;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public boolean isPermissionNeeded() {
        return permissionNeeded;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public List<MusicalInstrument> getForbiddenInstruments() {
        return forbiddenInstruments;
    }

    public boolean isHasSchedule() {
        return hasSchedule;
    }

    public Schedule getShedule() {
        return shedule;
    }

    public String getRules() {
        return rules;
    }

    @Override
    public String toString() {
        return "City{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", permissionNeeded=" + permissionNeeded +
                ", places=" + places +
                ", forbiddenInstruments=" + forbiddenInstruments +
                ", hasSchedule=" + hasSchedule +
                ", shedule=" + shedule +
                ", rules='" + rules + '\'' +
                '}';
    }
}
