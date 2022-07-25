package com.nt.processor;

import org.springframework.batch.item.ItemProcessor;

import com.nt.model.Employee;

public class EmployeeInfoItemProcessor implements ItemProcessor<Employee, Employee>{

	public Employee process(Employee emp) throws Exception {
		if(emp.getSalary() >= 100000) {
			emp.setGrossSalary(emp.getSalary()+emp.getSalary()*0.4);
			emp.setNetSalary(emp.getGrossSalary()-emp.getSalary()*0.2);
			return emp;
		}else {
			return null;
		}
	}
}
