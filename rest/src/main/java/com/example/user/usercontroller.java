package com.example.user;

import java.net.URI;
import java.util.List;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.persistence.Entity;
import jakarta.validation.Valid;

@RestController
public class usercontroller {

	userdaoservice dao;

	public usercontroller(userdaoservice dao)
	{
		this.dao=dao;
	}

	@GetMapping("/users")
	public List<user> getusers()
	{
		return dao.findall();

	}
//http://localhost:8081/users
	@GetMapping("/users/{id}")
	public user getuserbyid(@PathVariable("id") int id) 
	{
		user user3=dao.findbyid(id);
		if(user3==null)
			throw new usernotfoundexception("id "+id);
		   EntityModel<user> entityModel=EntityModel.of(user3);
		 //WebMvcLinkBuilder  link=linkTo(methodOn(this.getClass()).retrieveAllUsers());//for heteos
		 //entityModel.add(link.withRel("all-users"));
		   return user3;
	}

	
	@PostMapping("/users")
	public ResponseEntity<user> adduser(@Valid @RequestBody user user1) 
	{
		user saveduser=dao.adduser(user1);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saveduser.getId()).toUri();
		return ResponseEntity.created(location).build();

	}

	@DeleteMapping("/users/{id}")
	public void  deleteuserbyid(@PathVariable("id") int id) 
	{
		dao.deleteuser(id);

	}

}
