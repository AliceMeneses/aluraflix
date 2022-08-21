package com.alura.aluraflix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alura.aluraflix.entity.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	
}
