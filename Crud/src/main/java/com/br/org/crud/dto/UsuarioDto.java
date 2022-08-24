package com.br.org.crud.dto;

import java.io.Serializable;
import java.time.LocalDate;

import org.modelmapper.ModelMapper;

import com.br.org.crud.entity.Usuario;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@JsonPropertyOrder({ "id", "nome", "dataNascimento", "imgPath" })
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class UsuarioDto implements Serializable {

	private static final long serialVersionUID = -5902456351649095558L;

	@JsonProperty("id")
	private Long id;

	@JsonProperty("nome")
	private String nome;

	@JsonProperty("dataNascimento")
	private LocalDate dataNascimento;

	@JsonProperty("imgPath")
	private String imgPath;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public static UsuarioDto create(Usuario usuario) {
		return new ModelMapper().map(usuario, UsuarioDto.class);

	}

}
