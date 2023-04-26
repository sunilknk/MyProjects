package com.example.versioning;

public class person1 
{
Name name;

public person1(Name name)
{
	this.name=name;
}

public Name getName() {
	return name;
}

public void setName(Name name) {
	this.name = name;
}

@Override
public String toString() {
	return "person1 [name=" + name + "]";
}


}
