package com.example.filtering;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class filteringcontroller 
{
	@GetMapping("filtering")
	public  MappingJacksonValue filtering()
	{
		somebean somebeann=new somebean("value1","value2","value3");
		MappingJacksonValue mapping=new MappingJacksonValue(somebeann);
		SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("field1","field3");
		FilterProvider filters=new SimpleFilterProvider().addFilter("somebeanfilter",filter);
		mapping.setFilters(filters);
		return  mapping;
	}

	
@GetMapping("filtering-list")
public  MappingJacksonValue filteringlist()
{
	  List<somebean> list=Arrays.asList(new somebean("value1","value2","value3"),new  somebean("value4","value5","value6"));
		MappingJacksonValue mapping=new MappingJacksonValue(list);
		SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("field2","field3");
		FilterProvider filters=new SimpleFilterProvider().addFilter("somebeanfilter",filter);
		mapping.setFilters(filters);


	return mapping;
}
	
}
