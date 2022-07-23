package com.example.gestionStock.Services;

import java.io.InputStream;

import org.springframework.context.annotation.ComponentScan;

import com.flickr4java.flickr.FlickrException;



public interface FlickrServiceInterface {

	
	String savePhoto(InputStream photo, String title) throws FlickrException;
	
	
	
}
