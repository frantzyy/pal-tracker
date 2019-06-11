package io.pivotal.pal.tracker;

import java.time.LocalDate;

public class TimeEntry {

    private long timeEntryId;
    private long projectId;
    private long userId;
    private LocalDate date;
    private int hours;

    //create
    public TimeEntry(long projectId, long userId, LocalDate parse, int id) {

    }

    public long getId() {

        return timeEntryId;
    }

    //fetch
    public TimeEntry(long timeEntryId, long projectId, long userId, LocalDate parse, int id) {

    }

    public TimeEntry(){

    }

}
