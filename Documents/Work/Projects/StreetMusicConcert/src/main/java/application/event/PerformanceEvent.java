package application.event;

import application.performer.Performer;
import application.place.Place;
import application.util.TimeSlot;

public class PerformanceEvent {

    private Performer performer;
    private TimeSlot timeSlot;
    private Place place;

    public PerformanceEvent(Performer performer, TimeSlot timeSlot, Place place) {
        this.performer = performer;
        this.timeSlot = timeSlot;
        this.place = place;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PerformanceEvent that = (PerformanceEvent) o;

        if (!performer.equals(that.performer)) return false;
        if (!timeSlot.equals(that.timeSlot)) return false;
        return place.equals(that.place);

    }

    @Override
    public int hashCode() {
        int result = performer.hashCode();
        result = 31 * result + timeSlot.hashCode();
        result = 31 * result + place.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "PerformanceEvent{" +
                "performer=" + performer +
                ", timeSlot=" + timeSlot +
                ", place=" + place +
                '}';
    }
}
