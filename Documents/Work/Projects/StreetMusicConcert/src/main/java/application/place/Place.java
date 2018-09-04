package application.place;

import application.event.PerformanceEvent;
import application.util.TimeSlot;

import java.util.List;

public class Place {

    private EventAddress eventAddress;
    private Coordinate coordinate;
    private boolean hasRoof;
    private PerformanceEvent currentPerformanceEvent;
    private List<PerformanceEvent> pastPerformanceEvents;
    private List<TimeSlot> busyTimeSlots;
}
