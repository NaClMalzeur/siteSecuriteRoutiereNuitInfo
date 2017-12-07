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
public class VehiculeEntity {
    private int vehiculeId;
    private int nbPlaces;
    private String marque;
    private String modele;
    private String couleur;

    public VehiculeEntity(int vehiculeId, int nbPlaces, String marque, String modele, String couleur) {
        this.vehiculeId = vehiculeId;
        this.nbPlaces = nbPlaces;
        this.marque = marque;
        this.modele = modele;
        this.couleur = couleur;
    }

    public int getVehiculeId() {
        return vehiculeId;
    }

    public void setVehiculeId(int vehiculeId) {
        this.vehiculeId = vehiculeId;
    }

    public int getNbPlaces() {
        return nbPlaces;
    }

    public void setNbPlaces(int nbPlaces) {
        this.nbPlaces = nbPlaces;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }
    
    
}
