package com.alura.aluraflix.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.alura.aluraflix.dto.input.VideoInput;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "videos")
@NoArgsConstructor
@Getter @Setter
public class Video {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String descricao;
	private String url;
	
	@ManyToOne
	private Categoria categoria;
	
	public Video(VideoInput videoInput) {
		titulo = videoInput.getTitulo();
		descricao = videoInput.getDescricao();
		url = videoInput.getUrl();
	}
}
