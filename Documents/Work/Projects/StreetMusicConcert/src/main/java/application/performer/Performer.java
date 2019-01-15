package application.performer;

import application.instrument.MusicalInstrument;
import application.place.Place;
import application.place.PlaceManager;
import application.util.TimeSlot;

import java.util.List;

public class Performer {

    private String performerName;
    private String performerLink;
    private String performerDescription;
    private int numberOfMembers;
    private List<MusicalInstrument> musicalInstruments;

    private Performer() {

    }

    public String getPerformerName() {
        return performerName;
    }

    public static Builder newBuilder(String performerName) {
        return new Performer().new Builder(performerName);
    }

    public class Builder {

        private Builder(String performerName) {
            Performer.this.performerName = performerName;
        }

        public Performer build() {
            return Performer.this;
        }

        public Builder setPerformerLink(String performerLink) {
            Performer.this.performerLink = performerLink;
            return this;
        }

        public Builder setPerformerDescription(String performerDescription) {
            Performer.this.performerDescription = performerDescription;
            return this;
        }

        public Builder setNumberOfMembers(int numberOfMembers) {
            Performer.this.numberOfMembers = numberOfMembers;
            return this;
        }

        public Builder addInstrument(MusicalInstrument musicalInstrument) {
            Performer.this.musicalInstruments.add(musicalInstrument);
            return this;
        }
    }

    public void bookPlace(Place place, TimeSlot timeSlot) {
        PlaceManager.book(this, place, timeSlot);
    }
}
