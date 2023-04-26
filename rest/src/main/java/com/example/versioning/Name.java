package com.example.versioning;

public class Name 
{
String firstname;
String lastname;


public Name(String firstname, String lastname) {
	super();
	this.firstname = firstname;
	this.lastname = lastname;
}
public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public String getLastname() {
	return lastname;
}
public void setLastname(String lastname) {
	this.lastname = lastname;
}
@Override
public String toString() {
	return "Name [firstname=" + firstname + ", lastname=" + lastname + "]";
}


}
