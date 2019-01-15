package application.place;

import application.event.PerformanceEvent;
import application.performer.Performer;
import application.util.TimeSlot;

public class PlaceManager {



    public static void book(Performer performer, Place place, TimeSlot timeSlot) {

        if (placeIsFree(place, timeSlot)) {
            PerformanceEvent performanceEvent = new PerformanceEvent(performer, timeSlot, place);
            place.addPerformanceEvent(performanceEvent);

            System.out.println(place.getFunnyName() + " is booked by " + performer.getPerformerName() +
                    " for the next period of time " + timeSlot.toString());
        } else {
            System.out.println("Place " + place.getFunnyName() + " is busy at " + timeSlot);
        }

    }

    private static boolean placeIsFree(Place place, TimeSlot timeSlot) {
        for (PerformanceEvent performanceEvent : place.getPerformanceEvents()) {
            if (performanceEvent.getTimeSlot().equals(timeSlot)) {
                return false;
            }
        }
        return true;
    }
}