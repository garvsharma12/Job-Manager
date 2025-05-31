package com.url.jobmanager.jobmanager.job;

public class Job {
    private long id;
    private String title;
    private String description;
    private String minSalray;
    private String maxSalary;
    private String location;

    public Job(String description, long id, String location, String maxSalary, String minSalray, String title) {
        this.description = description;
        this.id = id;
        this.location = location;
        this.maxSalary = maxSalary;
        this.minSalray = minSalray;
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(String maxSalary) {
        this.maxSalary = maxSalary;
    }

    public String getMinSalray() {
        return minSalray;
    }

    public void setMinSalray(String minSalray) {
        this.minSalray = minSalray;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
