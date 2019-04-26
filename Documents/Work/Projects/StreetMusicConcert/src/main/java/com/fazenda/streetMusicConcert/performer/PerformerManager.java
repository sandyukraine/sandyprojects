package com.fazenda.streetMusicConcert.performer;

import com.fazenda.streetMusicConcert.event.PerformanceEventManager;
import com.fazenda.streetMusicConcert.place.Place;
import com.fazenda.streetMusicConcert.place.PlaceResolver;
import com.fazenda.streetMusicConcert.place.dataTransfer.PlaceBookingRequest;
import com.fazenda.streetMusicConcert.place.dataTransfer.PlaceBookingResponce;
import com.fazenda.streetMusicConcert.util.TimeSlot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerformerManager {

    @Autowired
    private PerformerResolver performerResolver;
    @Autowired
    private PlaceResolver placeResolver;
    @Autowired
    private PerformanceEventManager performanceEventManager;

    public PlaceBookingResponce bookPlace(PlaceBookingRequest placeBookingRequest) {
        String placeId = placeBookingRequest.getPlaceId();
        String performerId = placeBookingRequest.getPerformerId();

        Place place = placeResolver.resolvePlace(placeId);
        Performer performer = performerResolver.resolvePerformer(performerId);

        TimeSlot timeSlot = extractTimeSlotFromRequest(placeBookingRequest);
        performanceEventManager.createPerformanceEvent(performer, place, timeSlot);
        return new PlaceBookingResponce(true, "Booked successfully", placeId, performerId);
    }

    private TimeSlot extractTimeSlotFromRequest(PlaceBookingRequest placeBookingRequest) {
        return new TimeSlot(placeBookingRequest.getStartYear(), placeBookingRequest.getStartMonth(),
                placeBookingRequest.getStartDay(), placeBookingRequest.getStartHour(),
                placeBookingRequest.getStartMinute(), placeBookingRequest.getStartSecond(),
                placeBookingRequest.getStopYear(), placeBookingRequest.getStopMonth(),
                placeBookingRequest.getStopDay(), placeBookingRequest.getStopHour(),
                placeBookingRequest.getStopMinute(), placeBookingRequest.getStopSecond());
    }
}