package io.pivotal.pal.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public class TimeEntryController {
    private final TimeEntryRepository timeEntryRepository;

    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }

    public ResponseEntity create(TimeEntry timeEntryToCreate) {

        TimeEntry newTimeEntryCreated = this.timeEntryRepository.create(timeEntryToCreate);

        ResponseEntity responseEntity = new ResponseEntity(newTimeEntryCreated, HttpStatus.CREATED);

        return responseEntity;
    }

    public ResponseEntity<TimeEntry> read(long timeEntryId) {


        TimeEntry foundTimeEntry = this.timeEntryRepository.find(timeEntryId);

        if(foundTimeEntry == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);

        }else {
            return new ResponseEntity(foundTimeEntry, HttpStatus.OK);

        }
    }

    public ResponseEntity<List<TimeEntry>> list() {

        List<TimeEntry> repoList  = this.timeEntryRepository.list();

        return new ResponseEntity<List<TimeEntry>>(repoList, HttpStatus.OK);
    }

    public ResponseEntity update(long timeEntryId, TimeEntry timeEntryToUpdate) {

        TimeEntry newTimeEntryCreated = this.timeEntryRepository.update(timeEntryId, timeEntryToUpdate);

        if(newTimeEntryCreated == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity(newTimeEntryCreated, HttpStatus.OK);
        }
    }

    public ResponseEntity delete(long timeEntryId) {

       this.timeEntryRepository.delete(timeEntryId);

        ResponseEntity responseEntity = new ResponseEntity(HttpStatus.NO_CONTENT);

        return responseEntity;

    }
}
