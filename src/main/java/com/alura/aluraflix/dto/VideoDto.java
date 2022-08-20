package com.alura.aluraflix.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class VideoDto {
	
	private Long id;
	private String titulo;
	private String descricao;
	private String url;
	
}
