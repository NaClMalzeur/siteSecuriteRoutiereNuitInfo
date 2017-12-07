/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import Entitys.AccidentsEntity;
import Entitys.LatLng;
import Entitys.Place;
import Entitys.UtilisateurEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

/**
 *
 * @author Eman
 */
public class DAO {
    private final DataSource myDataSource;
    
    /**
     *
     * @param dataSource la source de données à utiliser
     */
    public DAO(DataSource dataSource) {
            this.myDataSource = dataSource;
    }
    
    private int newId(String table){
        String attribut = "";
        switch(table){
            case "accidents":
                attribut = "accid_id";
                break;
                
            case "gestesecours":
                attribut = "geste_id";
                break;
                
            case "secours":
                attribut = "secours_id";
                break;
                
            case "trajet":
                attribut = "trajet_id";
                break;
                
            case "utilisateur":
                attribut = "util_id";
                break;
                
            case "vehicule":
                attribut = "vehic_id";
                break;
        }
                
        String query = "SELECT MAX(?)+1 as id FROM ? ";
        int newID = -1;
        
        try(Connection connection = myDataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(query)){
            
            pstmt.setString(1, attribut);
            pstmt.setString(2, table);
            
            pstmt.executeQuery();
            
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    newID = rs.getInt("id");
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return newID;
    }
    
    public UtilisateurEntity logIn(String mail, String motDePasse){
        String sql = "SELECT * FROM utilisateur WHERE mail = ? AND mot_de_passe = ?";
        UtilisateurEntity util = null;
        try (Connection connection = myDataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql)) {
            
            pstmt.setString(1, mail);
            pstmt.setString(2, motDePasse);
            
            pstmt.executeQuery();
            
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    int utilId = rs.getInt("utilId");
                    String nom = rs.getString("nom");
                    String prenom = rs.getString("prenom");
                    int numRue = rs.getInt("numRue");
                    String rue = rs.getString("rue");
                    String ville = rs.getString("ville");
                    String codePostal = rs.getString("codePostal");
                    String email = rs.getString("email");
                    String telephone = rs.getString("telephone");
                    String mdp = rs.getString("motDePasse");
                    Boolean admin = rs.getBoolean("admin");
                    
                    util = new UtilisateurEntity(utilId, nom, prenom,
                                numRue, rue, ville, codePostal, 
                                email, telephone, mdp, admin);
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return util;
    }
    
    public void signIn(UtilisateurEntity util){
        
        String sql = "INSERT INTO utilisateur"
                + "VALUES(?,?,?,?,?,?,?,?,?,?,false)";
        
        try (Connection connection = myDataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql)) {
            
            pstmt.setInt(1, newId("utilisateur"));
            pstmt.setString(2, util.getNom());
            pstmt.setString(3, util.getPrenom());
            pstmt.setInt(4, util.getNumRue());
            pstmt.setString(5, util.getRue());
            pstmt.setString(6, util.getVille());
            pstmt.setString(7, util.getCodePostal());
            pstmt.setString(8, util.getEmail());
            pstmt.setString(9, util.getTelephone());
            pstmt.setString(10, util.getMotDePasse());
            
            pstmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public ArrayList<Place> getNearestPlaces(Place current_place, double radius) throws DAOException {
        ArrayList<Place> result = new ArrayList<Place>();
        String sql = "SELECT t.Long_dep,\n" +
"        t.Lat_dep,\n" +
"                 * DEGREES(ACOS(COS(RADIANS(p.latpoint))\n" +
"                 * COS(RADIANS(t.Lat_dep))\n" +
"                 * COS(RADIANS(p.longpoint) - RADIANS(t.Long_dep))\n" +
"                 + SIN(RADIANS(p.latpoint))\n" +
"                 * SIN(RADIANS(t.Lat_dep)))) AS distance_in_km\n" +
"  FROM Trajet AS t\n" +
"  JOIN (   /* these are the query parameters */\n" +
"        SELECT  ?  AS latpoint, ? AS longpoint,\n" +
"                ? AS radius,      111.045 AS distance_unit\n" +
"    ) AS p ON 1=1\n" +
"  WHERE t.Lat_dep\n" +
"     BETWEEN p.latpoint  - (p.radius / p.distance_unit)\n" +
"         AND p.latpoint  + (p.radius / p.distance_unit)\n" +
"    AND t.Long_dep\n" +
"     BETWEEN p.longpoint - (p.radius / (p.distance_unit * COS(RADIANS(p.latpoint))))\n" +
"         AND p.longpoint + (p.radius / (p.distance_unit * COS(RADIANS(p.latpoint))))\n" +
"  ORDER BY distance_in_km\n" +
"  LIMIT 15";
        LatLng current_latlng = current_place.getL();
        double current_lat = current_latlng.getLatitude();
        double current_long = current_latlng.getLongitude();
        try (Connection connection = myDataSource.getConnection(); // Ouvrir une connexion
                PreparedStatement stmt = connection.prepareStatement(sql);) {
            stmt.setDouble(1, current_lat);
            stmt.setDouble(2,current_long);
            stmt.setDouble(3, radius);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String nom = rs.getString("NAME");
                double long_dep = rs.getDouble("LONG_DEP");
                double lat_dep = rs.getDouble("LAT_DEP");
                LatLng new_latlng = new LatLng(lat_dep, long_dep);
                Place new_place = new Place(nom, new_latlng);
                result.add(new_place);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
            throw new DAOException(ex.getMessage());
        }
        return result;
    }
    public int addWarning(AccidentsEntity war) throws DAOException {
            int resualt = 0;
            String sql = "INSERT INTO ACCIDENTS (LONGITUDE, LATITUDE,"
                    + " TYPE_ACCID, COMMENTAIRE, DATE, SALES_DATE,"
                    + " VALUES (?, ?, ?, ?, ?)";
            try (Connection connection = myDataSource.getConnection();
                    PreparedStatement stmt = connection.prepareStatement(sql)) {

                stmt.setDouble(1, war.getLatitude());
                stmt.setDouble(2, war.getLongitude());
                stmt.setString(3, war.getType());
                stmt.setString(4, war.getCommentaire());
                stmt.setDate(5, war.getDate());
                resualt = stmt.executeUpdate();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
                throw new DAOException(ex.getMessage());
            }
            return resualt;
        }
}
