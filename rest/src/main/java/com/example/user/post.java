package com.example.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jayway.jsonpath.internal.function.numeric.Min;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Size;

@Entity
public class post {
	@Id
	@GeneratedValue
	int id;
	String description;
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	user user1;
	
	public post() {
		super();
	}
	
	
	
	public post(int id, String description, user user1) {
		super();
		this.id = id;
		this.description = description;
		this.user1 = user1;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public user getUser1() {
		return user1;
	}



	public void setUser1(user user1) {
		this.user1 = user1;
	}



	@Override
	public String toString() {
		return "post [id=" + id + ", description=" + description + "]";
	}
	
	

}
