package com.example.versioning;

public class person {

	private String string;

	public person(String string) 
	{
		super();
		this.string=string;
	}
	

	public void setString(String string) {
		this.string = string;
	}


	public String getString() {
		return string;
	}

	@Override
	public String toString() {
		return "person [string=" + string + "]";
	}

}
