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
public class SecoursEntity {
    private int secoursId;
    private String nom;
    private String telephone;
    private String description;

    public SecoursEntity(int secoursId, String nom, String telephone, String description) {
        this.secoursId = secoursId;
        this.nom = nom;
        this.telephone = telephone;
        this.description = description;
    }

    public int getSecoursId() {
        return secoursId;
    }

    public void setSecoursId(int secoursId) {
        this.secoursId = secoursId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
