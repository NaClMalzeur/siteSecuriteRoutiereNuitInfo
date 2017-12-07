package Entitys;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author max
 */
public class Place {
    public String name;
    public LatLng latlng;
    

    public void setL(LatLng l) {
        this.latlng = l;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LatLng getL() {
        return latlng;
    }

    public String getName() {
        return name;
    }

    public Place(String name, LatLng l) {
        this.name = name;
        this.latlng = l;
    }

    
}
