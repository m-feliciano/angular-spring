package br.com.feliciano.springangular.resources.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.feliciano.springangular.repositories.CourseRepository;
import br.com.feliciano.springangular.resources.domain.Course;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;

	public List<Course> getCourses() {
		return courseRepository.findAll();
	}

	public Course findById(int id) {
		Optional<Course> course = courseRepository.findById(id);
		return course.isPresent() ? course.get() : null;
	}

}
