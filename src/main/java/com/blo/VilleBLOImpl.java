package com.blo;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.VilleDAO;
import com.dto.VilleDTO;

@Service
public class VilleBLOImpl implements VilleBLO{
	
	@Autowired
	private VilleDAO villeDAO;
	
	public VilleDTO getInfoVille(String codeCommune) throws SQLException {
		VilleDTO ville;
		
		ville = villeDAO.getVille(codeCommune);
		return ville;
	}
	
	public List<VilleDTO> getVilles() throws SQLException{
		List<VilleDTO> villes;
		
		villes = villeDAO.getVilles();
		return villes;
	}
	
	public List<VilleDTO> get50Villes(int offset) throws SQLException{
		List<VilleDTO> villes;
		
		villes = villeDAO.get50Villes(offset);
		return villes;
	}
	
	
	public void updateVille(VilleDTO ville) throws SQLException {
		villeDAO.updateVille(ville);
	}
	
}
