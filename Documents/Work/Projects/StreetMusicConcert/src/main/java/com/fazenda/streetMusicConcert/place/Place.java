package com.fazenda.streetMusicConcert.place;

import com.fazenda.streetMusicConcert.event.PerformanceEvent;

import java.util.ArrayList;
import java.util.List;

public class Place {

    private String id;
    private EventAddress eventAddress;
    private Coordinate coordinate;
    private String googlePlusCode;
    private boolean hasRoof;
    private List<PerformanceEvent> performanceEvents = new ArrayList<>();
    private String hiddenInfo;

    private Place() {

    }

    public List<PerformanceEvent> getPerformanceEvents() {
        return performanceEvents;
    }

    public void addPerformanceEvent(PerformanceEvent performanceEvent) {
        this.performanceEvents.add(performanceEvent);
    }

    public static Builder newBuilder(String id) {
        return new Place().new Builder(id);
    }

    public class Builder {

        private Builder(String id) {
            Place.this.id = id;
        }

        public Place build() {
            return Place.this;
        }

        public Builder setEventAddress(EventAddress eventAddress) {
            Place.this.eventAddress = eventAddress;
            return this;
        }

        public Builder setCoordinate(Coordinate coordinate) {
            Place.this.coordinate = coordinate;
            return this;
        }

        public Builder setHasRoof(boolean hasRoof) {
            Place.this.hasRoof = hasRoof;
            return this;
        }

        public Builder addPerformanceEvent(PerformanceEvent performanceEvent) {
            Place.this.performanceEvents.add(performanceEvent);
            return this;
        }

        public Builder setHiddenInfo(String hiddenInfo) {
            Place.this.hiddenInfo = hiddenInfo;
            return this;
        }
    }
}