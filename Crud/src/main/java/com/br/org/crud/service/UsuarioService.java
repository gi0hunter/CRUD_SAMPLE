package com.br.org.crud.service;

import java.lang.module.ResolutionException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.br.org.crud.dto.UsuarioDto;
import com.br.org.crud.entity.Usuario;
import com.br.org.crud.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public UsuarioDto create(UsuarioDto usuarioDto) {
		UsuarioDto userDto = UsuarioDto.create(usuarioRepository.save(Usuario.create(usuarioDto)));
		return userDto;

	}

	public Page<UsuarioDto> findAll(Pageable pageable) {
		var page = usuarioRepository.findAll(pageable);
		return page.map(this::convertToUsuarioDto);

	}

	private UsuarioDto convertToUsuarioDto(Usuario usuario) {
		return UsuarioDto.create(usuario);
	}

	public UsuarioDto findById(Long id) {
		var entity = usuarioRepository.findById(id)
				.orElseThrow(() -> new ResolutionException("Usuario não encontrado"));
		return UsuarioDto.create(entity);

	}

	public UsuarioDto update(UsuarioDto usuarioDto) {
		final Optional<Usuario> optionalUsuario = usuarioRepository.findById(usuarioDto.getId());
		if (!optionalUsuario.isPresent()) {
			new ResolutionException("Usuario não encontrado");
		}

		return UsuarioDto.create(usuarioRepository.save(Usuario.create(usuarioDto)));
	}

	public void delete(Long id) {
		var entity = usuarioRepository.findById(id)
				.orElseThrow(() -> new ResolutionException("Usuario não encontrado"));
		
		usuarioRepository.delete(entity);
	}

}
