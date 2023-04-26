package com.example.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class versioningpersoncontroller 
{
@GetMapping("/v1/person")
public person getfirstversionofperson()
{
	return new person("Bob Charlie");
	
}

@GetMapping("/v2/person")
public person1 getsecondversionofperson()
{
	return new person1(new Name("bob","charlie"));
	
}

@GetMapping(path="/person",params="version=1")
public person getfirstversionofpersonreqparameter()
{
	return new person("Bob charlie");
	
}


@GetMapping(path="/person",params="version=2")
public person1 getsecondversionofpersonreqparameter()
{
	return new person1(new Name("bob","charlie"));
	
}

@GetMapping(path="/person/header",headers="X-API-VERSION=1")
public person getfirstversionofpersonreqheader()
{
	return new person("Bob charlie");
	
}
@GetMapping(path="/person1/header",headers="X-API-VERSION=2")
public person1 getsecondversionofpersonreqheader()
{
	return new person1(new Name("bob","charlie"));
	
}
}