package com.alura.aluraflix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alura.aluraflix.dto.CategoriaDto;
import com.alura.aluraflix.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService service;
	
	@GetMapping
	public List<CategoriaDto> listar(){
		return service.listar();
	}
	
}
