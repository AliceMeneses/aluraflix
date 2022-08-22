package com.alura.aluraflix.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.alura.aluraflix.dto.input.CategoriaInput;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "categorias")
@Getter @Setter
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String cor;
	
	public Categoria(CategoriaInput categoriaInput) {
		// TODO Auto-generated constructor stub
	}
}
