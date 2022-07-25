package com.nt.listener;

import java.util.Date;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

@Component
public class JobMonitoringListener implements JobExecutionListener {

	long startTime, endTime;

	public JobMonitoringListener() {
		System.out.println("JobMonitoringListener.JobMonitoringListener()");
	}

	@Override
	public void beforeJob(JobExecution jobExecution) {
		System.out.println("JobMonitoringListener.beforeJob()");
		System.out.println("Job is about to begin @" + new Date());
		startTime = System.currentTimeMillis();
		System.out.println("Job Status :: " + jobExecution.getStatus());
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		System.out.println("JobMonitoringListener.afterJob()");
		System.out.println("Job Completed @" + new Date());
		endTime = System.currentTimeMillis();
		System.out.println("Job status :: " + jobExecution.getStatus());
		System.out.println("Job Execution time :: " + (endTime - startTime));
		System.out.println("Job Exit status :: " + jobExecution.getStatus());
		System.out.println("jobExecution.getStartTime() start : " + jobExecution.getStartTime());
		System.out.println("jobExecution.getEndTime() end : " + jobExecution.getEndTime());
	}

}
