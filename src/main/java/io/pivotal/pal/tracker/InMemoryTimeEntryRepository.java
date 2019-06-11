package io.pivotal.pal.tracker;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class InMemoryTimeEntryRepository {

    private List<TimeEntry> inMemoryList;

    public TimeEntry create(TimeEntry timeEntry) {

        long projectId = 123L;
        long userId = 456L;
        TimeEntry timeEntryToCreate = new TimeEntry(projectId, userId, LocalDate.parse("2017-01-08"), 8);
        return timeEntryToCreate;

    }

    public TimeEntry update(long timeEntryId, TimeEntry timeEntry){

        long projectId = 123L;
        long userId = 456L;
        TimeEntry timeEntryToCreate = new TimeEntry(projectId, userId, LocalDate.parse("2017-01-08"), 8);
        return timeEntryToCreate;

    }

    public TimeEntry find(long timeEntryId) {

        long projectId = 123L;
        long userId = 456L;
        TimeEntry timeEntryToCreate = new TimeEntry(projectId, userId, LocalDate.parse("2017-01-08"), 8);
        return timeEntryToCreate;

    }

    public static void delete(long timeEntryId){

    }

    public List<TimeEntry> list() {

        return inMemoryList;
    }
}
