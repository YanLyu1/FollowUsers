package com.me.exception;

public class PassageException extends Exception{
	public PassageException(String message)
	{
		super("PassageException-"+message);
	}
	
	public PassageException(String message, Throwable cause)
	{
		super("PassageException-"+message,cause);
	}
}
