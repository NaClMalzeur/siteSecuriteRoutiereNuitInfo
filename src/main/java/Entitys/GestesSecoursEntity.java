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
public class GestesSecoursEntity {
    private int gesteId;
    private String nom;
    private String url;
    private String texteDescription;

    public GestesSecoursEntity(int gesteId, String nom, String url, String texteDescription) {
        this.gesteId = gesteId;
        this.nom = nom;
        this.url = url;
        this.texteDescription = texteDescription;
    }

    public int getGesteId() {
        return gesteId;
    }

    public void setGesteId(int gesteId) {
        this.gesteId = gesteId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTexteDescription() {
        return texteDescription;
    }

    public void setTexteDescription(String texteDescription) {
        this.texteDescription = texteDescription;
    }
    
    
}
