package com.fazenda.streetMusicConcert.place.dataTransfer;

public class PlaceBookingResponce {

    private boolean isBooked;
    private String statusMessage;
    private String placeId;
    private String performerId;

    public PlaceBookingResponce(boolean isBooked, String statusMessage, String placeId,
                                String performerId) {
        this.isBooked = isBooked;
        this.statusMessage = statusMessage;
        this.placeId = placeId;
        this.performerId = performerId;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public String getPlaceId() {
        return placeId;
    }

    public String getPerformerId() {
        return performerId;
    }
}