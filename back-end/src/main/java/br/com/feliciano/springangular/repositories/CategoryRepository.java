package br.com.feliciano.springangular.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.feliciano.springangular.resources.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
