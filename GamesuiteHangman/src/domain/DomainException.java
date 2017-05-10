package domain;

@SuppressWarnings("serial")
public class DomainException extends RuntimeException 
{
	DomainException(String message)
	{
		super(message);
	}
}
