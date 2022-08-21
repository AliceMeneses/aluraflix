package com.alura.aluraflix.dto.input;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class VideoInput {

	@NotBlank
	private String titulo;
	
	@NotBlank
	private String descricao;
	
	@NotBlank
	private String url;
}
