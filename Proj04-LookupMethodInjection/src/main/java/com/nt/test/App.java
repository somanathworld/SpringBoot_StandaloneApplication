package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.comp.Cricket;

public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
    	Cricket crckt = ctx.getBean("crckt",Cricket.class);
    	crckt.bowling();
    	crckt.fielding();
    	crckt.batting();
    	((AbstractApplicationContext) ctx).close();
    }
}
