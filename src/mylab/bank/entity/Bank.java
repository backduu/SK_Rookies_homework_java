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
	
	// ���� ����
	public String createSavingsAccount(String owner, double initialBalance, double interestRate) {
		String accountNumber = String.valueOf(nextAccountNumber++);
		SavingsAccount account = new SavingsAccount(accountNumber, owner, initialBalance, interestRate);

		accounts.add(account);
		
        return accountNumber;
	}
	
	// ���� ����
	public String createCheckingAccount(String owner, double initialBalance, double withdrawalLimit) {
		String accountNumber = String.valueOf(nextAccountNumber++);
		CheckingAccount account = new CheckingAccount(accountNumber, owner, initialBalance, withdrawalLimit);
		accounts.add(account);
		
		return accountNumber;
	}
	
	// ���� ��ȸ
	public Account findAccount(String accountNumber) throws AccountNotFoundException {
		accountNumber = accountNumber.replace("AC", "");
		for(Account account : accounts) {
	        if (account.getAccountNumber().equals(accountNumber)) {
	        	return account;
	        }
		}

		throw new AccountNotFoundException(accountNumber);
	}
	
	// �Ա�
	public void deposit(String accountNumber, double money) throws AccountNotFoundException {
         Account account = findAccount(accountNumber);
         account.deposit(money);
         System.out.printf("%.1f���� �ԱݵǾ����ϴ�. ���� �ܾ�: %.1f\n", money, account.getBalance());
	}
	
	// ���
	public void withdraw(String accountNumber, double money) throws AccountNotFoundException, WithdrawalLimitExceededException  {
        Account account = findAccount(accountNumber);
        account.withdraw(money);
        System.out.printf("%.1f���� ��ݵǾ����ϴ�. ���� �ܾ�: %.1f\n", money, account.getBalance());
	}
	
	// ������ü
	public void transfer(String fromAccountNumber, String toAccountNumber, double money) throws AccountNotFoundException, InsufficientBalanceException {
        Account from = findAccount(fromAccountNumber);
        Account to = findAccount(toAccountNumber);
        
    	from.withdraw(money);
    	to.deposit(money);
        System.out.printf("%.1f���� AC%s���� AC%s�� �۱ݵǾ����ϴ�.\n", money, fromAccountNumber, toAccountNumber);        	
	}
	
	// ���� ��ȸ
	public void printAllAccounts() {
        for (Account account : accounts) {
            System.out.println(account);
        }
        System.out.println("===================");
	}
}
