package com.url.jobmanager.jobmanager.job;

import com.url.jobmanager.jobmanager.job.impl.JobServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class JobController {
    public JobController(JobServiceImpl jobService) {
        this.jobService = jobService;
    }

    @Autowired
    private JobServiceImpl jobService;

    @GetMapping("/jobs")
    public List<Job> findAll(){
        return jobService.findAll();
    }
    @PostMapping("/jobs")
    public String createJob(@RequestBody Job job){
        jobService.createJob(job);
        return "Job Created Successfully";
    }
    @GetMapping("/jobs/{id}")
    public Job getJobById(@PathVariable long id){
        Job job = jobService.getJobById(id);
        if(job == null){
            throw new RuntimeException("Job Not Found");
        }
        return job;
    }
}
