package com.fazenda.streetMusicConcert.event;

import com.fazenda.streetMusicConcert.performer.Performer;
import com.fazenda.streetMusicConcert.place.Place;
import com.fazenda.streetMusicConcert.util.TimeSlot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerformanceEventManager {

    @Autowired
    private PerformanceEventRepository performanceEventRepository;
    @Autowired
    private PerformanceEventResolver performanceEventResolver;

    public void createPerformanceEvent(Performer performer, Place place, TimeSlot timeSlot) {
        boolean placeIsFree = verifyPlace(place, timeSlot);
        if (placeIsFree) {
            performanceEventRepository.save(new PerformanceEvent(performer, place, timeSlot));
        }
    }

    private boolean verifyPlace(Place place, TimeSlot timeSlot) {



//        performanceEventRepository.
        return false;
    }
}