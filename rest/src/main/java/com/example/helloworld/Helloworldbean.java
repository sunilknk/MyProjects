package com.example.helloworld;

public class Helloworldbean {
	
	private String string;

	public Helloworldbean(String string)
	{
		this.string=string;
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	@Override
	public String toString() {
		return "Helloworldbean [string=" + string + "]";
	}

	
}
