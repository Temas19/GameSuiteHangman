package domain;

import java.io.FileNotFoundException;

@SuppressWarnings("serial")
public class DomainException extends RuntimeException 
{
	public DomainException(String message)
	{
		super(message);
	}
	
	public DomainException(String message, FileNotFoundException e)
	{
		super(message, e);
	}
}
