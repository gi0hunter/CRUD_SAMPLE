package com.br.org.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.org.crud.dto.UsuarioDto;
import com.br.org.crud.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@PostMapping(value = "/create")
	public ResponseEntity<UsuarioDto> create(@RequestBody UsuarioDto usuarioDto) {

		return ResponseEntity.ok().body(usuarioService.create(usuarioDto));
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<UsuarioDto> findById(@PathVariable Long id) {

		return ResponseEntity.ok().body(usuarioService.findById(id));
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Page<UsuarioDto>> findAll(Pageable page) {

		return ResponseEntity.ok().body(usuarioService.findAll(page));
	}

	@PutMapping(value = "/update")
	public ResponseEntity<UsuarioDto> update(@RequestBody UsuarioDto usuarioDto) {

		return ResponseEntity.ok().body(usuarioService.update(usuarioDto));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		usuarioService.delete(id);
		return ResponseEntity.ok().build();
	}

}
