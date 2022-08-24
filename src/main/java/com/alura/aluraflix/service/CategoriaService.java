package com.alura.aluraflix.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alura.aluraflix.dto.CategoriaDto;
import com.alura.aluraflix.dto.input.CategoriaInput;
import com.alura.aluraflix.entity.Categoria;
import com.alura.aluraflix.exception.EntidadeNaoEncontradaException;
import com.alura.aluraflix.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;
	
	public List<CategoriaDto> listar(){
		return repository.findAll().stream().map(CategoriaDto::new).collect(Collectors.toList());
	}
	
	public CategoriaDto buscar(Long id) {
		Categoria categoria = repository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException("Não existe o vídeo de código " + id));
		return new CategoriaDto(categoria);
	}
	
	public CategoriaDto salvar(CategoriaInput categoriaInput) {
		Categoria categoria = repository.save(new Categoria(categoriaInput));
		return new CategoriaDto(categoria);
	}
}
