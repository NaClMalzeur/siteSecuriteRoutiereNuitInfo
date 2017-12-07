/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitys;

/**
 *
 * @author Eman
 */
public class UtilisateurEntity {
    private int utilId;
    private String nom;
    private String prenom;
    private int numRue;
    private String rue;
    private String ville;
    private String codePostal;
    private String email;
    private String telephone;
    private String motDePasse;
    private boolean admin;

    public UtilisateurEntity(int utilId, String nom, String prenom, int numRue, String rue, String ville, String codePostal, String email, String telephone, String motDePasse, boolean admin) {
        this.utilId = utilId;
        this.nom = nom;
        this.prenom = prenom;
        this.numRue = numRue;
        this.rue = rue;
        this.ville = ville;
        this.codePostal = codePostal;
        this.email = email;
        this.telephone = telephone;
        this.motDePasse = motDePasse;
        this.admin = admin;
    }

    public int getUtilId() {
        return utilId;
    }

    public void setUtilId(int utilId) {
        this.utilId = utilId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getNumRue() {
        return numRue;
    }

    public void setNumRue(int numRue) {
        this.numRue = numRue;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
    
    
}
