/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitys;

import java.sql.Date;

/**
 *
 * @author xzait
 */
public class Event {
    private double lon;
    private double lat;
    private String name;
    private String creator;
    private Date date;
    
    public Event(double lon,double lat, String name, String creator, Date date){
        this.lat=lat;
        this.lon=lon;
        this.date=date;
        this.name=name;
        this.creator=creator;
    }
    
    public double getLon(){
       return lat;
    }
    
    public double getLat(){
        return lon;
    }
    
    public Date getDate(){
        return date;
    }
    
    public String getName(){
        return name;
    }
    
    public String getCreator(){
        return creator;
    }
}
