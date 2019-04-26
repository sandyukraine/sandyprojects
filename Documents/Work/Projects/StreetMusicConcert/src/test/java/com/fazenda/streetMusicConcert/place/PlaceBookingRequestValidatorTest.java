package com.fazenda.streetMusicConcert.place;

import com.fazenda.streetMusicConcert.TestApp;
import com.fazenda.streetMusicConcert.place.dataTransfer.PlaceBookingRequest;
import com.fazenda.streetMusicConcert.util.ValidationResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {PlaceRequestValidator.class, TestApp.class}, initializers = ConfigFileApplicationContextInitializer.class)
public class PlaceBookingRequestValidatorTest {

    @Autowired
    private PlaceRequestValidator placeRequestValidator;

    @Test
    public void returnsOkForValidInput() {
        PlaceBookingRequest validPlaceBookingRequest =
                new PlaceBookingRequest("DE_Dresden_1", "Performer_1", 2019, 1, 2, 3, 4, 5, 2019, 1, 2, 4, 4, 5);
        ValidationResult expectedValidationResult = new ValidationResult(ValidationResult.ValidationStatus.OK, "Ok");

        ValidationResult actualValidationResult = placeRequestValidator.validate(validPlaceBookingRequest);

        assertEquals(expectedValidationResult, actualValidationResult);
    }

    @Test
    public void yearConsistOfFourChars() {
        PlaceBookingRequest invalidPlaceBookingRequest =
                new PlaceBookingRequest("DE_Dresden_1", "Performer_1", 20191, 1, 2, 3, 4, 5, 219, 1, 2, 4, 5, 6);
        ValidationResult expectedValidationResult =
                new ValidationResult(ValidationResult.ValidationStatus.ERROR, "Year must have 4 chars");

        ValidationResult actualValidationResult = placeRequestValidator.validate(invalidPlaceBookingRequest);

        assertTrue(actualValidationResult.getValidationStatus().equals(ValidationResult.ValidationStatus.ERROR));
        assertTrue(actualValidationResult.getValidationMessage().contains(expectedValidationResult.getValidationMessage()));
    }

    @Test
    public void stopIsLaterThanStart() {
        PlaceBookingRequest invalidPlaceBookingRequest =
                new PlaceBookingRequest("DE_Dresden_1", "Performer_1", 2019, 1, 2, 3, 4, 5, 2018, 1, 2, 4, 5, 6);
        ValidationResult expectedValidationResult =
                new ValidationResult(ValidationResult.ValidationStatus.ERROR, "Stop time must be later than start time");

        ValidationResult actualValidationResult = placeRequestValidator.validate(invalidPlaceBookingRequest);

        assertTrue(actualValidationResult.getValidationStatus().equals(ValidationResult.ValidationStatus.ERROR));
        assertTrue(actualValidationResult.getValidationMessage().contains(expectedValidationResult.getValidationMessage()));
    }

    @Test
    public void timeSlotIsTooLong() {
        PlaceBookingRequest invalidPlaceBookingRequest =
                new PlaceBookingRequest("DE_Dresden_1", "Performer_1", 2019, 1, 2, 3, 4, 5, 2019, 1, 2, 9, 4, 5);
        ValidationResult expectedValidationResult =
                new ValidationResult(ValidationResult.ValidationStatus.ERROR, "Requested time exceeds the maximum allowed performance time");

        ValidationResult actualValidationResult = placeRequestValidator.validate(invalidPlaceBookingRequest);

        assertTrue(actualValidationResult.getValidationStatus().equals(ValidationResult.ValidationStatus.ERROR));
        assertTrue(actualValidationResult.getValidationMessage().contains(expectedValidationResult.getValidationMessage()));
    }
}