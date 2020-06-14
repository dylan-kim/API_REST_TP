package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.dto.VilleDTO;

public interface VilleDAO {
	
	public void createVille(VilleDTO ville) throws SQLException;
	public void updateVille(VilleDTO ville) throws SQLException;
	public List<VilleDTO> getVilles() throws SQLException;
	public VilleDTO getVille() throws SQLException;
	
}
