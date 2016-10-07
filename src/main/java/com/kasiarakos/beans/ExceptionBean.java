package com.kasiarakos.beans;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class ExceptionBean implements Processor {

	@Override
	public void process(Exchange arg0) throws Exception {
		throw new Exception("fSo fucking what");
	}

}
