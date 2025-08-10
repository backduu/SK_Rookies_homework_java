package mylab.bank.entity;

import mylab.bank.exception.InsufficientBalanceException;
import mylab.bank.exception.WithdrawalLimitExceededException;

public class CheckingAccount extends Account {
	private double withdrawalLimit;
	
	public CheckingAccount(String accountNumber, String ownerName, double balance, double withdrawalLimit) {
		super(accountNumber, ownerName, balance);
		
		this.withdrawalLimit = withdrawalLimit;
	}
	
	// ��� �ѵ� ��ȯ
	public double getWithdrawalLimit() {
		return this.withdrawalLimit;
	}
	
	// ���
	@Override
	public void withdraw(double money) throws WithdrawalLimitExceededException {
		if(money > withdrawalLimit) {
			throw new WithdrawalLimitExceededException(money);
		}
		super.withdraw(money);
	}
	
	// ���� ���� ���
	@Override
	public String toString() {
		return String.format("���¹�ȣ: AC%s, ������: %s, �ܾ�: %.1f, ����ѵ�: %.1f",
                getAccountNumber(), getOwnerName(), getBalance(), withdrawalLimit);
	}
}
