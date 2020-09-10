package com.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.pojo.Employee;

public class EmployeeValidator1 implements Validator {

	@Override
	public boolean supports(Class<?> emp_class) {
		// TODO Auto-generated method stub
		return emp_class.equals(Employee.class);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		// TODO Auto-generated method stub

		Employee employee=(Employee) obj;
		if (employee.getName().length()<=5)
		{
			errors.rejectValue("name","EmployeeName.required",
					"Please Enter The Name");
		}
		if(employee.getEmpId()<50)
		{
			errors.rejectValue("empId","empId.required","Please Enter Correct ID");
		}
		if(employee.getSalary()<50)
		{
			errors.rejectValue("salary","salary.required","Please Enter Salary");
		}
		
	}

}
