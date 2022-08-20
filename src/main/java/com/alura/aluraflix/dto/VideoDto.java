package com.alura.aluraflix.dto;

import com.alura.aluraflix.entity.Video;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class VideoDto {
	
	private Long id;
	private String titulo;
	private String descricao;
	private String url;
	
	public VideoDto(Video video) {
		id = video.getId();
		titulo = video.getTitulo();
		descricao = video.getDescricao();
		url = video.getUrl();		
	}
}
