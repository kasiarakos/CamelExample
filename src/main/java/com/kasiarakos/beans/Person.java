package com.kasiarakos.beans;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

@XmlRootElement
@CsvRecord(separator = ",", crlf = "UNIX")
public class Person {

	@DataField(pos = 1)
	private String name;
	@DataField(pos = 2)
	private String surname;
	@DataField(pos = 3)
	private String job;
	
	public Person() {
		
	}

	public Person(String name, String surname, String job) {
		super();
		this.name = name;
		this.surname = surname;
		this.job = job;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

}
