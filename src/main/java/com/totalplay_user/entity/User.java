package com.totalplay_user.entity;

import java.io.Serializable;
import java.util.Date;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "USERS")
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "USER_ID", columnDefinition = "NUMBER")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	@NotBlank
	@Pattern(regexp = "^[A-Z]+(\\s[A-Z]+)?$")
	@Size(max = 35)
	@Column(name = "NOMBRE", columnDefinition = "NVARCHAR2(35)", nullable = false )
	private String nombre;
	
	@NotBlank
	@Pattern(regexp = "^[A-Z]+$")
	@Size(max = 35)
	@Column(name = "APELLIDO_PATERNO", columnDefinition = "NVARCHAR2(35)", nullable = false)
	private String apPaterno;
	
	@NotBlank
	@Pattern(regexp = "^[A-Z]+$")
	@Size(max = 35)
	@Column(name = "APELLIDO_MATERNO", columnDefinition = "NVARCHAR2(35)", nullable = false)
	private String apMaterno;
	
	@NotBlank
	@Pattern(regexp = "^[0-9]+$")
	@Size(max = 15)
	@Column(name = "TELEFONO", columnDefinition = "NVARCHAR2(15)", nullable = false)
	private String telefono;
	
	@NotBlank
	@Email
	@Column(name = "CORREO", columnDefinition = "NVARCHAR2(100)", nullable = false)
	private String correo;
	
	@FutureOrPresent
	@Column(name = "FECHA_INGRESO", columnDefinition = "DATE", nullable = false)
	private Date fechaIngreso;
	
	@NotNull
	@DecimalMin("0")
	@DecimalMax("300000.00")
	@Column(name = "SUELDO", columnDefinition = "NUMBER(8,2)", nullable = false)
	private double sueldo;
	
	@NotBlank
	@Column(name = "ACTIVIDADES", columnDefinition = "NVARCHAR2(200)", nullable = false)
	private String actividades;
	
	@Column(name = "FOTO", columnDefinition = "NVARCHAR2(500)")
	private String foto;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApPaterno() {
		return apPaterno;
	}

	public void setApPaterno(String apPaterno) {
		this.apPaterno = apPaterno;
	}

	public String getApMaterno() {
		return apMaterno;
	}

	public void setApMaterno(String apMaterno) {
		this.apMaterno = apMaterno;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	public String getActividades() {
		return actividades;
	}

	public void setActividades(String actividades) {
		this.actividades = actividades;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
}
