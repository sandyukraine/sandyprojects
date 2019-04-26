package com.fazenda.streetMusicConcert.event;

import com.fazenda.streetMusicConcert.helper.StaticDataProvider;
import com.fazenda.streetMusicConcert.performer.Performer;
import com.fazenda.streetMusicConcert.place.Place;
import com.fazenda.streetMusicConcert.util.TimeSlot;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PerformanceEventManagerTest {

    @Autowired
    private PerformanceEventManager performanceEventManager;
    @Autowired
    private PerformanceEventRepository performanceEventRepository;

    @Mock
    private PerformanceEventResolver performanceEventResolver;

    @Test
    public void savePerformanceIfPlaceIsFree() {

        // TODO: finish or remove test
        performanceEventResolver = mock(PerformanceEventResolver.class);
//        when(performanceEventResolver.verifyPlace(place, timeSlot)).thenReturn(true);

        Performer performer = Performer.newBuilder("Performer_1", "Fazenda").build();
        Place place = Place.newBuilder("Place_DE_Dresden_1").build();
        TimeSlot timeSlot = StaticDataProvider.provideDefaultValidTimeSlot();

        performanceEventManager.createPerformanceEvent(performer, place, timeSlot);


    }
}