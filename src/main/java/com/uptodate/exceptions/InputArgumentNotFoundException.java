package com.uptodate.exceptions;

public class InputArgumentNotFoundException extends Exception {
	public InputArgumentNotFoundException()
	{
		super("No input arguments were passed.");
	}


	public InputArgumentNotFoundException(String message)
	{
		super(message);
	}

	public InputArgumentNotFoundException(Throwable cause)
	{
		super(cause);
	}

	public InputArgumentNotFoundException(String message, Throwable cause)
	{
		super(message, cause);
	}


}
