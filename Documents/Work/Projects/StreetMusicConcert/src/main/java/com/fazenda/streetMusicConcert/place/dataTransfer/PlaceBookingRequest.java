package com.fazenda.streetMusicConcert.place.dataTransfer;

import org.springframework.stereotype.Component;

@Component
public class PlaceBookingRequest {

    private String placeId;
    private String performerId;
    private int startYear;
    private int startMonth;
    private int startDay;
    private int startHour;
    private int startMinute;
    private int startSecond;
    private int stopYear;
    private int stopMonth;
    private int stopDay;
    private int stopHour;
    private int stopMinute;
    private int stopSecond;

    public PlaceBookingRequest() {
    }

    public PlaceBookingRequest(String placeId, String performerId,
                               int startYear, int startMonth, int startDay,
                               int startHour, int startMinute, int startSecond,
                               int stopYear, int stopMonth, int stopDay,
                               int stopHour, int stopMinute, int stopSecond) {
        this.placeId = placeId;
        this.performerId = performerId;
        this.startYear = startYear;
        this.startMonth = startMonth;
        this.startDay = startDay;
        this.startHour = startHour;
        this.startMinute = startMinute;
        this.startSecond = startSecond;
        this.stopYear = stopYear;
        this.stopMonth = stopMonth;
        this.stopDay = stopDay;
        this.stopHour = stopHour;
        this.stopMinute = stopMinute;
        this.stopSecond = stopSecond;
    }

    public String getPlaceId() {
        return placeId;
    }

    public String getPerformerId() {
        return performerId;
    }

    public int getStartYear() {
        return startYear;
    }

    public int getStartMonth() {
        return startMonth;
    }

    public int getStartDay() {
        return startDay;
    }

    public int getStartHour() {
        return startHour;
    }

    public int getStartMinute() {
        return startMinute;
    }

    public int getStartSecond() {
        return startSecond;
    }

    public int getStopYear() {
        return stopYear;
    }

    public int getStopMonth() {
        return stopMonth;
    }

    public int getStopDay() {
        return stopDay;
    }

    public int getStopHour() {
        return stopHour;
    }

    public int getStopMinute() {
        return stopMinute;
    }

    public int getStopSecond() {
        return stopSecond;
    }

    @Override
    public String toString() {
        return "PlaceBookingRequest{" +
                "placeId='" + placeId + '\'' +
                ", performerId='" + performerId + '\'' +
                ", startYear='" + startYear + '\'' +
                ", startMonth='" + startMonth + '\'' +
                ", startDay='" + startDay + '\'' +
                ", startHour='" + startHour + '\'' +
                ", startMinute='" + startMinute + '\'' +
                ", startSecond='" + startSecond + '\'' +
                ", stopYear='" + stopYear + '\'' +
                ", stopMonth='" + stopMonth + '\'' +
                ", stopDay='" + stopDay + '\'' +
                ", stopHour='" + stopHour + '\'' +
                ", stopMinute='" + stopMinute + '\'' +
                ", stopSecond='" + stopSecond + '\'' +
                '}';
    }
}