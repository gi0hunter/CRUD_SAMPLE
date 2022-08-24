package com.br.org.crud.exception;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class ExceptionResponse implements Serializable {

	private static final long serialVersionUID = 8905183704613287037L;

	private LocalDateTime timestap;
	private String message;
	private String description;

	public ExceptionResponse(LocalDateTime timestap, String message, String description) {
		super();
		this.timestap = timestap;
		this.message = message;
		this.description = description;
	}

}
