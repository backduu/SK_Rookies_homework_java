package mylab.bank.exception;

public class AccountNotFoundException extends Exception {
	public AccountNotFoundException(String accountNumber) {
		super("���� �߻�: ���¹�ȣ AC" + accountNumber + "�� �ش��ϴ� ���¸� ã�� �� �����ϴ�.");
	}
}
