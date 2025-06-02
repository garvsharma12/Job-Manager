package com.url.jobmanager.jobmanager.job;

import java.util.*;

public interface JobService {
    List<Job> findAll();
    void createJob(Job job);

    Job getJobById(long id);

    boolean deleteJob(long id);

    boolean updateJob(Long id, Job job);
}
