package com.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.naming.Binding;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dao.EmployeeDAO;
import com.pojo.Employee;

@Controller
public class AddEmployeeController {

	
	@RequestMapping("/showEmployeeForm.htm")
	public ModelAndView showEmployeeForm(ModelMap map) throws Exception{
		
		Employee employee= new Employee();
		map.addAttribute(employee);
		return new ModelAndView("employeeForm");
	}
	
	@RequestMapping("/addEmployee.htm")
	public ModelAndView addEmployee(@ModelAttribute("employee") Employee Employee) throws Exception {
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("display");
		List<Employee> employees= new ArrayList<>();
		employees.add(Employee);
		modelAndView.addObject("employee_list",employees);
		modelAndView.addObject("emp_name",Employee.getName());
		
		return modelAndView;
		
	}
	
	@ModelAttribute("technologyList")
	public List<String> addTech()
	{
		List<String> technologies = new ArrayList<String>();
		technologies.add("JAVA");
		technologies.add(".NET");
		technologies.add("KUBERNETES");
		technologies.add("CLOUD");
		technologies.add("Databases");
		
		return technologies;
	}
	
	@Autowired
	Validator validator;
	
	@InitBinder
	private void initBinder(WebDataBinder webDataBinder)
	{
		webDataBinder.setValidator(validator);
	}

	@Autowired
	EmployeeDAO dao;
	
	@RequestMapping("/addEmployee_valid.htm")
	public ModelAndView addEmployee_valid
	(@Valid @ModelAttribute("employee") Employee Employee,BindingResult bindingResult) 
	throws Exception {
		
		if(bindingResult.hasErrors())
		{
			return new ModelAndView("employeeForm");
		}
			
			int added = dao.addEmployee(Employee);
				if(added<0)
					return new ModelAndView("employeeForm");
		
		List<Employee> employees= dao.findAllEMployees();

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("display");
//		List<Employee> employees= new ArrayList<>();
//		employees.add(Employee);
		modelAndView.addObject("employee_list",employees);
		modelAndView.addObject("emp_name",Employee.getName());
		return modelAndView;
		
	}
	
	@RequestMapping("/showEmployees.htm")
	public ModelAndView displayEmployees()
		{
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("display");
			List<Employee> employees= dao.findAllEMployees();
			modelAndView.addObject("employee_list",employees);
			return modelAndView;
			
		}
	
	@RequestMapping("/showDeleteForm.htm")
	public ModelAndView showDeleteForm(ModelMap map) throws Exception{
		
		Employee employee= new Employee();
		map.addAttribute(employee);
		return new ModelAndView("delete");
	}
	
	@RequestMapping("/deleteEmployee.htm")
	public ModelAndView DeleteEmployee(@RequestParam int empid)	{
		
		dao.deleteEmployee(empid);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("display");
		List<Employee> employees= dao.findAllEMployees();
		modelAndView.addObject("employee_list",employees);
		return modelAndView;
		
	}
	
	
}
