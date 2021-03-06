package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.blo.VilleBLOImpl;
import com.dto.VilleDTO;

@RestController
//@RequestMapping("/path")
class VilleController {

	public static final String ATTRIBUT_BDD_CODE_COMMUNE = "Code_commune_INSEE";
	public static final String ATTRIBUT_BDD_NOM_COMMUNE = "Nom_commune";
	public static final String ATTRIBUT_BDD_CODE_POSTAL = "Code_postal";
	public static final String ATTRIBUT_BDD_LIBELLE_ACHEMINEMENT = "Libelle_acheminement";
	public static final String ATTRIBUT_BDD_LIGNE_5 = "Ligne_5";
	public static final String ATTRIBUT_LATITUDE = "Latitude";
	public static final String ATTRIBUT_LONGITUDE = "Longitude";

	@Autowired
	VilleBLOImpl villeService;

	// Affiche toutes les villes 
	@RequestMapping(value = "/villes", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<VilleDTO> appelGetVilles() throws SQLException {
		return villeService.getVilles();
	}
	
	// Affiche 50 villes avec un offset
	@RequestMapping(value = "/50villes", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<VilleDTO> appelGet50Villes(@RequestParam int offset) throws SQLException {
		return villeService.get50Villes(offset);
	}
	
	// Affiche une ville
	@RequestMapping(value = "/ville", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public VilleDTO appelGet(@RequestParam String codeCommune) throws SQLException {
		return villeService.getInfoVille(codeCommune);
	}

	// Modifier les données d'une ville
	// TO DO : mettre les params dans un body
	// @RequestBodyParam 
	@RequestMapping(value = "/ville/modifier", method = RequestMethod.POST)
	@ResponseBody
	public void appelPut(@RequestParam Map<String, String> params) throws SQLException {
		VilleDTO ville = setParamVille(params);
		villeService.updateVille(ville);
	}
	
	
	private VilleDTO setParamVille(Map<String, String> params) {
		VilleDTO ville = new VilleDTO();
		ville.setCodeCommune(params.get(ATTRIBUT_BDD_CODE_COMMUNE));
		ville.setNomCommune(params.get(ATTRIBUT_BDD_NOM_COMMUNE));
		ville.setCodePostal(params.get(ATTRIBUT_BDD_CODE_POSTAL));
		ville.setLibelleAcheminement(params.get(ATTRIBUT_BDD_LIBELLE_ACHEMINEMENT));
		ville.setLigne5(params.get(ATTRIBUT_BDD_LIGNE_5));
		ville.setLatitude(params.get(ATTRIBUT_LATITUDE));
		ville.setLongitude(params.get(ATTRIBUT_LONGITUDE));
		return ville;
	}
	
	

}
