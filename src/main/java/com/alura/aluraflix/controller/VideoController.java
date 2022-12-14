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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.alura.aluraflix.dto.VideoDto;
import com.alura.aluraflix.dto.input.VideoInput;
import com.alura.aluraflix.exception.EntidadeNaoEncontradaException;
import com.alura.aluraflix.service.VideoService;

@RestController
@RequestMapping("/videos")
public class VideoController {
	
	@Autowired
	private VideoService service;

	@GetMapping("/{id}")
	public ResponseEntity<VideoDto> buscar(@PathVariable Long id){
		
		try {
			VideoDto videoDto = service.buscar(id);
			return ResponseEntity.ok(videoDto);
		} catch(EntidadeNaoEncontradaException ex) {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@GetMapping
	public List<VideoDto> listar(@RequestParam(required = false) String search){
		
		if(search != null) {
			return service.buscarPorNome(search);
		}
		
		return service.listar();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public VideoDto salvar(@RequestBody @Valid VideoInput videoInput) {
		return service.salvar(videoInput);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<VideoDto> atualizar(@PathVariable Long id, @RequestBody @Valid VideoInput videoInput) {
		try {
			VideoDto videoDto =  service.atualizar(id, videoInput);
			return ResponseEntity.ok(videoDto);
		} catch(EntidadeNaoEncontradaException ex) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<VideoDto> deletar(@PathVariable Long id) {
		try {
			service.deletar(id);
			return ResponseEntity.noContent().build();
		} catch (EntidadeNaoEncontradaException ex) {
			return ResponseEntity.notFound().build();
		}
	}
	
}
