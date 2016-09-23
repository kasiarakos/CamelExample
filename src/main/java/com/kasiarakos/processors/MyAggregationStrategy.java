package com.kasiarakos.processors;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;

public class MyAggregationStrategy implements AggregationStrategy{

	@Override
	public Exchange aggregate(Exchange oldEx, Exchange newEx) {
		
		if(newEx==null){
			return oldEx;
		}
		
		String oldBody = oldEx.getIn().getBody(String.class);
		String newBody = newEx.getIn().getBody(String.class);
		
		oldEx.getIn().setBody(oldBody +" " +newBody);
		
		return oldEx;
	}

}
