package com.example.gestionStock.Dto;

import com.example.gestionStock.Entity.Roles;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RolesDto {
	
	private Integer id;

	
	private String roleName;
	

	private UserDto user;
	
	
	public static RolesDto fromEntity(Roles roles) {
		
		
		if(roles == null) {
			return null;
		}
		
		return RolesDto.builder()
				.id(roles.getId())
				.roleName(roles.getRoleName())
				.user(UserDto.fromEntity(roles.getUser()))
				.build();
				
		
	}
	
	
}
