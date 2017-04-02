package com.niit.collaboration.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.collaboration.dao.JobDAO;
import com.niit.collaboration.model.Job;
import com.niit.collaboration.model.JobApplication;

@Repository("jobDAO")
public class JobDAOImpl implements JobDAO {

	@Override
	public boolean updateJob(Job job) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Job getJobDetails(Long jobID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Job> getMyAppliedJobs(String loggedInUserID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Job> getAllOpendJobs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean save(JobApplication jobApplication) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public JobApplication getJobApplication(String userID, Long jobID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateJob(JobApplication jobApplication) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean save(Job job) {
		// TODO Auto-generated method stub
		return false;
	}

}
