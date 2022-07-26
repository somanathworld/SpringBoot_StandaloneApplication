package com.nt.processor;

import java.time.LocalDate;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.nt.model.IExamResult;
import com.nt.model.OExamResult;

@Component
public class ExamResultItemProcessor implements ItemProcessor<IExamResult, OExamResult> {
	@Override
	public OExamResult process(IExamResult item) throws Exception {
		System.out.println("ExamResultItemProcessor.process()");
		if (item.getPercentage() <= 90) {
			OExamResult result = new OExamResult();
			result.setId(item.getId());
			result.setDob(LocalDate.parse(item.getDob().split(" ")[0]));
			result.setPercentage(item.getPercentage());
			result.setSemester(item.getSemester());
			return result;
		} else {
			return null;
		}
	}
}
