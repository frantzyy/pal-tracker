package io.pivotal.pal.tracker;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.DistributionSummary;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/time-entries")
public class TimeEntryController {
    private TimeEntryRepository timeEntryRepository;
    private final DistributionSummary timeEntrySummary;
    private final Counter actionCounter;

    public TimeEntryController(TimeEntryRepository timeEntryRepository, MeterRegistry meterRegistry) {
        this.timeEntryRepository = timeEntryRepository;

        timeEntrySummary = meterRegistry.summary("timeEntry.summary");
        actionCounter = meterRegistry.counter("timeEntry.actionCounter");
    }

    @PostMapping
    public ResponseEntity create(@RequestBody TimeEntry timeEntryToCreate) {

        TimeEntry newTimeEntryCreated = this.timeEntryRepository.create(timeEntryToCreate);

        actionCounter.increment();
        timeEntrySummary.record(timeEntryRepository.list().size());

        ResponseEntity responseEntity = new ResponseEntity(newTimeEntryCreated, HttpStatus.CREATED);

        return responseEntity;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TimeEntry> read(@PathVariable("id") long timeEntryId) {


        TimeEntry foundTimeEntry = this.timeEntryRepository.find(timeEntryId);

        if(foundTimeEntry == null){

            return new ResponseEntity(HttpStatus.NOT_FOUND);

        }else {
            actionCounter.increment();
            return new ResponseEntity(foundTimeEntry, HttpStatus.OK);

        }
    }

    @GetMapping
    public ResponseEntity<List<TimeEntry>> list() {

        List<TimeEntry> repoList  = this.timeEntryRepository.list();

        actionCounter.increment();

        return new ResponseEntity<List<TimeEntry>>(repoList, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") long timeEntryId, @RequestBody TimeEntry timeEntryToUpdate) {

        TimeEntry newTimeEntryCreated = this.timeEntryRepository.update(timeEntryId, timeEntryToUpdate);

        if(newTimeEntryCreated == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }else {
            actionCounter.increment();
            return new ResponseEntity(newTimeEntryCreated, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") long timeEntryId) {

       this.timeEntryRepository.delete(timeEntryId);

        actionCounter.increment();
        timeEntrySummary.record(timeEntryRepository.list().size());

        ResponseEntity responseEntity = new ResponseEntity(HttpStatus.NO_CONTENT);

        return responseEntity;

    }
}
