/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import Entitys.UtilisateurEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    /*
    public int addWarning(Warning war) throws DAOException {
            int resualt = 0;
            String sql = "INSERT INTO ACCIDENTS (LONGITUDE, LATITUDE,"
                    + " TYPE_ACCID, COMMENTAIRE, DATE, SALES_DATE,"
                    + " VALUES (?, ?, ?, ?, ?)";
            try (Connection connection = myDataSource.getConnection();
                    PreparedStatement stmt = connection.prepareStatement(sql)) {

                stmt.setFloat(1, war.getLat());
                stmt.setFloat(2, war.getLon());
                stmt.setString(3, war.getCat());
                stmt.setString(4, war.getCom());
                stmt.setDate(5, war.getDate());
                resualt = stmt.executeUpdate();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
                throw new DAOException(ex.getMessage());
            }
            return resualt;
        }
    */
}
