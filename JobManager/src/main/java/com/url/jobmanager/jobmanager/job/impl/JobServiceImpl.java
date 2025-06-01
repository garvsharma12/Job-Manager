package com.url.jobmanager.jobmanager.job.impl;

import com.url.jobmanager.jobmanager.job.Job;
import com.url.jobmanager.jobmanager.job.JobService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
@Service
public class JobServiceImpl implements JobService {
    private List<Job> jobs = new ArrayList<>();

    public List<Job> findAll() {
        return jobs;
    }
    public void createJob(Job job){
        jobs.add(job);
    }

    @Override
    public Job getJobById(long id) {
        for(Job job : jobs){
            if(job.getId() == id){
                return job;
            }
        }
        return null;
    }
    @Override
    public boolean deleteJob(long id) {
        for(int i = 0; i < jobs.size(); i++){
            if(jobs.get(i).getId() == id){
                jobs.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updateJob(Long id, Job updatedJob) {
        for(Job job : jobs){
            if(job.getId() == id){
                job.setLocation(updatedJob.getLocation());
                job.setMaxSalary(updatedJob.getMaxSalary());
                job.setMinSalray(updatedJob.getMinSalray());
                job.setTitle(updatedJob.getTitle());
                job.setDescription(updatedJob.getDescription());
                return true;
            }
        }
        return false;
    }
}
