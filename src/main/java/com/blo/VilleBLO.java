package com.blo;

import java.sql.SQLException;
import java.util.List;

import com.dto.VilleDTO;

public interface VilleBLO {
	
	public VilleDTO getInfoVille() throws SQLException;
	public List<VilleDTO> getVilles() throws SQLException;
	public void updateVille(VilleDTO ville) throws SQLException;
	public void addVille(VilleDTO ville) throws SQLException;

}
