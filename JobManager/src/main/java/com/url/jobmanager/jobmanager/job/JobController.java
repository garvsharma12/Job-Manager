package com.url.jobmanager.jobmanager.job;

import com.url.jobmanager.jobmanager.job.impl.JobServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/jobs")
public class JobController {
    public JobController(JobServiceImpl jobService) {
        this.jobService = jobService;
    }

    @Autowired
    private JobServiceImpl jobService;

    @GetMapping
    public ResponseEntity<List<Job>> findAll(){
        return new ResponseEntity<>(jobService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createJob(@RequestBody Job job){
        jobService.createJob(job);
        return new ResponseEntity<>("Job Created Successfully", HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable long id){
        Job job = jobService.getJobById(id);
        if(job == null){
            return new ResponseEntity<>(job,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(job, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long id){
        boolean deleted = jobService.deleteJob(id);
        if(deleted) return new ResponseEntity<>("Job Deleted Successfully", HttpStatus.OK);
        return new ResponseEntity<>("Job You Want To Delete Is Not Found", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    //@RequestMapping(value="/{id}",method = RequestMethod.PUT)
    public ResponseEntity<String> updateJob(@PathVariable Long id, @RequestBody Job updatedJob){
        boolean updated = jobService.updateJob(id,updatedJob);
        if(updated) return new ResponseEntity<>("Job Updated Successfully", HttpStatus.OK);
        return new ResponseEntity<>("Job You Want To Update Is Not Found", HttpStatus.NOT_FOUND);
    }
}
