package com.fazenda.streetMusicConcert.place;

import com.fazenda.streetMusicConcert.event.PerformanceEvent;
import com.fazenda.streetMusicConcert.performer.Performer;
import com.fazenda.streetMusicConcert.util.TimeSlot;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PlaceManagerTest {

    @Test
    public void eventIsAddedToPlaceWhenBooked() {
        // given
        Performer performer = Performer.newBuilder("Performer_2", "Sandy").setPerformerDescription("Onemanband").build();

        LocalDateTime startTime = LocalDateTime.now();
        LocalDateTime stopTime = LocalDateTime.now().plusHours(1);
        TimeSlot timeSlot = new TimeSlot(startTime, stopTime);

        Place place = Place.newBuilder("Under the tree").build();
        PerformanceEvent performanceEvent = new PerformanceEvent(performer, place, timeSlot);

        // when
//        performer.bookPlace(place, timeSlot);

        // then
        assertTrue(place.getPerformanceEvents().contains(performanceEvent));
    }

    @Test
    public void doNotBookIfPlaceIsBusy() {
        // given
        Performer performerSandy = Performer.newBuilder("Performer_2", "Sandy").setPerformerDescription("Onemanband").build();
        Performer performerFazenda = Performer.newBuilder("Performer_1", "Fazenda").setPerformerDescription("Hardrock band from Ukraine").build();

        LocalDateTime startTime = LocalDateTime.now();
        LocalDateTime stopTime = LocalDateTime.now().plusHours(1);
        TimeSlot timeSlot = new TimeSlot(startTime, stopTime);

        Place place = Place.newBuilder("Under the tree").build();
        PerformanceEvent sandyPerformanceEvent = new PerformanceEvent(performerSandy, place, timeSlot);
        PerformanceEvent fazendaPerformanceEvent = new PerformanceEvent(performerFazenda, place, timeSlot);

        // when
//        performerSandy.bookPlace(place, timeSlot);
//        performerFazenda.bookPlace(place, timeSlot);

        // then
        assertTrue(place.getPerformanceEvents().contains(sandyPerformanceEvent));
        assertFalse(place.getPerformanceEvents().contains(fazendaPerformanceEvent));
    }
}
