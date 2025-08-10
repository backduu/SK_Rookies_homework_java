package mylab.bank.entity;

public class SavingsAccount extends Account {
	private double interestRate;
	
	public SavingsAccount(String accountNumber, String ownerName, double balance, double interestRate) {
		super(accountNumber, ownerName, balance);
		
		this.interestRate = interestRate;
	}
	
	// 이자율 반환
	public double getInterestRate() {
		return this.interestRate;
	}
	
	// 이자 적용
	public void applyInterest() {
		double aa = getBalance();
		double interest = getBalance() * (interestRate/100);
		deposit(interest);
	}
	
	// 계좌 정보 출력
    @Override
    public String toString() {
        return String.format("계좌번호: AC%s, 소유자: %s, 잔액: %.1f, 이자율: %.1f%%",
                getAccountNumber(), getOwnerName(), getBalance(), interestRate);
    }
}
