package com.kasiarakos.beans;

public class Person {

	private String name;
	private String surname;
	private String job;

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
