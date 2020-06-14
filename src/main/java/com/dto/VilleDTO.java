package com.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class VilleDTO {

	@NonNull
	private String codeCommune;
	
	private String nomCommune;
	
	private String codePostal;
	
	private String libelleAcheminement;
	
	private String ligne5;
	
	private String latitude;
	
	private String longitude;

}
