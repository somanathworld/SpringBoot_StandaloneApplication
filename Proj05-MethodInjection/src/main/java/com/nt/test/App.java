package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.comp.Bank;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
    	Bank bank = ctx.getBean("bank", Bank.class);
        System.out.println( "Interest : "+bank.calculateInterestAmount(1000, 10, 2) );
        ((AbstractApplicationContext) ctx).close();
    }
}
