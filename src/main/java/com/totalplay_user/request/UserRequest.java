package com.totalplay_user.request;

import java.util.Date;

public class UserRequest {
	
	private int userId;
	private String nombre;
	private String apPaterno;
	private String apMaterno;
	private String telefono;
	private String correo;
	private Date fechaIngreso;
	private double sueldo;
	private String actividades;
	private String foto;
	
	public UserRequest() {}

	public UserRequest(int userId, String nombre, String apPaterno, String apMaterno, String telefono, String correo,
			Date fechaIngreso, double sueldo, String actividades, String foto) {
		super();
		this.userId = userId;
		this.nombre = nombre;
		this.apPaterno = apPaterno;
		this.apMaterno = apMaterno;
		this.telefono = telefono;
		this.correo = correo;
		this.fechaIngreso = fechaIngreso;
		this.sueldo = sueldo;
		this.actividades = actividades;
		this.foto = foto;
	}

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

	public void setFechaIngreso(java.sql.Date fechaIngreso) {
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

	@Override
	public String toString() {
		return "UserRequest [userId=" + userId + ", nombre=" + nombre + ", apPaterno=" + apPaterno + ", apMaterno="
				+ apMaterno + ", telefono=" + telefono + ", correo=" + correo + ", fechaIngreso=" + fechaIngreso
				+ ", sueldo=" + sueldo + ", actividades=" + actividades + ", foto=" + foto + "]";
	}

	
	
	

}
