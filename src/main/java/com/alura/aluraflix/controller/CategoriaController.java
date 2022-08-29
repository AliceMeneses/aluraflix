package com.alura.aluraflix.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.alura.aluraflix.dto.CategoriaDto;
import com.alura.aluraflix.dto.VideosPorCategoriaDto;
import com.alura.aluraflix.dto.input.CategoriaInput;
import com.alura.aluraflix.exception.EntidadeNaoEncontradaException;
import com.alura.aluraflix.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService service;
	
	@GetMapping
	public List<CategoriaDto> listar() {
		return service.listar();
	}

	@GetMapping("{id}")
	public ResponseEntity<CategoriaDto> buscar(@PathVariable Long id) {
		
		try {
			CategoriaDto categoriaDto = service.buscar(id);
			return ResponseEntity.ok(categoriaDto);
		} catch (EntidadeNaoEncontradaException ex) {
			return ResponseEntity.notFound().build();
		}

	}
	
	@GetMapping("/{id}/videos")
	public ResponseEntity<VideosPorCategoriaDto> buscarVideosPorCategoria(@PathVariable Long id){
		try {
			VideosPorCategoriaDto videoPorCategoriaDto = service.buscarVideosPorCategoria(id);
			return ResponseEntity.ok(videoPorCategoriaDto);
		} catch (EntidadeNaoEncontradaException ex) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CategoriaDto salvar(@RequestBody @Valid CategoriaInput categoriaInput) {
		return service.salvar(categoriaInput);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CategoriaDto> atualizar(@PathVariable Long id, @RequestBody @Valid CategoriaInput categoriaInput) {
		try {
			CategoriaDto categoria = service.atualizar(id, categoriaInput);
			return ResponseEntity.ok(categoria);
		} catch (EntidadeNaoEncontradaException ex) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<CategoriaDto> deletar(@PathVariable Long id){
		try {
			service.deletar(id);
			return ResponseEntity.noContent().build();
		} catch (EntidadeNaoEncontradaException ex) {
			return ResponseEntity.notFound().build();
		}
	}
	
}
