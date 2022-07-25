package com.nt.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.nt.listener.JobMonitoringListener;
import com.nt.model.Employee;
import com.nt.processor.EmployeeInfoItemProcessor;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
	
	@Autowired
	private DataSource ds;
	
	@Autowired
	private JobBuilderFactory jobFactory;
	
	@Autowired
	private StepBuilderFactory stepFactory;

	
	@Bean
	public JobExecutionListener createListener() {
		return new JobMonitoringListener();
	}
	
	@Bean("reader")
	public ItemReader<Employee> createReader(){
		//create object for FlatFileItemReader obj
		FlatFileItemReader<Employee> reader = new FlatFileItemReader<>();
		//set source csv file location
		reader.setResource(new ClassPathResource("Employee_info.csv"));
//		reader.setResource(new FileSystemResource("e:\\abc\\Employee_info.csv"));
//		reader.setResource(new UrlResource("http://nit.com/csv/Employee_info.csv"));
		
		//set LineMapper
		reader.setLineMapper(new DefaultLineMapper<Employee>() {
			{ 				//instance block
				setLineTokenizer(new DelimitedLineTokenizer() {
					{
						setDelimiter(",");
						setNames("empno", "ename", "salary", "eadd");
					}
				});
				
				//set FieldSetMapper to write each Line content to Model obj
				setFieldSetMapper(new BeanWrapperFieldSetMapper<Employee>() {
					{
						setTargetType(Employee.class);
					}
				});
			}
		});
		
		return reader;
	}
	
	
	//or
	
//	@Bean("reader")
//	public ItemReader<Employee> createReader1(){
//		//create object of FlatFileItemREader
//		FlatFileItemReader<Employee> reader = new FlatFileItemReader<Employee>();
//		reader.setResource(new ClassPathResource("Employee_info.csv"));
//		DefaultLineMapper<Employee> lineMapper = new DefaultLineMapper<Employee>();
//		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
//		lineTokenizer.setDelimiter(",");
//		lineTokenizer.setNames("empno", "ename", "salary", "eadd");
//		BeanWrapperFieldSetMapper<Employee> mapper = new BeanWrapperFieldSetMapper<Employee>();
//		mapper.setTargetType(Employee.class);
//		lineMapper.setLineTokenizer(lineTokenizer);
//		lineMapper.setFieldSetMapper(mapper);
//		reader.setLineMapper(lineMapper);
//		return reader;
//	}
	
	
//	@Bean("reader")
//	public ItemReader<Employee> createReader1(){
//		return new FlatFileItemReaderBuilder<Employee>()
//				.name("file-reader")
//				.resource(new ClassPathResource("Employee_info.csv"))
//				.delimited().delimiter(",")
//				.names("empno", "ename", "salary", "eadd")
//				.targetType(Employee.class)
//				.build();
//	}
	
	@Bean
	public EmployeeInfoItemProcessor createProcessor() {
		return new EmployeeInfoItemProcessor();
	}
	
	@Bean(name = "writer")
	public ItemWriter<Employee> createWriter(){
		JdbcBatchItemWriter<Employee> writer = new JdbcBatchItemWriter<Employee>();
		//set datasource
		writer.setDataSource(ds);
		//set SQL query with named parameters
		writer.setSql("INSERT INTO BATCH_EMPLOYEE VALUES(:empno, :ename, :salary, :eadd, :grossSalary, :netSalary)");
		//set Model class obj as SqlParameterSourceProvider(here named param name and model class property names must match. )
		writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Employee>());
		return writer;
	}
	
	
	//or
	
//	@Bean("writer")
//	public ItemWriter<Employee> createWriter1(){
//		return new JdbcBatchItemWriterBuilder<Employee>()
//					.dataSource(ds)
//					.sql("INSERT INTO BATCH_EMPLOYEE VALUES(:empno, :ename, :salary, :eadd, :grossSalary, :netSalary)")
//					.beanMapped()  //makes to use BeanPropertyItemSqlParameterSourceProvider internally
//					.build();
//	}
	
	@Bean(name="step1")
	public Step createStep1() {
		return stepFactory
				.get("step1")
				.<Employee, Employee>chunk(3)
				.reader(createReader())
				.processor(createProcessor())
				.writer(createWriter())
				.build();
	}
	
	@Bean(name="job1")
	public Job createJob1() {
		return jobFactory
				.get("job1")
				.incrementer(new RunIdIncrementer())
				.listener(createListener())
				.start(createStep1())
				.build();
	}
}
