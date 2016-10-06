package com.kasiarakos.beans;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class MyBean {

	public void process(Exchange ex) throws Exception {
		
		System.out.println(ex.getIn().getBody());
		Integer test = ex.getIn().getHeader("kasiarakostest", Integer.class);
		System.out.println(test);
		System.out.println();
		
	}
}
