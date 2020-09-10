package com.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pojo.Employee;

@Controller
public class SearchEmployeeController {

	@RequestMapping(value="searchEmployees.htm",method=RequestMethod.GET)
	public ModelAndView searchEmployeeByName(@RequestParam String technology)
	{
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee(444,"CDK","CORE JAVA",40000));
		
		return new ModelAndView("display","employee_list",employees);
		
	}
}
