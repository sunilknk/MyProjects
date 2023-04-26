package com.example.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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

import com.example.jpa.postrepository;
import com.example.jpa.userrepository;

import jakarta.persistence.Entity;
import jakarta.validation.Valid;

@RestController
public class userJPAcontroller {

	
	userrepository userrepo;
	postrepository postrepo;

	public userJPAcontroller(userrepository repo,postrepository postrepo)
	{
		this.userrepo=repo;
		this.postrepo=postrepo;
	}

	@GetMapping("/jpa/users")
	public List<user> getusers()
	{
		return userrepo.findAll();

	}
	
	
	@GetMapping("/jpa/users/{id}")
	public Optional<user> getuserbyid(@PathVariable("id") int id) 
	{
		Optional<user> user3=userrepo.findById(id);
		if(user3==null)
			throw new usernotfoundexception("id "+id);
		/*
		 * EntityModel<user> entityModel=EntityModel.of(user3); WebMvcLinkBuilder
		 * link=linkTo(methodOn(this.getClass()).retrieveAllUsers());//for heteos
		 * entityModel.add(link.withRel("all-users"));
		 */
		
		return user3;
	}

	
	@PostMapping("/jpa/users")
	public ResponseEntity<user> adduser(@Valid @RequestBody user user1) 
	{
		user saveduser=userrepo.save(user1);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saveduser.getId()).toUri();
		return ResponseEntity.created(location).build();

	}

	@DeleteMapping("/jpa/users/{id}")
	public void  deleteuserbyid(@PathVariable("id") int id) 
	{
		userrepo.deleteById(id);

	}
	
	@GetMapping("/jpa/users/{id}/posts")
	public List<post>  fetchpostsforuser(@PathVariable("id") int id) 
	{
        Optional<user> user1=userrepo.findById(id);
        if(user1.isEmpty())
		   throw new usernotfoundexception("id"+id);
        return user1.get().getPosts();
	}

	@PostMapping("/jpa/users/{id}/posts")
	public ResponseEntity<Object>  createpostsforuser(@PathVariable("id") int id,@Valid @RequestBody post post1) 
	{
        Optional<user> user1=userrepo.findById(id);
        if(user1.isEmpty())
		   throw new usernotfoundexception("id"+id);
        post1.setUser1(user1.get());
        //postrepo.save(post1);
		post savedpost=postrepo.save(post1);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedpost.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

}
