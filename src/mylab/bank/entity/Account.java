package mylab.bank.entity;

import mylab.bank.exception.InsufficientBalanceException;
import mylab.bank.exception.WithdrawalLimitExceededException;

public class Account {
	private String accountNumber;
	private String ownerName;
	private double balance;
	
	public Account(String accountNumber, String ownerName, double balance) {
		this.accountNumber = accountNumber;
		this.ownerName = ownerName;
		this.balance = balance;
	}
	
	// 계좌번호 찾기
	public String getAccountNumber() {
		return this.accountNumber;
	}
	
	// 주인 이름 찾기
	public String getOwnerName() {
		return this.ownerName;
	}
	
	// 현재 잔액 찾기
	public double getBalance() {
		return this.balance;
	}
	
	// 입금
	public void deposit(double money){
		if(money > 0) {
			this.balance += money;
			System.out.printf("%.1f원이 입금되었습니다. 현재 잔액: %.1f\n", money, getBalance());
		}
	}
	
	// 출금
	public void withdraw(double money) throws WithdrawalLimitExceededException {
		if(money > 0 && this.balance >= money) {
			this.balance -= money;
			System.out.printf("%.1f원이 출금되었습니다. 현재 잔액: %.1f\n", money, getBalance());
		} else {
			throw new WithdrawalLimitExceededException(money);
		}
	}
	
	public String toString() {
		return String.format("계좌번호: %s, 소유자: %s, 잔액: %.2f",
                getAccountNumber(), getOwnerName(), getBalance());
	}
}
