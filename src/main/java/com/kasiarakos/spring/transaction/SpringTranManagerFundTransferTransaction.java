package com.kasiarakos.spring.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;


public class SpringTranManagerFundTransferTransaction extends FundManagerDao {

	private PlatformTransactionManager transactionManager;

	
	
	
	@Autowired
	public void setTransactionManager(PlatformTransactionManager txManager) {
		this.transactionManager = txManager;
		
	}
	
	

	@Override
	public void transfer(int accountNbr1, int accountNbr2, int amount)
			throws Exception {
		TransactionDefinition txDef = new DefaultTransactionDefinition();
		TransactionStatus txStatus = transactionManager.getTransaction(txDef);
		try {
			dotTansfer(accountNbr1, accountNbr2, amount);
			transactionManager.commit(txStatus);
		} catch (Exception e) {
			transactionManager.rollback(txStatus);
			throw e;
		}

	}

}
