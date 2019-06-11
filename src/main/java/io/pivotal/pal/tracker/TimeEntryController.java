package io.pivotal.pal.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/time-entries")
public class TimeEntryController {
    private final TimeEntryRepository timeEntryRepository;

    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody TimeEntry timeEntryToCreate) {

        TimeEntry newTimeEntryCreated = this.timeEntryRepository.create(timeEntryToCreate);

        ResponseEntity responseEntity = new ResponseEntity(newTimeEntryCreated, HttpStatus.CREATED);

        return responseEntity;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TimeEntry> read(@PathVariable("id") long timeEntryId) {


        TimeEntry foundTimeEntry = this.timeEntryRepository.find(timeEntryId);

        if(foundTimeEntry == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);

        }else {
            return new ResponseEntity(foundTimeEntry, HttpStatus.OK);

        }
    }

    @GetMapping
    public ResponseEntity<List<TimeEntry>> list() {

        List<TimeEntry> repoList  = this.timeEntryRepository.list();

        return new ResponseEntity<List<TimeEntry>>(repoList, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") long timeEntryId, @RequestBody TimeEntry timeEntryToUpdate) {

        TimeEntry newTimeEntryCreated = this.timeEntryRepository.update(timeEntryId, timeEntryToUpdate);

        if(newTimeEntryCreated == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity(newTimeEntryCreated, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") long timeEntryId) {

       this.timeEntryRepository.delete(timeEntryId);

        ResponseEntity responseEntity = new ResponseEntity(HttpStatus.NO_CONTENT);

        return responseEntity;

    }
}
