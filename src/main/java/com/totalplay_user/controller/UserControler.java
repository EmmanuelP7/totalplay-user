package com.totalplay_user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.totalplay_user.entity.User;
import com.totalplay_user.logic.UserLogic;
import com.totalplay_user.request.UserRequest;



@RestController
@RequestMapping("usuario/")
public class UserControler {
	@Autowired
	UserLogic service;
	
	@PostMapping()
	public ResponseEntity<?> guardar(@RequestBody UserRequest request) {
	    User user = service.guardar(request);
	    if (user != null) {
	        return new ResponseEntity<User>(user, HttpStatus.OK);
	    } else {
	        return ResponseEntity
	                .status(HttpStatus.BAD_REQUEST)
	                .body("{\"messageResponse\":\"Este usuario ya se encuentra registrado\"}");

	    }
	}

	
	@GetMapping()
	public ResponseEntity<List<User>> mostrar(){
		List<User> users = service.mostrar();
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<User> actualizar(@RequestBody UserRequest request){
		User producto = service.actualizar(request);
		return new ResponseEntity<User>(producto,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> eliminar(@PathVariable int id){
		String user = service.eliminar(id);
		String jsonResponse = String.format("{\"messageResponse\":\"%s\"}", user);
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(jsonResponse);
	}
	
	
	

}
