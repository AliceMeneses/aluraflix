package com.alura.aluraflix.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alura.aluraflix.dto.CategoriaDto;
import com.alura.aluraflix.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;
	
	public List<CategoriaDto> listar(){
		return repository.findAll().stream().map(CategoriaDto::new).collect(Collectors.toList());
	}
	
}
