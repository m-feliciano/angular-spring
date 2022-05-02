package br.com.feliciano.springangular.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.feliciano.springangular.resources.domain.Course;
import br.com.feliciano.springangular.resources.services.CourseService;

@RestController
@RequestMapping("/api/courses")
public class CourseResource {

	private final CourseService courseService;

	@Autowired
	public CourseResource(CourseService courseService) {
		this.courseService = courseService;
	}

	@GetMapping
	public ResponseEntity<List<Course>> findAll() {
		List<Course> courses = courseService.getCourses();
		return ResponseEntity.ok().body(courses);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Course> findById(@PathVariable Integer id) {
		Course course = courseService.findById(id);
		return ResponseEntity.ok().body(course);
	}
}
