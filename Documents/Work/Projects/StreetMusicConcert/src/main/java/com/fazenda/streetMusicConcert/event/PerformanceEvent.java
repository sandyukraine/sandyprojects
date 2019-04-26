package com.fazenda.streetMusicConcert.event;

import com.fazenda.streetMusicConcert.performer.Performer;
import com.fazenda.streetMusicConcert.place.Place;
import com.fazenda.streetMusicConcert.util.TimeSlot;

public class PerformanceEvent {

    private Performer performer;
    private Place place;
    private TimeSlot timeSlot;

    public PerformanceEvent(Performer performer, Place place, TimeSlot timeSlot) {
        this.performer = performer;
        this.place = place;
        this.timeSlot = timeSlot;
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
        if (!place.equals(that.place)) return false;
        return timeSlot.equals(that.timeSlot);

    }

    @Override
    public int hashCode() {
        int result = performer.hashCode();
        result = 31 * result + place.hashCode();
        result = 31 * result + timeSlot.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "PerformanceEvent{" +
                "performer=" + performer +
                ", place=" + place +
                ", timeSlot=" + timeSlot +
                '}';
    }
}