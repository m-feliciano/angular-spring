package br.com.feliciano.springangular.resources.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.feliciano.springangular.repositories.CourseRepository;
import br.com.feliciano.springangular.resources.domain.Course;
import br.com.feliciano.springangular.resources.dto.CourseDTO;
import br.com.feliciano.springangular.resources.exceptions.ObjectNotFoundException;

@Service
public class CourseService {

	private final CourseRepository courseRepository;

	@Autowired
	public CourseService(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}

	public List<Course> getCourses() {
		return courseRepository.findAll();
	}

	public Course findById(int id) {
		Optional<Course> course = courseRepository.findById(id);
		return course.orElseThrow(
				() -> new ObjectNotFoundException("Object not found! Id: " + id + ", Type: " + Course.class.getName()));
	}

	public Course fromDTO(CourseDTO objDto) {
		return new Course(objDto.getId(), objDto.getName());
	}

	public List<Course> findByCategory(Integer categoryId) {
		return courseRepository.findByCategory(categoryId);
	}

}
