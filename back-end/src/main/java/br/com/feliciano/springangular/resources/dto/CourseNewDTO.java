package br.com.feliciano.springangular.resources.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.com.feliciano.springangular.resources.domain.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseNewDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message = "Mandatory completion")
	@Length(min = 5, max = 100, message = "The client '${validatedValue}' must be between {min} and {max} characters")
	private String name;
	@NotEmpty(message = "Mandatory completion")
	private Category category;

}