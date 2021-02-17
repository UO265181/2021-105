package com.uniovi.services;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniovi.entities.Mark;
import com.uniovi.entities.Teacher;
import com.uniovi.repositories.MarksRepository;
import com.uniovi.repositories.TeacherRepository;;

@Service
public class TeachersService {

	@Autowired
	private TeacherRepository teachersRepository;

	public List<Teacher> getTeachers() {
		List<Teacher> teachers = new ArrayList<Teacher>();
		teachersRepository.findAll().forEach(teachers::add);
		return teachers;
	}

	public Teacher getTeacher(Long id) {
		return teachersRepository.findById(id).get();
	}

	public void addTeacher(Teacher teacher) {
		teachersRepository.save(teacher);
	}

	public void deleteTeacher(Long id) {
		teachersRepository.deleteById(id);
	}

}
