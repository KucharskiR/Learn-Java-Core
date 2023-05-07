package com.itbulls.learnit.javacore.oop.hw.accounttransactions;

import java.util.Arrays;

public class Account {
	
//	<write your code here>
	private static final int DEFAULT_TRANSACTIONS_AMOUNT = 10;
	
	public int id;
	public Transaction[] transactions;
	private int lastTransactionIndex;
	
	{
		transactions = new Transaction[DEFAULT_TRANSACTIONS_AMOUNT];
	}
	
	public Account(int id) {
		super();
		this.id = id;
	}

	public void sendMoneyToAccount(Account accountTo, double moneyAmount) {
		if (accountTo == null) {
			return;
		}
		if (moneyAmount <= 0) {
			return;
		}
		Transaction transactionSend = new Transaction(Account.this, accountTo, moneyAmount, StandardAccountOperations.MONEY_TRANSFER_SEND);
	    addTransaction(transactionSend);
	    accountTo.receiveMoney(this, moneyAmount);
//	    <write your code here>
	}
	public void receiveMoney(Account accountFrom, double moneyAmount) {
		if (accountFrom == null) {
			return;
		}
		if (moneyAmount <= 0) {
			return;
		}
		Transaction transactionReceive = new Transaction(accountFrom, Account.this, moneyAmount, StandardAccountOperations.MONEY_TRANSFER_RECEIVE);
		addTransaction(transactionReceive);
//	    <write your code here>
	}
	
	public void withdrawMoney(double moneyAmount) {
//		<write your code here>
		Transaction transactionWithdraw = new Transaction(Account.this, null, moneyAmount, StandardAccountOperations.WITHDRAW);
		this.transactions[transactions.length-1] = transactionWithdraw;
	}
	
	private void addTransaction(Transaction transaction) {
		if (transaction == null) {
			return;
		}
		if (transactions.length <= lastTransactionIndex) {
			transactions = Arrays.copyOf(transactions, transactions.length << 1);
		}
		transactions[lastTransactionIndex++] = transaction;
	}
	
	@Override
	public String toString() {
		return "Account ID: " + this.id;
	}
	
	public Transaction[] getTransactions() {
		int nonNullTransactionsAmount = 0;
		for (Transaction transaction : transactions) {
			if (transaction != null) {
				nonNullTransactionsAmount++;
			}
		}

		Transaction[] filteredTransactions = new Transaction[nonNullTransactionsAmount];
		int index = 0;
		for (Transaction transaction : transactions) {
			if (transaction != null) {
				filteredTransactions[index++] = transaction;
			}
		}
		return filteredTransactions;

	
	}
	
	public static class Transaction {
//        <write your code here>

		Account accountFrom;
		Account accountTo;
		double moneyAmount;
		StandardAccountOperations operation;
		
		public Transaction(Account accountFrom, Account accountTo, double moneyAmount,
				StandardAccountOperations operation) {
			super();
			this.accountFrom = accountFrom;
			this.accountTo = accountTo;
			this.moneyAmount = moneyAmount;
			this.operation = operation;
			
			
		}

		public Account getAccountFrom() {
			return accountFrom;
		}

		public void setAccountFrom(Account accountFrom) {
			this.accountFrom = accountFrom;
		}

		public Account getAccountTo() {
			return accountTo;
		}

		public void setAccountTo(Account accountTo) {
			this.accountTo = accountTo;
		}

		public double getMoneyAmount() {
			return moneyAmount;
		}

		public void setMoneyAmount(double moneyAmount) {
			this.moneyAmount = moneyAmount;
		}

		public StandardAccountOperations getOperation() {
			return operation;
		}

		public void setOperation(StandardAccountOperations operation) {
			this.operation = operation;
		}
		
		@Override
		public String toString() {
			return "Transaction [accountFrom=" + accountFrom + ", accountTo=" + accountTo
					+ ", moneyAmount=" + moneyAmount + ", operation=" + operation + "]";
		}
	}
}

