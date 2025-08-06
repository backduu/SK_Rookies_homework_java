package exception;

public class InvalidGradeException extends Exception{
	public InvalidGradeException(String fileName, String errorMessage) {
		super("[ " + fileName + " ] =>" + errorMessage);
	}
}
