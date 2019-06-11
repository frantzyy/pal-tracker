package io.pivotal.pal.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public class TimeEntryController {
    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
    }

    public ResponseEntity create(TimeEntry timeEntryToCreate) {

        ResponseEntity mockResponseEntity = new ResponseEntity(HttpStatus.CREATED);

        return mockResponseEntity;
    }

    public ResponseEntity<TimeEntry> read(long timeEntryId) {

        ResponseEntity mockResponseEntity = new ResponseEntity(HttpStatus.FOUND);

        return mockResponseEntity;
    }

    public ResponseEntity<List<TimeEntry>> list() {


        List<TimeEntry> mockList = new ArrayList<>();

        return new ResponseEntity<List<TimeEntry>>(mockList, HttpStatus.OK);
    }

    public ResponseEntity update(long timeEntryId, TimeEntry expected) {

        ResponseEntity mockResponseEntity = new ResponseEntity(HttpStatus.OK);

        return mockResponseEntity;
    }

    public ResponseEntity delete(long timeEntryId) {

        ResponseEntity mockResponseEntity = new ResponseEntity(HttpStatus.OK);

        return mockResponseEntity;

    }
}
