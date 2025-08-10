package mylab.bank.entity;

public class SavingsAccount extends Account {
	private double interestRate;
	
	public SavingsAccount(String accountNumber, String ownerName, double balance, double interestRate) {
		super(accountNumber, ownerName, balance);
		
		this.interestRate = interestRate;
	}
	
	// ������ ��ȯ
	public double getInterestRate() {
		return this.interestRate;
	}
	
	// ���� ����
	public void applyInterest() {
		double aa = getBalance();
		double interest = getBalance() * (interestRate/100);
		deposit(interest);
	}
	
	// ���� ���� ���
    @Override
    public String toString() {
        return String.format("���¹�ȣ: AC%s, ������: %s, �ܾ�: %.1f, ������: %.1f%%",
                getAccountNumber(), getOwnerName(), getBalance(), interestRate);
    }
}
