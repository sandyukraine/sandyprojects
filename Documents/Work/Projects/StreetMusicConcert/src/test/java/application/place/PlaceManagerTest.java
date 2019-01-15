package application.place;

import application.event.PerformanceEvent;
import application.performer.Performer;
import application.util.TimeSlot;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PlaceManagerTest {

    @Test
    public void eventIsAddedToPlaceWhenBooked() {
        // given
        Performer performer = Performer.newBuilder("Sandy").setPerformerDescription("Onemanband").build();

        LocalDateTime startTime = LocalDateTime.now();
        LocalDateTime stopTime = LocalDateTime.now().plusHours(1);
        TimeSlot timeSlot = new TimeSlot(startTime, stopTime);

        Place place = Place.newBuilder("Under the tree").build();
        PerformanceEvent performanceEvent = new PerformanceEvent(performer, timeSlot, place);

        // when
        performer.bookPlace(place, timeSlot);

        // then
        assertTrue(place.getPerformanceEvents().contains(performanceEvent));
    }

    @Test
    public void doNotBookIfPlaceIsBusy() {
        // given
        Performer performerSandy = Performer.newBuilder("Sandy").setPerformerDescription("Onemanband").build();
        Performer performerFazenda = Performer.newBuilder("Fazenda").setPerformerDescription("Hardrock band from Ukraine").build();

        LocalDateTime startTime = LocalDateTime.now();
        LocalDateTime stopTime = LocalDateTime.now().plusHours(1);
        TimeSlot timeSlot = new TimeSlot(startTime, stopTime);

        Place place = Place.newBuilder("Under the tree").build();
        PerformanceEvent sandyPerformanceEvent = new PerformanceEvent(performerSandy, timeSlot, place);
        PerformanceEvent fazendaPerformanceEvent = new PerformanceEvent(performerFazenda, timeSlot, place);

        // when
        performerSandy.bookPlace(place, timeSlot);
        performerFazenda.bookPlace(place, timeSlot);

        // then
        assertTrue(place.getPerformanceEvents().contains(sandyPerformanceEvent));
        assertFalse(place.getPerformanceEvents().contains(fazendaPerformanceEvent));
    }
}
