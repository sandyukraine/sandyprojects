package com.fazenda.streetMusicConcert.performer;

import com.fazenda.streetMusicConcert.instrument.MusicalInstrument;

import java.util.List;

public class Performer {

    private String id;
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

    public static Builder newBuilder(String id, String performerName) {
        return new Performer().new Builder(id, performerName);
    }

    public class Builder {

        private Builder(String id, String performerName) {
            Performer.this.id = id;
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

    @Override
    public String toString() {
        return "Performer{" +
                "id='" + id + '\'' +
                ", performerName='" + performerName + '\'' +
                ", performerLink='" + performerLink + '\'' +
                ", performerDescription='" + performerDescription + '\'' +
                ", numberOfMembers=" + numberOfMembers +
                ", musicalInstruments=" + musicalInstruments +
                '}';
    }
}