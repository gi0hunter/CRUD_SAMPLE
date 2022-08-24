package com.br.org.crud.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;

import com.br.org.crud.dto.UsuarioDto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "USUARIO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Usuario implements Serializable {

	private static final long serialVersionUID = -6444643022279594431L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "dataNascimento")
	private LocalDate dataNascimento;

	@Column(name = "imgPath")
	private String imgPath;
	
	public static Usuario create(UsuarioDto usuario) {
		return new ModelMapper().map(usuario, Usuario.class);

	} 

}
