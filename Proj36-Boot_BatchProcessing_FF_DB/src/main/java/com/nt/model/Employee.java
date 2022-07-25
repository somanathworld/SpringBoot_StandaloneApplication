package com.nt.model;

import lombok.Data;

@Data
public class Employee {
	
	private Integer empno;
	private String ename;
	private Double salary;
	private String eadd;
	private Double grossSalary;
	private Double netSalary;
}
