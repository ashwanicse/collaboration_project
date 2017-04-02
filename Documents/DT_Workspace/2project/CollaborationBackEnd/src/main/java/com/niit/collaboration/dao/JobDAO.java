package com.niit.collaboration.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.collaboration.model.Job;
import com.niit.collaboration.model.JobApplication;

@Repository("jobDAO")
public interface JobDAO {

	boolean updateJob(Job job);

	Job getJobDetails(Long jobID);

	List<Job> getMyAppliedJobs(String loggedInUserID);

	List<Job> getAllOpendJobs();

	boolean save(JobApplication jobApplication);

	JobApplication getJobApplication(String userID, Long jobID);

	boolean updateJob(JobApplication jobApplication);

	boolean save(Job job);

}
