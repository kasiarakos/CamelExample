package com.kasiarakos.main;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class Main {
	
	public static void main(String[] args) throws Exception {
		CamelContext context = new DefaultCamelContext();
		context.addRoutes(new RouteBuilder() {
			
			@Override
			public void configure() throws Exception {
				from("file:data/in?noop=true").to("file:data/out");
				
			}
		});
		
		context.start();
		Thread.sleep(10000);
		context.stop();
	}

}
