package com.alura.aluraflix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alura.aluraflix.dto.VideoDto;
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
	public List<VideoDto> listar(){
		return service.listar();
	}
}
