package com.example.gestionStock.Services.Implements;

import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.example.gestionStock.Services.FlickrServiceInterface;
import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.RequestContext;
import com.flickr4java.flickr.auth.Auth;
import com.flickr4java.flickr.auth.Permission;
import com.flickr4java.flickr.uploader.UploadMetaData;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FlickrServiceImp implements FlickrServiceInterface{

	
	private Flickr flickr;
	
	
	@Autowired 
	public FlickrServiceImp(Flickr flickr) {
	
		this.flickr = flickr;
	}


	@Override
	public String savePhoto(InputStream photo, String title) throws FlickrException {
	UploadMetaData uploadMetaData = new UploadMetaData();
	
	uploadMetaData.setTitle(title);
	
	
	String photoId = flickr.getUploader().upload(photo, uploadMetaData);
	

	return  flickr.getPhotosInterface().getPhoto(photoId).getMedium640Url();
	}
	
	
	
	


	
	

}
