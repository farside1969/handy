package com.handy.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class JobClass extends AbstractEntity {

//JobClass name field requirements with spring error message
    @NotNull
    @Size(min=3, max=30, message = "Name must be between 3 and 30 characters")
    private String name;

//spring tying many jobs to a jobClass uid relationship
//joining column allows hotlink in jobClass to jobs in same category
    @OneToMany
    @JoinColumn(name = "job_Class_uid")
    private List<Job> jobs = new ArrayList<>();

//default constructor
    public JobClass() {}

//constructor
    public JobClass(String name) {
        this.name = name;
    }

//getters and setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Job> getJobs() {
        return jobs;
    }
}
