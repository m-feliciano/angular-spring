package br.com.feliciano.springangular.resources.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.feliciano.springangular.repositories.CategoryRepository;
import br.com.feliciano.springangular.resources.domain.Category;
import br.com.feliciano.springangular.resources.dto.CategoryDTO;
import br.com.feliciano.springangular.resources.exceptions.DataIntegrityException;
import br.com.feliciano.springangular.resources.exceptions.ObjectNotFoundException;

@Service
public class CategoryService {

	private final CategoryRepository categoryRepository;

	@Autowired
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	public Category findById(Integer id) {
		Optional<Category> obj = categoryRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Object not found! Id: " + id + ", Type: " + Category.class.getName()));
	}

	@Transactional(readOnly = true)
	public Category insert(Category obj) {
		obj.setId(null); // it doesn't allow the passing of id to database
		return categoryRepository.save(obj);
	}

	public Category update(Category obj) {
		Category newObj = findById(obj.getId());
		updateData(newObj, obj);
		return categoryRepository.save(newObj);
	}

	private void updateData(Category newObj, Category obj) {
		newObj.setName(obj.getName());
	}

	public void delete(Integer id) {
		findById(id);
		try {
			categoryRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Cannot delete a categoria that has courses.");
		}
	}

	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	public Page<Category> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return categoryRepository.findAll(pageRequest);

	}

	public Category fromDTO(CategoryDTO objDto) {
		return new Category(objDto.getId(), objDto.getName());
	}

}