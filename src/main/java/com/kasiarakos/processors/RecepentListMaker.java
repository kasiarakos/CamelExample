package com.kasiarakos.processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class RecepentListMaker implements Processor {

	@Override
	public void process(Exchange ex) throws Exception {
		String recipients = "file:data/out";
		String customer = ex.getIn().getHeader("customer", String.class);
		if (customer.equals("honda")) {
			recipients += ",file:data/out2";
		}
		ex.getIn().setHeader("recipients", recipients);

	}

}
