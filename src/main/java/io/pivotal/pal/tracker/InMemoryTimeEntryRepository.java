package io.pivotal.pal.tracker;

import java.time.LocalDate;
import java.util.*;

public class InMemoryTimeEntryRepository implements TimeEntryRepository{

    private Map<Long,TimeEntry> timeEntryMap;
    private int count;

    public InMemoryTimeEntryRepository() {

        this.timeEntryMap = new HashMap();
        this.count = 1;

    }

    public TimeEntry create(TimeEntry timeEntry) {


        TimeEntry ourSweetNewTimeEntry = new TimeEntry(generateID(), timeEntry.getProjectId(), timeEntry.getUserId(), timeEntry.getDate(), timeEntry.getHours());
        this.timeEntryMap.put(ourSweetNewTimeEntry.getId(), ourSweetNewTimeEntry);

        return ourSweetNewTimeEntry;

    }

    public TimeEntry update(long timeEntryId, TimeEntry timeEntry) {

        if(this.timeEntryMap.containsKey(timeEntryId)){
            TimeEntry timeEntryToCreate = new TimeEntry(timeEntryId, timeEntry.getProjectId(), timeEntry.getUserId(), timeEntry.getDate(), timeEntry.getHours());
            this.timeEntryMap.put(timeEntryToCreate.getId(), timeEntryToCreate);

            return timeEntryToCreate;

        }else {
            return null;

        }



    }

    public TimeEntry find(long timeEntryId) {

        return this.timeEntryMap.get(timeEntryId);

    }

    public void delete(long timeEntryId) {

        this.timeEntryMap.remove(timeEntryId);

    }

    public List<TimeEntry> list() {

        return new ArrayList<>(this.timeEntryMap.values());
    }


    public long generateID() {

        return this.count++;

    }
}
