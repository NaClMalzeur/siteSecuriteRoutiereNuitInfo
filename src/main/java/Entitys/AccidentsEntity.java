/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitys;

import java.awt.geom.Point2D;
import java.sql.Date;



/**
 *
 * @author Eman
 */
public class AccidentsEntity {
    private int numAccident;
    private final Point2D.Float point;
    private String type;
    private String Commentaire;
    private Date date;

    public AccidentsEntity(int numAccident, float longitude, float latitude, String type, String Commentaire, Date date) {
        this.numAccident = numAccident;
        this.point=new Point2D.Float(longitude,latitude);
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

    public Point2D.Float getPoint(){
        return this.point;
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
