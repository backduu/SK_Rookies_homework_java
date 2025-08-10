package mylab.bank.exception;

public class InsufficientBalanceException extends Exception {
	public InsufficientBalanceException(double amount) {
        super("예외 발생: 출금 한도를 초과했습니다. 요청 금액: " + amount);
    }
}

