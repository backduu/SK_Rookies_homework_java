package mylab.bank.entity;

import java.util.*;

import mylab.bank.exception.AccountNotFoundException;
import mylab.bank.exception.InsufficientBalanceException;
import mylab.bank.exception.WithdrawalLimitExceededException;


public class Bank {
	private ArrayList<Account> accounts;
	private int nextAccountNumber;
	
	public Bank() {
		this.accounts = new ArrayList<>();
		this.nextAccountNumber = 1000;
	}
	
	// 계좌 생성
	public String createSavingsAccount(String owner, double initialBalance, double interestRate) {
		String accountNumber = String.valueOf(nextAccountNumber++);
		SavingsAccount account = new SavingsAccount(accountNumber, owner, initialBalance, interestRate);

		accounts.add(account);
		
        return accountNumber;
	}
	
	// 계좌 생성
	public String createCheckingAccount(String owner, double initialBalance, double withdrawalLimit) {
		String accountNumber = String.valueOf(nextAccountNumber++);
		CheckingAccount account = new CheckingAccount(accountNumber, owner, initialBalance, withdrawalLimit);
		accounts.add(account);
		
		return accountNumber;
	}
	
	// 계좌 조회
	public Account findAccount(String accountNumber) throws AccountNotFoundException {
		accountNumber = accountNumber.replace("AC", "");
		for(Account account : accounts) {
	        if (account.getAccountNumber().equals(accountNumber)) {
	        	return account;
	        }
		}

		throw new AccountNotFoundException(accountNumber);
	}
	
	// 입금
	public void deposit(String accountNumber, double money) throws AccountNotFoundException {
         Account account = findAccount(accountNumber);
         account.deposit(money);
         System.out.printf("%.1f원이 입금되었습니다. 현재 잔액: %.1f\n", money, account.getBalance());
	}
	
	// 출금
	public void withdraw(String accountNumber, double money) throws AccountNotFoundException, WithdrawalLimitExceededException  {
        Account account = findAccount(accountNumber);
        account.withdraw(money);
        System.out.printf("%.1f원이 출금되었습니다. 현재 잔액: %.1f\n", money, account.getBalance());
	}
	
	// 계좌이체
	public void transfer(String fromAccountNumber, String toAccountNumber, double money) throws AccountNotFoundException, InsufficientBalanceException {
        Account from = findAccount(fromAccountNumber);
        Account to = findAccount(toAccountNumber);
        
    	from.withdraw(money);
    	to.deposit(money);
        System.out.printf("%.1f원이 AC%s에서 AC%s로 송금되었습니다.\n", money, fromAccountNumber, toAccountNumber);        	
	}
	
	// 계좌 조회
	public void printAllAccounts() {
        for (Account account : accounts) {
            System.out.println(account);
        }
        System.out.println("===================");
	}
}
