package com.example.user;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class errordetails 
{
 LocalDateTime timestamp;
 String message;
 String details;
 
 
public errordetails(LocalDateTime timestamp, String message, String details) 
{
	super();
	this.timestamp = timestamp;
	this.message = message;
	this.details = details;
}
public LocalDateTime getTimestamp() 
{
	return timestamp;
}
public String getMessage() 
{
	return message;
}
public String getDetails() 
{
	return details;
}
 
 

}
