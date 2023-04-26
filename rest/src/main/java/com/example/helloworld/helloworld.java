package com.example.helloworld;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloworld {
	private MessageSource messagesource;
	
	public helloworld(MessageSource messagesource)
	{
		this.messagesource=messagesource;
	}
	
	@GetMapping(path="/helloworld")
	public String hello()
	{
	return "hello world";
	}

	@GetMapping("/helloworldbean")
	public Helloworldbean hellobean()
	{
	return new Helloworldbean("hello world");
	}
	
	@GetMapping(path="/helloworld-international")
	public String hellointernational()
	{
		Locale locale=LocaleContextHolder.getLocale();
		return messagesource.getMessage("good.morning.message", null, "Default Message", locale);
	   
	}

	
}
