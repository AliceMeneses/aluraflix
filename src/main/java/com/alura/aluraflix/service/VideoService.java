package com.alura.aluraflix.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alura.aluraflix.dto.VideoDto;
import com.alura.aluraflix.entity.Video;
import com.alura.aluraflix.exception.EntidadeNaoEncontradaException;
import com.alura.aluraflix.repository.VideoRepository;

@Service
public class VideoService {

	@Autowired
	private VideoRepository repository;
	
	public VideoDto buscar(Long id) {
		Video video = repository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException(
				"Não existe vídeo de código " + id));
		
		VideoDto videoDto = new VideoDto();
		BeanUtils.copyProperties(video, videoDto);
		
		return videoDto;
	}
}
