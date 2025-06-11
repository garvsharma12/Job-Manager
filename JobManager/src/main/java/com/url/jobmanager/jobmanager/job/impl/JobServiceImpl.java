package com.url.jobmanager.jobmanager.job.impl;

import com.url.jobmanager.jobmanager.job.Job;
import com.url.jobmanager.jobmanager.job.JobRepository;
import com.url.jobmanager.jobmanager.job.JobService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {
    //private List<Job> jobs = new ArrayList<>();
    JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public List<Job> findAll() {
        return jobRepository.findAll();
    }
    public void createJob(Job job){
        jobRepository.save(job);
    }

    @Override
    public Job getJobById(long id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteJob(long id) {
        try{
            jobRepository.deleteById(id);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean updateJob(Long id, Job updatedJob) {
        Optional<Job> job = jobRepository.findById(id);
        if(job.isPresent()){
            job.get().setDescription(updatedJob.getDescription());
            job.get().setLocation(updatedJob.getLocation());
            job.get().setMaxSalary(updatedJob.getMaxSalary());
            job.get().setMinSalray(updatedJob.getMinSalray());
            job.get().setTitle(updatedJob.getTitle());
            jobRepository.save(job.get());
            return true;
        }
        return false;
    }
}
