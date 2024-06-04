package com.totalplay_user.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.totalplay_user.entity.User;
import com.totalplay_user.repository.UserRepository;
import com.totalplay_user.request.UserRequest;
import com.totalplay_user.service.UserService;

@Service
public class UserLogic implements UserService{

	@Autowired
	UserRepository repo;
	
	@Override
	public User guardar(UserRequest request) {
		User user = null;
		System.out.println("inicio");
		System.out.println(request);
		int usuarios = repo.countUsers(request.getNombre().toUpperCase(), request.getApPaterno().toUpperCase(), request.getApMaterno().toUpperCase());
		
		System.out.println(usuarios);
		System.out.println("fin");
		if (usuarios == 0) {
			System.out.println("SIN USUARIOS REGISTRADOS");
			user = new User();
			user.setUserId(request.getUserId());
			user.setNombre(request.getNombre().toUpperCase());
			user.setApPaterno(request.getApPaterno().toUpperCase());
			user.setApMaterno(request.getApMaterno().toUpperCase());
			user.setTelefono(request.getTelefono());
			user.setFechaIngreso(request.getFechaIngreso());
			user.setSueldo(request.getSueldo());
			user.setActividades(request.getActividades());
			user.setFoto(request.getFoto());
			
			user.setCorreo(request.getNombre().toLowerCase().replace(" ", "-")
					+"."
					+request.getApPaterno().toLowerCase()
					+"@totalplay.com.mx");
			
			
			repo.save(user);
			
		}else{
			System.out.println("Usuarios encontrados:");
		   
		}
		
		
		return user;
	}

	@Override
	public User actualizar(UserRequest request) {
		
		User user =  repo.findById(request.getUserId()).get(); 
	
		user.setUserId(request.getUserId());
		user.setNombre(request.getNombre().toUpperCase());
		user.setApPaterno(request.getApPaterno().toUpperCase());
		user.setApMaterno(request.getApMaterno().toUpperCase());
		user.setTelefono(request.getTelefono());
		user.setFechaIngreso(request.getFechaIngreso());
		user.setSueldo(request.getSueldo());
		user.setActividades(request.getActividades());
		user.setFoto(request.getFoto());
		
		user.setCorreo(request.getNombre().toLowerCase().replace(" ", "-")
				+"."
				+request.getApPaterno().toLowerCase()
				+"@totalplay.com.mx");
		
		repo.save(user); 
		return user;
	}

	@Override
	public User buscar(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String eliminar(int userId) {
		repo.deleteById(userId);
		return "Elemento eliminado";
	}

	@Override
	public List mostrar() {
		
		return repo.findAll();
	}

	

}
