package br.com.feliciano.springangular.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Service;

import br.com.feliciano.springangular.repositories.CategoryRepository;
import br.com.feliciano.springangular.repositories.CourseRepository;
import br.com.feliciano.springangular.resources.domain.Category;
import br.com.feliciano.springangular.resources.domain.Course;

@Service
public class DBService {

	/*
	 * Simple service to mock data
	 */
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private CourseRepository courseRepository;

	public void instantiateTestDatabase() throws ParseException {

		Category cat1 = new Category(null,"Front-End");
		Category cat2 = new Category(null,"Back-End");
		Category cat3 = new Category(null,"DevOps");
		Category cat4 = new Category(null,"Data Science");

		Course c1 = new Course(null,"Java", cat2);
		Course c2 = new Course(null,"Javascript", cat1);
		Course c3 = new Course(null,"AWS", cat3);
		Course c4 = new Course(null,"REGEXP", cat1);
		Course c5 = new Course(null,"PHP" ,cat1);
		Course c6 = new Course(null,"Oracle SQL", cat4);
		Course c7 = new Course(null,"NoSQL", cat4);
		Course c8 = new Course(null,"Angular", cat1);

//		c1.setCategory(cat2);
//		c2.setCategory(cat1);
//		c3.setCategory(cat3);
//		c4.setCategory(cat1);
//		c5.setCategory(cat1);
//		c6.setCategory(cat4);
//		c7.setCategory(cat4);
//		c8.setCategory(cat1);
		
		cat1.getCourses().addAll(Arrays.asList(c2, c4, c5, c8));
		cat2.getCourses().add(c1);
		cat3.getCourses().add(c3);
		cat4.getCourses().addAll(Arrays.asList(c6, c7));

		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4));
		courseRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6, c7, c8));
	}

}
