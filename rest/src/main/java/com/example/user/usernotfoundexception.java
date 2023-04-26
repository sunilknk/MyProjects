package com.example.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class usernotfoundexception extends RuntimeException 
{
	public usernotfoundexception(String message)
	{
		super(message);
	}
}
