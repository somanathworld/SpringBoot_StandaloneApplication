package com.nt.advice;

import java.io.FileWriter;
import java.io.Writer;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@Component
//@Aspect
//@Order(1)
public class TestDrivingAuditAdvice {
	
//	@Before(value = "execution(java.lang.String com.nt.service.CarShowRoom.sellCar(..))")
//	public void testDriving(JoinPoint jp) throws Throwable{
//	System.out.println("TestDrivingAuditAdvice.testDriving()");
//	String custName = (String) jp.getArgs()[0];
//	String carModel = (String) jp.getArgs()[1];
//	double price = (double) jp.getArgs()[2];
//	String auditLogMsg = custName+ " customer has come for test driving of "+carModel+" model on "+new Date()+"\n";
//	Writer writer = new FileWriter("TestDriveAudit_log.txt", true);
//	writer.write(auditLogMsg);
//	writer.flush();
//	writer.close();
//}
	
	//While developing advice method for before advice, we can make it completely non-invasive
	//i.e. we can avoid the usage of aspectj api based JoinPoint parameter in the advice method.
	//but params name must be same.
//	@Before(value = "execution(java.lang.String com.nt.service.CarShowRoom.sellCar(..)) and args(custName1, carModel1, price1)")
	public void testDriving(String custName1, String carModel1, double price1) throws Throwable{
		System.out.println("TestDrivingAuditAdvice.testDriving()");
		String auditLogMsg = custName1+ " customer has come for test driving of "+carModel1+" model on "+new Date();
		Writer writer = new FileWriter("TestDriveAudit_log.txt", true);
		writer.write(auditLogMsg);
		writer.flush();
		writer.close();
	}

}
