package application.place;

import application.event.PerformanceEvent;
import application.util.TimeSlot;

import java.util.ArrayList;
import java.util.List;

public class Place {

    private String funnyName;
    private EventAddress eventAddress;
    private Coordinate coordinate;
    private boolean hasRoof;
    private List<PerformanceEvent> performanceEvents = new ArrayList<>();
    private String hiddenInfo;

    private Place() {

    }

    public String getFunnyName() {
        return funnyName;
    }

    public List<PerformanceEvent> getPerformanceEvents() {
        return performanceEvents;
    }

    public void addPerformanceEvent(PerformanceEvent performanceEvent) {
        this.performanceEvents.add(performanceEvent);
    }

    public static Builder newBuilder(String funnyName) {
        return new Place().new Builder(funnyName);
    }

    public class Builder {

        private Builder(String funnyName) {
            Place.this.funnyName = funnyName;
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
