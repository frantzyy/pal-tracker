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

    @Override
    public boolean equals(Object o){

        //https://www.geeksforgeeks.org/overriding-equals-method-in-java/

        // If the object is compared with itself then return true
        if (o == this) {
            return true;
        }

        /* Check if o is an instance of Complex or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof TimeEntry)) {
            return false;
        }

        // typecast o to Complex so that we can compare data members
        TimeEntry c = (TimeEntry) o;

        // Compare the data members and return accordingly
        return Long.compare(timeEntryId, c.timeEntryId) == 0
                && Long.compare(projectId, c.projectId) == 0
                && Long.compare(userId, c.userId) == 0
                && date.compareTo(c.date) == 0
                && Integer.compare(hours, c.hours) == 0;

    }
}

