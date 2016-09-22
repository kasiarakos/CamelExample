package com.kasiarakos.processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class DownloadProcessor implements Processor {

	@Override
	public void process(Exchange exch) throws Exception {
		String body = exch.getIn().getBody(String.class);
		System.out.println(body);
	}

}
