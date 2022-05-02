package br.com.feliciano.springangular.services;

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

		Category cat1 = new Category("Front-End");
		Category cat2 = new Category("Back-End");
		Category cat3 = new Category("DevOps");
		Category cat4 = new Category("Data Science");

		Course c1 = new Course("Java");
		Course c2 = new Course("Javascript");
		Course c3 = new Course("AWS");
		Course c4 = new Course("REGEXP");
		Course c5 = new Course("PHP");
		Course c6 = new Course("Oracle SQL");
		Course c7 = new Course("NoSQL");
		Course c8 = new Course("Angular");

		c1.addCategory(cat2);
		c2.addCategory(cat1);
		c3.addCategory(cat3);
		c4.addCategory(cat1);
		c5.addCategory(cat2);
		c6.addCategory(cat4);
		c7.addCategory(cat4);
		c8.addCategory(cat1);

		categoryRepository.save(cat2);
		courseRepository.save(c1);

		categoryRepository.save(cat1);
		courseRepository.save(c2);

		categoryRepository.save(cat3);
		courseRepository.save(c3);

		categoryRepository.save(cat1);
		courseRepository.save(c4);

		categoryRepository.save(cat2);
		courseRepository.save(c5);

		categoryRepository.save(cat4);
		courseRepository.save(c6);

		categoryRepository.save(cat4);
		courseRepository.save(c7);

		categoryRepository.save(cat1);
		courseRepository.save(c8);

	}

}
