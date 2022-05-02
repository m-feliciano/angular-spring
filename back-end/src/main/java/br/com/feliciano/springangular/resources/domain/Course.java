package br.com.feliciano.springangular.resources.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "tb_course")
public class Course implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter(value = AccessLevel.PRIVATE)
	private int id;
	private String name;

	public Course(String name) {
		this.name = name;
	}

	@JsonIgnore // deny serialization
    @ManyToMany
    @JoinTable(
    		name = "COURSE_CATEGORY",
    		joinColumns = @JoinColumn(name = "course_id"),
    		inverseJoinColumns = @JoinColumn(name = "category_id"))
    private final List<Category> categories = new ArrayList<>();

	@JsonIgnore
	public List<Category> getCategories(){
		return categories;
	}

	public void addCategory(Category cat) {
		this.categories.add(cat);
		cat.getCourses().add(this);
	}

}
