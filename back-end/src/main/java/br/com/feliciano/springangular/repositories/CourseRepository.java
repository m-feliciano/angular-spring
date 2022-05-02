package br.com.feliciano.springangular.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.feliciano.springangular.resources.domain.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

}
