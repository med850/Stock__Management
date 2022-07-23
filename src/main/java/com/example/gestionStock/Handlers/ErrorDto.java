package com.example.gestionStock.Handlers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.ComponentScan;

import com.example.gestionStock.Exception.ErrorCodes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorDto {

	
	private Integer httpCode;
	
	private ErrorCodes code;
	
	private String message;
	
	private List<String> errors = new ArrayList<>();
	
	
}
