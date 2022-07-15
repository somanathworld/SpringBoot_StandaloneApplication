package com.nt.advice;

import java.io.FileWriter;
import java.io.Writer;
import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@Component
//@Aspect
//@Order(3)
public class DiscountCopunAdvice {

//	@AfterReturning(pointcut = "execution(double com.nt.service.OnlineStore.shopping(..))", returning = "billAmnt")
//	public void generateCopun(JoinPoint jp, double billAmnt) throws Throwable{
//		System.out.println("DiscountCopunAdvice.generateCopun()");
//		String cuponMsg = null;
//		if(billAmnt >= 5000)
//			cuponMsg = "Avail discount 40% on next purchase.";
//		else if(billAmnt >= 3000)
//			cuponMsg = "Avail discount 30% on next purchase.";
//		else
//			cuponMsg = "Avail discount 20% on next purchase.";
//		
//		//generate the cupon
//		Writer writer = new FileWriter("discount_cupon.txt", true);
//		writer.write(cuponMsg);
//		writer.flush();
//		writer.close();
//	}

//	@AfterReturning(pointcut = "execution(double com.nt.service.OnlineStore.shopping(..)) and args(item, price)", returning = "billAmnt")
//	public void generateCopun(String[] item, double[] price, double billAmnt) throws Throwable{
//		System.out.println("DiescountCopunAdvice.generateCopun()"+Arrays.toString(item)+" "+Arrays.toString(price));
//		String cuponMsg = null;
//		if(billAmnt >= 5000)
//			cuponMsg = "Avail discount 40% on next purchase.";
//		else if(billAmnt >= 3000)
//			cuponMsg = "Avail discount 30% on next purchase.";
//		else
//			cuponMsg = "Avail discount 20% on next purchase.";
//		
//		//generate the cupon
//		Writer writer = new FileWriter("discount_cupon.txt", true);
//		writer.write(cuponMsg);
//		writer.flush();
//		writer.close();
//	}
//
	
//	public   void    generateCupon( double billAmt)throws  Throwable{
//		System.out.println("DiscountCuponAdvice.generateCupon()");
//		String cuponMsg=null;
//		if(billAmt>=50000)
//			  cuponMsg="Avail  30%  discount  on next purchase";
//		else if(billAmt>=30000)
//			cuponMsg="Avail  15%  discount  on next purchase";
//		else 
//			cuponMsg="Avail  5%  discount  on next purchase";
//		//generate the cupon
//		Writer writer =new FileWriter("e:\\cupon.txt");
//		writer.write(cuponMsg);
//		writer.flush();
//		writer.close();
//		
//	}
}
