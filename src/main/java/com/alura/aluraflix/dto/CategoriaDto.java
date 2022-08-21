package com.alura.aluraflix.dto;

import com.alura.aluraflix.entity.Categoria;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CategoriaDto {

	private Long id;
	private String titulo;
	private String cor;
	
	public CategoriaDto(Categoria categoria) {
		id = categoria.getId();
		titulo = categoria.getTitulo();
		cor = categoria.getCor();
	}
}
