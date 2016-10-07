package com.kasiarakos.spring.transaction;

import org.springframework.jdbc.core.support.JdbcDaoSupport;



public abstract class FundManagerDao extends JdbcDaoSupport implements FundManager {
	
	
	
	public void dotTansfer(int accountNbr1, int accountNbr2, int amount)
			throws Exception {
		
		
		verifyAccount(accountNbr1);
		System.out.println("Transfer amount: " + amount);
		Integer account1Balance = getJdbcTemplate().queryForObject(
				                 "SELECT BALANCE FROM Account WHERE ID = ?",
				                 new Object[] { accountNbr1 }, Integer.class);
		
		if (account1Balance < amount) {
			throw new RuntimeException("Cannot transfer, account doesn't have enough funds!");
		}
		int account1NewBalance = account1Balance - amount;			
		getJdbcTemplate().update(
				"UPDATE Account SET BALANCE = ? WHERE ID = ?",
				account1NewBalance, accountNbr1);
		Thread.sleep(5000);
		
		
		verifyAccount(accountNbr2);
		Integer account2Balance = getJdbcTemplate().queryForObject(
				"SELECT BALANCE FROM Account WHERE ID = ?",
				new Object[] { accountNbr2 }, Integer.class);
		int account2NewBalance = account2Balance + amount;
		getJdbcTemplate().update(
				"UPDATE Account SET BALANCE = ? WHERE ID = ?",
				account2NewBalance, accountNbr2);	
		Thread.sleep(5000);

	}

	@Override
	public int getBalance(int accountNbr) {
		return getJdbcTemplate().queryForObject(
				"SELECT BALANCE FROM Account WHERE ID = ?",
				new Object[] { accountNbr }, Integer.class);
	}

	@Override
	public void verifyAccount(int accountNbr) {
		
		boolean acountExists = getJdbcTemplate().
				queryForObject("SELECT 1 FROM Account WHERE ID = ?",
				new Object[] { accountNbr },
				Integer.class) == 1;

		if (!acountExists) {
			throw new RuntimeException("Account " + accountNbr
					+ " doesn't exists");
		}
	}

}
