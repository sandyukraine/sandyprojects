package com.fazenda.streetMusicConcert.performer;

import com.fazenda.streetMusicConcert.place.dataTransfer.PlaceBookingRequest;
import com.fazenda.streetMusicConcert.place.PlaceRequestValidator;
import com.fazenda.streetMusicConcert.place.dataTransfer.PlaceBookingResponce;
import com.fazenda.streetMusicConcert.util.ValidationResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PerformerController {

    @Autowired
    private PlaceRequestValidator placeRequestValidator;
    @Autowired
    private PerformerManager performerManager;

    @RequestMapping(value = "/bookPlace", method = RequestMethod.POST)
    public ResponseEntity<PlaceBookingResponce> bookPlace(@RequestBody PlaceBookingRequest placeBookingRequest) {
        PlaceBookingResponce placeBookingResponce;

        ValidationResult validationResult = placeRequestValidator.validate(placeBookingRequest);
        if (validationResult.getValidationStatus().equals(ValidationResult.ValidationStatus.ERROR)) {
            placeBookingResponce = prepareErrorResponce(placeBookingRequest, validationResult);
            return new ResponseEntity<>(placeBookingResponce, HttpStatus.BAD_REQUEST);
        } else {
            placeBookingResponce = performerManager.bookPlace(placeBookingRequest);
        }

        return new ResponseEntity<>(placeBookingResponce, HttpStatus.OK);
    }

    private PlaceBookingResponce prepareErrorResponce(PlaceBookingRequest placeBookingRequest, ValidationResult validationResult) {
        String statusMessage = validationResult.getValidationMessage();
        String placeId = placeBookingRequest.getPlaceId();
        String performerId = placeBookingRequest.getPerformerId();

        return new PlaceBookingResponce(false, statusMessage, placeId, performerId);
    }
}