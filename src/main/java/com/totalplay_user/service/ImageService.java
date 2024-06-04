package com.totalplay_user.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.GeneralSecurityException;
import java.util.Collections;

import org.springframework.beans.propertyeditors.FileEditor;
import org.springframework.stereotype.Service;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.FileContent;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.totalplay_user.Res;


@Service
public class ImageService {
	
	private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
	private static final String SERVICE_ACOUNT_KEY_PATH = getPathToGoodleCredentials();
	
	
	private static String getPathToGoodleCredentials() {
		// TODO Auto-generated method stub
		String currentDirectory = System.getProperty("user.dir");
		Path filePath = Paths.get(currentDirectory, "cred.json");
		return filePath.toString();
	}
	
	public Res uploadImageToDrive(File file) throws GeneralSecurityException, IOException {
		Res res = new Res();
		try {
			
			String folderId = "13vTFbEj8tyGZebfPrOztnujRfgdb7o_x";
			Drive drive = createDriveService();
			
			com.google.api.services.drive.model.File fileMetaData = new com.google.api.services.drive.model.File();
			fileMetaData.setName(file.getName());
			fileMetaData.setParents(Collections.singletonList(folderId));
			
			FileContent mediaContent = new FileContent("image/jpg", file);
			
			com.google.api.services.drive.model.File uploadedFile = drive.files().create(fileMetaData, mediaContent)
					.setFields("id").execute();
			
			String imageUrl = "https://drive.google.com/uc?export=view&id="+uploadedFile.getId();
			
			System.out.println("URL DE LA IMAGEN: " + imageUrl);
			
			file.delete();
			res.setStatus(200);
			res.setMessage("Imagen subida correctamente a Google Drive");
			res.setUrl(imageUrl);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			res.setStatus(500);
			res.setMessage(e.getMessage());
		}
		return res;
	}

	private Drive createDriveService() throws GeneralSecurityException, IOException{
		GoogleCredential credential = GoogleCredential.fromStream(new FileInputStream(SERVICE_ACOUNT_KEY_PATH))
				.createScoped(Collections.singleton(DriveScopes.DRIVE));
		return  new Drive.Builder(
				GoogleNetHttpTransport.newTrustedTransport(),
				JSON_FACTORY, 
				credential).build();
		
	}

}
