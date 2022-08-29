package com.alura.aluraflix.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alura.aluraflix.dto.VideoDto;
import com.alura.aluraflix.dto.input.VideoInput;
import com.alura.aluraflix.entity.Video;
import com.alura.aluraflix.exception.EntidadeNaoEncontradaException;
import com.alura.aluraflix.repository.VideoRepository;

@Service
public class VideoService {

	@Autowired
	private VideoRepository repository;
	
	public List<VideoDto> buscarPorNome(String search) {
		List<Video> videos = repository.findByTituloContaining(search);
		return videos.stream().map(VideoDto::new).collect(Collectors.toList());
	}

	public VideoDto buscar(Long id) {
		Video video = repository.findById(id)
				.orElseThrow(() -> new EntidadeNaoEncontradaException("Não existe o vídeo de código " + id));

		return new VideoDto(video);
	}

	public List<VideoDto> listar() {
		return repository.findAll().stream().map((video) -> new VideoDto(video)).collect(Collectors.toList());
	}
	
	public VideoDto salvar(VideoInput videoInput) {
		Video video = repository.save(new Video(videoInput));
		return new VideoDto(video);
	}
	
	public VideoDto atualizar(Long id, VideoInput videoInput) {
		Video video = repository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException("Não existe o vídeo de código" + id));
		BeanUtils.copyProperties(videoInput, video);
		video = repository.save(video);
		return new VideoDto(video);
	}
	
	public void deletar(Long id) {
		Video video = repository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException("Não existe o vídeo de código" + id));
		repository.delete(video);
	}
}
