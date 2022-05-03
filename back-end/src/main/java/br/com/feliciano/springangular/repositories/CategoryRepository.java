package br.com.feliciano.springangular.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.feliciano.springangular.resources.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

		@Transactional(readOnly = true)
		public List<Category> findAllByOrderByName();
		
		@Transactional(readOnly = true)
		public Optional<Category> findByNameIgnoreCase(String name);
}
