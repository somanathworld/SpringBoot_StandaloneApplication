package com.nt.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

import com.nt.listener.JobMonitoringListener;
import com.nt.model.ExamResult;
import com.nt.processor.ExamResultItemProcessor;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

	@Autowired
	private DataSource ds;
	
	@Autowired
	private JobBuilderFactory jobFactory;
	
	@Autowired
	private StepBuilderFactory stepFactory;
	
	@Autowired
	private JobMonitoringListener listener;
	
	
	@Bean("processor")
	public ItemProcessor<ExamResult, ExamResult> createProcessor(){
		return new ExamResultItemProcessor();
	}
	
//	@Bean("reader")
//	public JdbcCursorItemReader<ExamResult> createReader1(){
//		//create Object
//		JdbcCursorItemReader<ExamResult> reader = new JdbcCursorItemReader<ExamResult>();
//		//specify datasource
//		reader.setDataSource(ds);
//		//specify sql query
//		reader.setSql("SELECT ID, DOB, PERCENTAGE, SEMESTER FROM EXAM_RESULT");
//		//reader.setRowMapper(new ExamResultRowMapper());
//		reader.setRowMapper((rs,rowNum)->new ExamResult(rs.getInt(1), rs.getDate(2), rs.getDouble(3), rs.getInt(4)));
//		
//		return reader;
//	}
	
	//or
	
	@Bean("reader")
	public JdbcCursorItemReader<ExamResult> createReader1(){
		return new JdbcCursorItemReaderBuilder<ExamResult>()
				.dataSource(ds)
				.name("reader1")
				.sql("SELECT ID, DOB, PERCENTAGE, SEMESTER FROM EXAM_RESULT LIMIT 100")
				.beanRowMapper(ExamResult.class)
				.build();
	}

//	@Bean("writer")
//	public FlatFileItemWriter<ExamResult> createWriter(){
//		System.out.println("BatchConfig.createWriter()");
//		FlatFileItemWriter<ExamResult> writer = new FlatFileItemWriter<ExamResult>();
//		//set logical name
//		//writer.setName("writer-csv");
//		
//		//specify the destination csv file locaion
//		writer.setResource(new ClassPathResource("TopBrains.csv"));
							//E:\Workspace\Exercise\Proj37-Boot_BatchProcessing_DB_FF\target\classes
//		
//		//specify LineAggregator by supplying delimiter and FieldExtractor
//		writer.setLineAggregator(new DelimitedLineAggregator<ExamResult>() {
//			{
//				setDelimiter(",");
//				setFieldExtractor(new BeanWrapperFieldExtractor<ExamResult>() {
//					{
//						setNames(new String[] {"id", "dob", "percentage", "semester"});
//					}
//				});
//			}
//			
//		});
//		return writer;
//	}
	
	
	@Bean
	public FlatFileItemWriter<ExamResult> createWriter(){
		   return  new  FlatFileItemWriterBuilder<ExamResult>()
				                     .name("line123")
//				                     .resource(new ClassPathResource("TopBrains.csv"))
				                     .resource(new FileSystemResource("e:\\csvs\\topbrains.csv"))
				                     .lineSeparator("\r\n")
				                     .delimited().delimiter(",")
				                     .names("id","dob","percentage","semester")
				                     .build();
	}	
	
	@Bean
	public Step createStep1() {
		return stepFactory
				.get("step1")
				.<ExamResult, ExamResult> chunk(3)
				.reader(createReader1())
				.writer(createWriter())
				.processor(createProcessor())
				.build();
	}
	
	@Bean
	public Job createJob1(){
		return jobFactory
				.get("job1")
				.incrementer(new RunIdIncrementer())
				.listener(listener)
				.start(createStep1())
				.build();
	}
	
	
}
