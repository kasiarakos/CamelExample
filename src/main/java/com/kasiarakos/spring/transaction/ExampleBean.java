package com.kasiarakos.spring.transaction;

import org.springframework.beans.factory.annotation.Autowired;

public class ExampleBean {

	@Autowired
	FundManager fundManager;

	public void run() {
		try {
			int amount = 200;
			printAccountDetails(fundManager);
			fundManager.transfer(1, 2, amount);
			System.out.println("Fund transfered");
			
			printAccountDetails(fundManager);
			fundManager.transfer(1, 2, 100);
			printAccountDetails(fundManager);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static void printAccountDetails(FundManager fundManager) {
		System.out.println("Account 1 has " + fundManager.getBalance(1) + ", account 2 has " + fundManager.getBalance(2));
	}

}
