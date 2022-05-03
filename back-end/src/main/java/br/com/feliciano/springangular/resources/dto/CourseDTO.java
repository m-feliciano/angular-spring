package br.com.feliciano.springangular.resources.dto;

import java.io.Serializable;

import br.com.feliciano.springangular.resources.domain.Course;

public class CourseDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;

	public CourseDTO(Course obj) {
		id = obj.getId();
		name = obj.getName();
	}

	public String getName() {
		return name;
	}

	public Integer getId() {
		return id;
	}

}
