package com.alura.aluraflix.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.alura.aluraflix.entity.Categoria;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class VideosPorCategoriaDto {

	private Long id;
	private String titulo;
	private String cor;
	private List<VideoDto> videos;
	
	public VideosPorCategoriaDto(Categoria categoria) {
		id = categoria.getId();
		titulo = categoria.getTitulo();
		cor = categoria.getCor();
		videos = categoria.getVideos().stream().map(VideoDto::new).collect(Collectors.toList()); 
	}
}
