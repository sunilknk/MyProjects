package com.example.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class userdaoservice 
{
	public static ArrayList<user> users=new ArrayList<>();

static
	{
		users.add(new user(1,"adam",LocalDate.now().minusYears(30), null));
		users.add(new user(2,"eve",LocalDate.now().minusYears(40), null));
		users.add(new user(3,"jim",LocalDate.now().minusYears(25), null));
		users.add(new user(4,"ben",LocalDate.now().minusYears(20), null));
	}

	public List<user> findall()
	{
		return users;

	}

	/*
	 * public user findbyid(int id) { user user1=new user(); for (user user : users)
	 * { if(id==user.id) { user1=user; break; }
	 * 
	 * } return user1; }
	 */

	public user findbyid(int id) 
	{

		Predicate<? super user> predicate=user1->(user1.getId()==id);
		return users.stream().filter(predicate).findFirst().orElse(null);
	}

	public user adduser(user user1) {
		users.add(user1);
		return user1;
	}

	public void   deleteuser(int id) 
	{

		Predicate<? super user> predicate=user1->(user1.getId()==id);
		users.removeIf(predicate);
	}
}

