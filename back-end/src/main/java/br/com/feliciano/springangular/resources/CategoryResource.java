package br.com.feliciano.springangular.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.feliciano.springangular.resources.domain.Category;
import br.com.feliciano.springangular.resources.domain.Course;
import br.com.feliciano.springangular.resources.dto.CategoryDTO;
import br.com.feliciano.springangular.resources.dto.CourseDTO;
import br.com.feliciano.springangular.resources.services.CategoryService;
import br.com.feliciano.springangular.resources.services.CourseService;

@RestController
@RequestMapping("/api/categories")
public class CategoryResource {

	private CategoryService categoryService;
	private CourseService courseService;

	@Autowired
	public CategoryResource(CategoryService categoryService, CourseService courseService) {
		this.categoryService = categoryService;
		this.courseService = courseService;
	}

	@GetMapping
	public ResponseEntity<List<CategoryDTO>> findAll() {
		List<Category> obj = categoryService.findAll();
		List<CategoryDTO> listDto = obj.stream().map(CategoryDTO::new).toList();
		return ResponseEntity.ok().body(listDto);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Integer id) {
		Category cat = categoryService.findById(id);
		return ResponseEntity.ok().body(cat);

	}
	
	@GetMapping(value = "/{categoryId}/courses")
	public ResponseEntity<List<CourseDTO>> findCourses(@PathVariable Integer categoryId) {
		List<Course> obj = courseService.findByCategory(categoryId);
		List<CourseDTO> listDto = obj.stream().map(CourseDTO::new).toList();
		return ResponseEntity.ok().body(listDto);
	}
	

	@GetMapping(value = "/page")
	public ResponseEntity<Page<CategoryDTO>> findPage(
			@RequestParam(value = "name", defaultValue = "") String name,
			@RequestParam(value = "categories", defaultValue = "") String categories,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		Page<Category> list = categoryService.findPage(page, linesPerPage, orderBy, direction);
		Page<CategoryDTO> listDto = list.map(CategoryDTO::new);
		return ResponseEntity.ok().body(listDto);
	}

}
