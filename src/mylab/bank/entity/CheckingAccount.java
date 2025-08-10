package mylab.bank.entity;

import mylab.bank.exception.InsufficientBalanceException;
import mylab.bank.exception.WithdrawalLimitExceededException;

public class CheckingAccount extends Account {
	private double withdrawalLimit;
	
	public CheckingAccount(String accountNumber, String ownerName, double balance, double withdrawalLimit) {
		super(accountNumber, ownerName, balance);
		
		this.withdrawalLimit = withdrawalLimit;
	}
	
	// 출금 한도 반환
	public double getWithdrawalLimit() {
		return this.withdrawalLimit;
	}
	
	// 출금
	@Override
	public void withdraw(double money) throws WithdrawalLimitExceededException {
		if(money > withdrawalLimit) {
			throw new WithdrawalLimitExceededException(money);
		}
		super.withdraw(money);
	}
	
	// 계좌 정보 출력
	@Override
	public String toString() {
		return String.format("계좌번호: AC%s, 소유자: %s, 잔액: %.1f, 출금한도: %.1f",
                getAccountNumber(), getOwnerName(), getBalance(), withdrawalLimit);
	}
}
