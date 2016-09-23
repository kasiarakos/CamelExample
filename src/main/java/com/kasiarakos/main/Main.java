package com.kasiarakos.main;	

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kasiarakos.beans.Person;

public class Main {
	
	public static void main(String[] args) throws Exception {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("camelContext.xml");
		
		CamelContext camelContext = context.getBean(CamelContext.class);
		ProducerTemplate template = camelContext.createProducerTemplate();
		Person kasiarakos = new Person("Dimitris", "Kasiaras", "Software Engineer");
		template.sendBody("direct:start",kasiarakos);
		
		context.start();
		Thread.sleep(10000);
		context.stop();
		context.close();
	}

}
