package com.nt.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nt.listener.JobMonitoringListener;
import com.nt.processor.BookDetailsProcessor;
import com.nt.reader.BookDetailsReader;
import com.nt.writer.BookDetailsWriter;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

	@Autowired
	private JobBuilderFactory jbFactory;
	
	@Autowired
	private StepBuilderFactory sbFactory;

	@Autowired
	private JobMonitoringListener listener;
	
	@Autowired
	private BookDetailsReader bdReader;
	
	@Autowired
	private BookDetailsWriter bdWriter;
	
	@Autowired
	private BookDetailsProcessor bdProcessor;
	

	@Bean(name="step1")	
	public Step createStep1() {
		System.out.println("BatchConfig.createStep()");
		return sbFactory.get("step1")
						.<String, String> chunk(3)
						.reader(bdReader)
						.writer(bdWriter)
						.processor(bdProcessor)
						.build();
	}
	
	@Bean(name = "job1")
	public Job createJob() {
		System.out.println("BatchConfig.createJob()");
		return jbFactory.get("job1")
						.incrementer(new RunIdIncrementer())
						.listener(listener)
						.start(createStep1())
						.build();
	}
	
}
