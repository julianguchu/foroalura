package com.foxcreations.springtest.app.model;

import java.time.LocalDate;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;









@Table(name="Topicos")
@Entity
public class Topico {
	

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	

	
	 @Column(name= "titulo", unique = true, length = 30)
	 @NotBlank(message = "no puede ser vacio  el titulo")
		@NotNull(message = "no puede ser null el titulo")
	private String titulo;
	
	
	@Column(name="mensaje", unique = true, length = 60)
	 @NotBlank(message = "no puede ser vacio  el mensaje")
	@NotNull(message = "no puede ser null el mensaje")
	private String mensaje;
	
	@Column

	@NotNull(message = "no puede ser null la fecha")
	private  LocalDate fechaCreacion;
	
	 @NotBlank(message = "no puede ser vacio  el estatus")
		@NotNull(message = "no puede ser null el estatus")
	private String estatus ;
	
	@Column
	 @NotBlank(message = "no puede ser vacio  el autor")
	@NotNull(message = "no puede ser null el autor")
	private String autor;
	
	@Column
	@NotBlank(message = "no puede ser vacio  el curso")
	@NotNull(message = "no puede ser null el curso")
	private String curso;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	
	
}
