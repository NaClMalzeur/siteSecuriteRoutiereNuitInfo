/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitys;

import java.util.Date;

/**
 *
 * @author Eman
 */
public class AccidentsEntity {
    private int numAccident;
    private double longitude;
    private double latitude;
    private String type;
    private String Commentaire;
    private Date date;

    public AccidentsEntity(int numAccident, double longitude, double latitude, String type, String Commentaire, Date date) {
        this.numAccident = numAccident;
        this.longitude = longitude;
        this.latitude = latitude;
        this.type = type;
        this.Commentaire = Commentaire;
        this.date = date;
    }

    public int getNumAccident() {
        return numAccident;
    }

    public void setNumAccident(int numAccident) {
        this.numAccident = numAccident;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCommentaire() {
        return Commentaire;
    }

    public void setCommentaire(String Commentaire) {
        this.Commentaire = Commentaire;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
}
