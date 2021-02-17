package com.uniovi.services;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.uniovi.entities.Teacher;;

@Service
public class TeachersService {

	private List<Teacher> teachers = new LinkedList<Teacher>();

	@PostConstruct
	public void init() {
		teachers.add(new Teacher(1L, "4440104Z", "Juan", "Pelaez", "DLP"));
		teachers.add(new Teacher(2L, "1430144A", "Maria", "Lopez", "IPS"));
	}

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public Teacher getTeacher(Long id) {
		return teachers.stream().filter(teacher -> teacher.getId().equals(id)).findFirst().get();
	}

	public void addTeacher(Teacher teacher) {
		// Si en Id es null le asignamos el ultimo + 1 de la lista
		if (teacher.getId() == null) {
			teacher.setId(teachers.get(teachers.size() - 1).getId() + 1);
		}

		teachers.add(teacher);
	}

	public void deleteTeacher(Long id) {
		teachers.removeIf(teacher -> teacher.getId().equals(id));
	}

}
