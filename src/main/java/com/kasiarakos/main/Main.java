package com.kasiarakos.main;	

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) throws Exception {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("camelContext.xml");
		
		context.start();
		Thread.sleep(10000);
		context.stop();
		context.close();
	}

}
