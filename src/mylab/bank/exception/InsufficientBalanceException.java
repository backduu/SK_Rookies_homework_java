package mylab.bank.exception;

public class InsufficientBalanceException extends Exception {
	public InsufficientBalanceException(double amount) {
        super("���� �߻�: ��� �ѵ��� �ʰ��߽��ϴ�. ��û �ݾ�: " + amount);
    }
}

