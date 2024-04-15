package com.cyr.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cyr.springboot.dao.EmployeeRepository;
import com.cyr.springboot.model.Employee;
import com.cyr.springboot.service.EmployeeService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	@Autowired
	private EmployeeRepository repo;
	
	@RequestMapping("/")
	public String display() {
		return "index";
	}

	@GetMapping("/employeeForm")
	public String indexPage1(Model model) {
		model.addAttribute("employee", new Employee());
		return "EmployeeForm";
	}

	//@PostMapping("/saveEmployee")
	@RequestMapping(value="/saveEmployee", method=RequestMethod.POST)
	public @ResponseBody ModelAndView indexPage(@ModelAttribute("employee") Employee emp,BindingResult result, Model model) {
		
		empService.saveEmployee(emp);
		System.out.println("request forword to jsp...");
		return new ModelAndView("redirect:/employeesList");
	}

	@GetMapping("/employeesList1")
	public String getEmployee(Model model) {
		model.addAttribute("employees", empService.getAllEmployees());
		System.out.println("...employees list...");
		return "home";
	}
	
	@GetMapping("/employeesList")
    public String getAllEmployees(
                        @RequestParam(defaultValue = "1") Integer pageNo,
                        @RequestParam(defaultValue = "3") Integer pageSize,
                        @RequestParam(defaultValue = "id") String sortBy, 
                        Model model)
    {
		 Page < Employee > page = empService.findPaginated(pageNo, pageSize);
		    List < Employee > listEmployees = page.getContent();

		    model.addAttribute("currentPage", pageNo);
		    model.addAttribute("totalPages", page.getTotalPages());
		    model.addAttribute("totalItems", page.getTotalElements());
		    model.addAttribute("employees", listEmployees);
		 
       // model.addAttribute("employees", empService.getAllEmployeesPage(pageNo, pageSize, sortBy));
        return "home";
    }
 
	
	
	@GetMapping("/getEmployee/{id}")
	public String findById(@PathVariable("id") int id, Model model) {
		model.addAttribute("employee", empService.findById(id));
		model.addAttribute("Mode", "EDIT");
		System.out.println("findbyId..."+empService.findById(id));
		return "EmployeeForm";
		
	}
	
	@RequestMapping(value="/getEmployee/saveEmployeee", method=RequestMethod.PUT)
	public  ModelAndView updateEmployee(@ModelAttribute("employee") Employee emp) {
		
		empService.saveEmployee(emp);
		System.out.println("employee is updated");
		return new ModelAndView("redirect:/employeesList");
	}
	@GetMapping("/deleteEmployee/{id}")
	public ModelAndView deleteEmployee(@PathVariable("id") int id) {
		empService.deleteEmployee(id);
	    System.out.println("...id .. :"+id);
		return new ModelAndView("redirect:/employeesList");
	}
	
	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable(value = "pageNo") int pageNo, Model model) {
	    int pageSize = 3;

	    Page < Employee > page = empService.findPaginated(pageNo, pageSize);
	    List < Employee > listEmployees = page.getContent();
        int firstPage=1;
	    model.addAttribute("currentPage", firstPage);
	    model.addAttribute("totalPages", page.getTotalPages());
	    model.addAttribute("totalItems", page.getTotalElements());
	    model.addAttribute("employees", listEmployees);
	    return "home";
	}

}
