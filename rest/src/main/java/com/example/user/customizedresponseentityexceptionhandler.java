package com.example.user;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class customizedresponseentityexceptionhandler extends ResponseEntityExceptionHandler
{
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception 
	{	
	errordetails errordetails=new errordetails(LocalDateTime.now(),ex.getMessage(),request.getDescription(false));
	return new ResponseEntity<>(errordetails,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(usernotfoundexception.class)
	public final ResponseEntity<Object> handleusernotfoundexception(Exception ex, WebRequest request) throws Exception 
	{	
	errordetails errordetails=new errordetails(LocalDateTime.now(),ex.getMessage(),request.getDescription(false));
	return new ResponseEntity<>(errordetails,HttpStatus.NOT_FOUND);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) 
	{
		errordetails errordetails=new errordetails(LocalDateTime.now(),ex.getFieldError().getDefaultMessage(),request.getDescription(false));
		
		return new ResponseEntity(errordetails,HttpStatus.BAD_REQUEST);
	}

}
