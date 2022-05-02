package br.com.feliciano.springangular.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.feliciano.springangular.resources.domain.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

	@Transactional(readOnly = true)
	@Query("SELECT obj FROM Course obj WHERE obj.category.id = :categoryId ORDER BY obj.name")
	public List<Course> findByCategory(@Param("categoryId") Integer categoryId);
	
}
