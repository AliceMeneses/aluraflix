package com.alura.aluraflix.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alura.aluraflix.entity.Video;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long>{
	
	List<Video> findByTituloContaining(String titulo);
	
}
