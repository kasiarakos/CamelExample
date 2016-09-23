package com.kasiarakos.main;	

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) throws Exception {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("camelContext.xml");
		
		CamelContext camelContext = context.getBean(CamelContext.class);
		ProducerTemplate template = camelContext.createProducerTemplate();
		template.sendBody("direct:start","Title: Hello World \n kasiarakos test \n This is the end");
		
		context.start();
		Thread.sleep(10000);
		context.stop();
		context.close();
	}

}
