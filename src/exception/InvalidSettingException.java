package exception;

public class InvalidSettingException extends Exception{
	public InvalidSettingException(String fileName, String errorMessage) {
		super("[ " + fileName + " ] =>" + errorMessage);
	}
}
