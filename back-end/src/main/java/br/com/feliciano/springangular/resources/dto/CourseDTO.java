package br.com.feliciano.springangular.resources.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.com.feliciano.springangular.resources.domain.Course;

public class CourseDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	@NotEmpty(message = "Mandatory completion")
	@Length(min = 3, max = 20, message = "The course '${validatedValue}' must be between {min} and {max} characters")
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
