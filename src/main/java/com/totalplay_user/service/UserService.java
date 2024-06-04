package com.totalplay_user.service;

import java.util.List;

import com.totalplay_user.entity.User;
import com.totalplay_user.request.UserRequest;

public interface UserService {
	
	User guardar(UserRequest request);
	User actualizar(UserRequest request);
	User buscar(int userId);
	String eliminar(int userId);
	
	List mostrar();

	

}
