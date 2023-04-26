package com.example.user;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity(name="user_details")
public class user
{
@NotNull()
@Id
@GeneratedValue
int id;
@Size(min=2,message = "name should have atleat 2 characters")
@JsonProperty("user_name")
String name;
@Past(message="birthdate should be in past")
@JsonProperty("birth_date")
LocalDate birthdate;
@OneToMany(mappedBy = "user1")
@JsonIgnore
List<post> posts;



public user(@NotNull int id, @Size(min = 2, message = "name should have atleat 2 characters") String name,
		@Past(message = "birthdate should be in past") LocalDate birthdate, List<post> posts) {
	super();
	this.id = id;
	this.name = name;
	this.birthdate = birthdate;
	this.posts = posts;
}

public user() {
	
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public LocalDate getBirthdate() {
	return birthdate;
}
public void setBirthdate(LocalDate birthdate) {
	this.birthdate = birthdate;
}

public List<post> getPosts() {
	return posts;
}

public void setPosts(List<post> posts) {
	this.posts = posts;
}

@Override
public String toString() {
	return "user [id=" + id + ", name=" + name + ", birthdate=" + birthdate + "]";
}


}
