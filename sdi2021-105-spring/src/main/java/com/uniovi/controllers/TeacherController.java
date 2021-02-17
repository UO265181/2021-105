package com.uniovi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.uniovi.entities.Teacher;
import com.uniovi.services.TeachersService;

@Controller
public class TeacherController {

	@Autowired // Inyectar el servicio
	private TeachersService teachersService;

	@RequestMapping("/teacher/list")
	public String getList(Model model) {
		model.addAttribute("tList", teachersService.getTeachers());
		return "teacher/list";
	}

	@RequestMapping("/teacher/details/{id}")
	public String getDetail(@PathVariable Long id) {
		return "Details: " + teachersService.getTeacher(id).toString();
	}

	@RequestMapping(value = "/teacher/add​​​​")
	public String getTeacher(Model model, @PathVariable Long id) {
		model.addAttribute("teacher", teachersService.getTeacher(id));
		return "teacher/edit";
	}

	@RequestMapping(value = "/teacher/add", method = RequestMethod.POST)
	public String setTeacher(@RequestParam String DNI) {
		teachersService.addTeacher(new Teacher(null, DNI, null, null, null));
		return "Added " + DNI;
	}

	@RequestMapping("/teacher/delete/{id}")
	public String deleteMark(@PathVariable Long id) {
		teachersService.deleteTeacher(id);
		return "Deleted";
	}

	@RequestMapping(value = "/teacher/edit/{​​​​id}​​​​")
	public String getEdit(Model model, @PathVariable Long id) {
		model.addAttribute("teacher", teachersService.getTeacher(id));
		return "teacher/edit";
	}
	
	@RequestMapping(value = "/teacher/edit/{​​​​id}​​​​", method = RequestMethod.POST)
	public String setEdit(Model model, @PathVariable String category) {
		((Teacher) model.getAttribute("teacher")).setCategory(category);
		return "Teacher edited: "+((Teacher) model.getAttribute("teacher")).toString();
	}
	
	
	
}
