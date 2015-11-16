package com.uptodate.exceptions;

public class SynonymNotFoundException extends Exception {
	
	public SynonymNotFoundException()
	{
	}

	public SynonymNotFoundException(String message)
	{
		super(message);
	}

	public SynonymNotFoundException(Throwable cause)
	{
		super(cause);
	}

	public SynonymNotFoundException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public SynonymNotFoundException(String message, Throwable cause, 
                                       boolean enableSuppression, boolean writableStackTrace)
	{
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
