package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.config.ConnexionBDD;
import com.dto.VilleDTO;

import lombok.Cleanup;

@Repository
public class VilleDAOImpl implements VilleDAO {

	public static final String ATTRIBUT_BDD_CODE_COMMUNE = "Code_commune_INSEE";
	public static final String ATTRIBUT_BDD_NOM_COMMUNE = "Nom_commune";
	public static final String ATTRIBUT_BDD_CODE_POSTAL = "Code_postal";
	public static final String ATTRIBUT_BDD_LIBELLE_ACHEMINEMENT = "Libelle_acheminement";
	public static final String ATTRIBUT_BDD_LIGNE_5 = "Ligne_5";
	public static final String ATTRIBUT_LATITUDE = "Latitude";
	public static final String ATTRIBUT_LONGITUDE = "Longitude";

	public static final String SQL_UPDATE_VILLE_FRANCE = "UPDATE ville_france SET Nom_commune = ?, "
			+ "Code_postal = ?, Libelle_acheminement = ?, Ligne_5 = ?, Latitude = ?, "
			+ "Longitude = ? WHERE Code_commune_INSEE = ?";

	public static final String SQL_INSERT_VILLE = "INSERT INTO ville_france VALUES(?,?,?,?,?,?,?)";

	public void createVille(VilleDTO ville) throws SQLException {
		@Cleanup Connection connection = ConnexionBDD.getConnexion();

		@Cleanup PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_VILLE_FRANCE);
		statement.setString(1, ville.getNomCommune());
		statement.setString(2, ville.getCodePostal());
		statement.setString(3, ville.getLibelleAcheminement());
		statement.setString(4, ville.getLigne5());
		statement.setString(5, ville.getLatitude());
		statement.setString(6, ville.getLongitude());
		statement.setString(7, ville.getCodeCommune());
		statement.executeQuery();

	}

	public void updateVille(VilleDTO ville) throws SQLException {
		@Cleanup Connection connection = ConnexionBDD.getConnexion();

		@Cleanup PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_VILLE_FRANCE);
		statement.setString(1, ville.getNomCommune());
		statement.setString(2, ville.getCodePostal());
		statement.setString(3, ville.getLibelleAcheminement());
		statement.setString(4, ville.getLigne5());
		statement.setString(5, ville.getLatitude());
		statement.setString(6, ville.getLongitude());
		statement.setString(7, ville.getCodeCommune());
		statement.executeUpdate();

	}

	public VilleDTO getVille() throws SQLException {
		@Cleanup Connection connection = ConnexionBDD.getConnexion();
		@Cleanup ResultSet result = null;
		
		VilleDTO ville = null;
		String requeteSQL = "SELECT * from ville_france LIMIT 1";
		
		PreparedStatement statement = connection.prepareStatement(requeteSQL);
		statement.execute();
		result = statement.executeQuery();
		while (result.next()) {
			ville = recupererVille(result);
		}

		return ville;
	}

	public List<VilleDTO> getVilles() throws SQLException {
		@Cleanup Connection connection = ConnexionBDD.getConnexion();
		@Cleanup ResultSet result = null;
		
		List<VilleDTO> villes = new ArrayList<>();
		String requeteSQL = "SELECT * from ville_france";
		
		PreparedStatement statement = connection.prepareStatement(requeteSQL);
		statement.execute();

		result = statement.executeQuery();
		while (result.next()) {
			VilleDTO ville = recupererVille(result);
			villes.add(ville);
		}
		return villes;

	}

	public static VilleDTO recupererVille(ResultSet result) throws SQLException {
		VilleDTO ville = new VilleDTO();
		ville.setCodeCommune(result.getString(ATTRIBUT_BDD_CODE_COMMUNE));
		ville.setNomCommune(result.getString(ATTRIBUT_BDD_NOM_COMMUNE));
		ville.setCodePostal(result.getString(ATTRIBUT_BDD_CODE_POSTAL));
		ville.setLibelleAcheminement(result.getString(ATTRIBUT_BDD_LIBELLE_ACHEMINEMENT));
		ville.setLigne5(result.getString(ATTRIBUT_BDD_LIGNE_5));
		ville.setLatitude(result.getString(ATTRIBUT_LATITUDE));
		ville.setLongitude(result.getString(ATTRIBUT_LONGITUDE));
		return ville;
	}

}
