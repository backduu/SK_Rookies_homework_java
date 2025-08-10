package mylab.bank.control;

import mylab.bank.entity.Account;
import mylab.bank.entity.Bank;
import mylab.bank.entity.CheckingAccount;
import mylab.bank.entity.SavingsAccount;
import mylab.bank.exception.AccountNotFoundException;
import mylab.bank.exception.InsufficientBalanceException;
import mylab.bank.exception.WithdrawalLimitExceededException;

public class BankDemo {
	public static void main(String[] args) {
		Bank bank = new Bank();

        try {
            // 계좌 생성
        	System.out.println("=== 계좌 생성 ===");
        	String accountHong = bank.createSavingsAccount("홍길동", 10000, 3);
            String accountKim = bank.createCheckingAccount("김철수", 20000, 5000);
            String accountLee = bank.createSavingsAccount("이영희", 30000, 2);
            
            SavingsAccount sa = (SavingsAccount) bank.findAccount(accountHong);
            System.out.println("Saving(저축) 계좌가 생성되었습니다: " + sa.toString());
            CheckingAccount ac = (CheckingAccount) bank.findAccount(accountKim);
            System.out.println("체킹 계좌가 생성되었습니다: " + ac.toString());
            SavingsAccount sa2 = (SavingsAccount) bank.findAccount(accountLee);
            System.out.println("저축 계좌가 생성되었습니다: " + sa2.toString());
            System.out.println("===================\n");
            
            System.out.println("=== 입금/출금 테스트 ===");
            bank.deposit(sa.getAccountNumber(), 5000);
            bank.withdraw(ac.getAccountNumber(), 3000);
            System.out.println("===================\n");
            System.out.println("=== 이자 적용 테스트 ===");
            sa.applyInterest();
            System.out.printf("%.1f원이 입금되었습니다. 현재 잔액: %.1f원\n", sa.getInterestRate(), sa.getBalance());
            System.out.printf("이자 %.1f원이 적용되었습니다. 현재 잔액: %.1f원\n", sa.getInterestRate(), sa.getBalance());
            System.out.println("");            
            System.out.println("=== 계좌 이체 테스트 ===");
            bank.transfer(sa.getAccountNumber(), sa2.getAccountNumber(), 5000);
            System.out.println("");
            System.out.println("=== 모든 계좌 목록 ===");
            bank.printAllAccounts();
            bank.findAccount("AC9999");
            bank.withdraw(ac.getAccountNumber(), 8000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
		
	
	}
}
