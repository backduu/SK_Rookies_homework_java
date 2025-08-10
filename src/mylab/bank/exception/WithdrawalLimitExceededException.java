package mylab.bank.exception;

public class WithdrawalLimitExceededException extends InsufficientBalanceException {
    public WithdrawalLimitExceededException(double limit) {
        super(limit);
    }
}

