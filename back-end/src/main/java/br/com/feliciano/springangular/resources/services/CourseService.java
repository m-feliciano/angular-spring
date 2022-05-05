package br.com.feliciano.springangular.resources.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.feliciano.springangular.repositories.CourseRepository;
import br.com.feliciano.springangular.resources.domain.Category;
import br.com.feliciano.springangular.resources.domain.Course;
import br.com.feliciano.springangular.resources.dto.CourseDTO;
import br.com.feliciano.springangular.resources.dto.CourseNewDTO;
import br.com.feliciano.springangular.resources.exceptions.ObjectNotFoundException;

@Service
public class CourseService {

	private final CourseRepository courseRepository;
	private final CategoryService categoryService;

	@Autowired
	public CourseService(CourseRepository courseRepository, CategoryService categoryService) {
		this.courseRepository = courseRepository;
		this.categoryService = categoryService;
	}

	public List<Course> getCourses() {
		return courseRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Course insert(Course obj) {
		obj.setId(null); // it doesn't allow the passing of id to database
		return courseRepository.save(obj);
	}

	public Course findById(int id) {
		Optional<Course> course = courseRepository.findById(id);
		return course.orElseThrow(
				() -> new ObjectNotFoundException("Object not found! Id: " + id + ", Type: " + Course.class.getName()));
	}

	public Course fromDTO(CourseDTO objDto) {
		return new Course(objDto.getId(), objDto.getName());
	}

	public Course fromDTO(CourseNewDTO objDto) {
		String catName = objDto.getCategory().getName();
		Category cat = categoryService
				.findByNameIgnoreCase(catName);
		return new Course(objDto.getName(), cat);
	}

	public List<Course> findByCategory(Integer categoryId) {
		return courseRepository.findByCategory(categoryId);
	}

}
