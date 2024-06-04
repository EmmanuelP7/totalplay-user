package com.totalplay_user.controller;

import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.multipart.MultipartFile;

import com.totalplay_user.Res;
import com.totalplay_user.service.ImageService;




@RestController
public class ImageController {
	
	@Autowired
	private ImageService service;
	
	@PostMapping("/subirImagen")
	public Object uploadImage(@RequestParam ("image") MultipartFile file) throws IOException, GeneralSecurityException {


		if (file.isEmpty()) {
			return "Archivo vacio";
		}
		File tempFile = File.createTempFile("temp", null); 
		file.transferTo(tempFile);
		
		Res res = service.uploadImageToDrive(tempFile);
		System.out.println(res);
		
		return res;
	}
	
	

}
