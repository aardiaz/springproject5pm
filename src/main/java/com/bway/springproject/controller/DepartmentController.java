package com.bway.springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bway.springproject.model.Department;
import com.bway.springproject.service.DepartmentService;

@Controller
public class DepartmentController {
	
	 @Autowired
	 private DepartmentService deptService;

	   @GetMapping("/department")
	   public String getDept() {
		   
		   return "AddDepartment";
	   }
	   
	   @PostMapping("/department")
	   public String postDept(@ModelAttribute Department  dept) {
		   
		   deptService.addDept(dept);
		   
		   return "AddDepartment";
	   }
	   
	   @GetMapping("/departmentList")
	   public String  getAll(Model model) {
		   
		   model.addAttribute("dlist",deptService.getDepartments());
		   
		   return "ListDepartment";
	   }
	   
	   @GetMapping("/edit")
	   public String editDept(@RequestParam int id, Model model) {
		   
		    model.addAttribute("dptmodel", deptService.getDeptById(id));
		   
		   return "EditDepartment";
	   }
	   
	   @PostMapping("/update")
	   public String updateDpt(@ModelAttribute  Department  dept) {
		   
		   deptService.addDept(dept);
		   
		   return "redirect:/departmentList";
	   }
	   
}
