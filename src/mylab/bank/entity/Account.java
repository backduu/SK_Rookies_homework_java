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
	
	// ���¹�ȣ ã��
	public String getAccountNumber() {
		return this.accountNumber;
	}
	
	// ���� �̸� ã��
	public String getOwnerName() {
		return this.ownerName;
	}
	
	// ���� �ܾ� ã��
	public double getBalance() {
		return this.balance;
	}
	
	// �Ա�
	public void deposit(double money){
		if(money > 0) {
			this.balance += money;
			System.out.printf("%.1f���� �ԱݵǾ����ϴ�. ���� �ܾ�: %.1f\n", money, getBalance());
		}
	}
	
	// ���
	public void withdraw(double money) throws WithdrawalLimitExceededException {
		if(money > 0 && this.balance >= money) {
			this.balance -= money;
			System.out.printf("%.1f���� ��ݵǾ����ϴ�. ���� �ܾ�: %.1f\n", money, getBalance());
		} else {
			throw new WithdrawalLimitExceededException(money);
		}
	}
	
	public String toString() {
		return String.format("���¹�ȣ: %s, ������: %s, �ܾ�: %.2f",
                getAccountNumber(), getOwnerName(), getBalance());
	}
}
