package com.fazenda.streetMusicConcert.place;

import com.fazenda.streetMusicConcert.place.dataTransfer.PlaceBookingRequest;
import com.fazenda.streetMusicConcert.util.Settings;
import com.fazenda.streetMusicConcert.util.ValidationResult;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PlaceRequestValidator {

    private static final String ALLOWED_PERFORMANCE_TIME = "maximumAllowedPerformanceTimeInSeconds";
    private static final String OK_MESSAGE = "Ok";
    private static final String FOUR_CHARS_YEAR_MESSAGE = "Year must have 4 chars";
    private static final String STOP_LATER_THAN_START_MESSAGE = "Stop time must be later than start time";
    private static final String ALLOWED_PERFORMANCE_TIME_MESSAGE = "Requested time exceeds the maximum allowed performance time";

    public ValidationResult validate(PlaceBookingRequest placeBookingRequest) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(validateYear(placeBookingRequest));
        stringBuilder.append(validateStopIsAfterStart(placeBookingRequest));
        stringBuilder.append(validateMaximumPerformanceTimeExceeded(placeBookingRequest));

        if (stringBuilder.length() == 0) {
            return new ValidationResult(ValidationResult.ValidationStatus.OK, OK_MESSAGE);
        } else {
            return new ValidationResult(ValidationResult.ValidationStatus.ERROR, stringBuilder.toString());
        }
    }

    private String validateYear(PlaceBookingRequest placeBookingRequest) {
        if (String.valueOf(placeBookingRequest.getStartYear()).length() != 4 ||
            String.valueOf(placeBookingRequest.getStopYear()).length() != 4) {
            return FOUR_CHARS_YEAR_MESSAGE;
        } else {
            return "";
        }
    }

    private String validateStopIsAfterStart(PlaceBookingRequest placeBookingRequest) {
        LocalDateTime startDateTime = LocalDateTime.of(placeBookingRequest.getStartYear(), placeBookingRequest.getStartMonth(),
                                                       placeBookingRequest.getStartDay(), placeBookingRequest.getStartHour(),
                                                       placeBookingRequest.getStartMinute(), placeBookingRequest.getStartSecond());
        LocalDateTime stopDateTime = LocalDateTime.of(placeBookingRequest.getStopYear(), placeBookingRequest.getStopMonth(),
                                                      placeBookingRequest.getStopDay(), placeBookingRequest.getStopHour(),
                                                      placeBookingRequest.getStopMinute(), placeBookingRequest.getStopSecond());
        if (startDateTime.isAfter(stopDateTime)) {
            return STOP_LATER_THAN_START_MESSAGE;
        } else {
            return "";
        }
    }

    private String validateMaximumPerformanceTimeExceeded(PlaceBookingRequest placeBookingRequest) {
        LocalDateTime startDateTime = LocalDateTime.of(placeBookingRequest.getStartYear(), placeBookingRequest.getStartMonth(),
                placeBookingRequest.getStartDay(), placeBookingRequest.getStartHour(),
                placeBookingRequest.getStartMinute(), placeBookingRequest.getStartSecond());
        LocalDateTime stopDateTime = LocalDateTime.of(placeBookingRequest.getStopYear(), placeBookingRequest.getStopMonth(),
                placeBookingRequest.getStopDay(), placeBookingRequest.getStopHour(),
                placeBookingRequest.getStopMinute(), placeBookingRequest.getStopSecond());

        int maximumAllowedPerformanceTimeInSeconds = Integer.parseInt(getSettings().getPlaceRequestSettings()
                .get(ALLOWED_PERFORMANCE_TIME));

        if (startDateTime.plusSeconds(maximumAllowedPerformanceTimeInSeconds).isBefore(stopDateTime)) {
            return ALLOWED_PERFORMANCE_TIME_MESSAGE;
        } else {
            return "";
        }
    }

    @Bean
    @ConfigurationProperties
    public Settings getSettings() {
        return new Settings();
    }
}