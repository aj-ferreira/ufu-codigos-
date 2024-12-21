package account;

public class WithdrawalWarningException extends Exception 
{
	private static final long serialVersionUID = 1L;

	public WithdrawalWarningException(String message) 
    {
        super(message);
    }
}
