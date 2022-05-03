package br.com.feliciano.springangular.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.feliciano.springangular.resources.domain.Course;
import br.com.feliciano.springangular.resources.dto.CourseNewDTO;
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

	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody CourseNewDTO objDto) { // @RequestBody converts 
		// JSON to object body
		Course obj = courseService.fromDTO(objDto);
		obj = courseService.insert(obj);
		ServletUriComponentsBuilder.fromCurrentRequest();
		URI uri = UriComponentsBuilder
				.fromPath("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
