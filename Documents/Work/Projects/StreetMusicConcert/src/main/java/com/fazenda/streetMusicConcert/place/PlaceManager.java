package com.fazenda.streetMusicConcert.place;

import com.fazenda.streetMusicConcert.event.PerformanceEvent;
import com.fazenda.streetMusicConcert.performer.Performer;
import com.fazenda.streetMusicConcert.util.TimeSlot;
import org.springframework.beans.factory.annotation.Autowired;

public class PlaceManager {

    @Autowired
    private PlaceRepository placeRepository;

    public static void book(Performer performer, Place place, TimeSlot timeSlot) {

        if (isPlaceFree(place, timeSlot)) {
            PerformanceEvent performanceEvent = new PerformanceEvent(performer, place, timeSlot);
            place.addPerformanceEvent(performanceEvent);

            // repository add event

            /*System.out.println(place.getFunnyName() + " is booked by " + performer.getPerformerName() +
                    " for the next period of time " + timeSlot.toString());*/
        } else {
//            System.out.println("Place " + place.getFunnyName() + " is busy at " + timeSlot);
        }

    }

    // here make sure timeSlot is free
    // return some kind of empty timeSlot if it is busy
    // Think generally if it can be busy. We can not promise it's free for now. We can suggest it's busy.
    // "Looks like this place is busy during this period of time. Do you want to perform there anyway?"
    private static boolean isPlaceFree(Place place, TimeSlot timeSlot) {
        for (PerformanceEvent performanceEvent : place.getPerformanceEvents()) {
            if (performanceEvent.getTimeSlot().equals(timeSlot)) {
                return false;
            }
        }
        return true;
    }
}