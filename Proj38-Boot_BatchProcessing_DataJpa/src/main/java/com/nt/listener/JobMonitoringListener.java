package com.nt.listener;

import java.util.Date;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class JobMonitoringListener implements JobExecutionListener {

	long start,end;
	
	@Override
	public void beforeJob(JobExecution jobExecution) {
		System.out.println("JobMonitoringListener.beforeJob()");
		start = System.currentTimeMillis();
		System.out.println("Job is going start @"+new Date());
		System.out.println("Job status :: "+jobExecution.getStatus());
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		System.out.println("JobMonitoringListener.afterJob()");
		end = System.currentTimeMillis();
		System.out.println("Job completed @"+new Date());
		System.out.println("Job completed status :: "+jobExecution.getStatus());
		System.out.println("Time required : "+(end-start));
	}

}
