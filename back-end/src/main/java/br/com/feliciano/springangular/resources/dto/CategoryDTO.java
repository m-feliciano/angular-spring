package br.com.feliciano.springangular.resources.dto;

import java.io.Serializable;

import br.com.feliciano.springangular.resources.domain.Category;

public class CategoryDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	
	public CategoryDTO(Category obj) {
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
