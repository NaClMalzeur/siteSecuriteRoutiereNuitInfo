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
public class TajetEntity {
    private int trajetId;
    private int vehiculeId;
    private double longDep;
    private double latDep;
    private double longArr;
    private double latArr;
    private int heureDep;
    private int minDep;

    public TajetEntity(int trajetId, int vehiculeId, double longDep, double latDep, double longArr, double latArr, int heureDep, int minDep) {
        this.trajetId = trajetId;
        this.vehiculeId = vehiculeId;
        this.longDep = longDep;
        this.latDep = latDep;
        this.longArr = longArr;
        this.latArr = latArr;
        this.heureDep = heureDep;
        this.minDep = minDep;
    }

    public int getTrajetId() {
        return trajetId;
    }

    public void setTrajetId(int trajetId) {
        this.trajetId = trajetId;
    }

    public int getVehiculeId() {
        return vehiculeId;
    }

    public void setVehiculeId(int vehiculeId) {
        this.vehiculeId = vehiculeId;
    }

    public double getLongDep() {
        return longDep;
    }

    public void setLongDep(double longDep) {
        this.longDep = longDep;
    }

    public double getLatDep() {
        return latDep;
    }

    public void setLatDep(double latDep) {
        this.latDep = latDep;
    }

    public double getLongArr() {
        return longArr;
    }

    public void setLongArr(double longArr) {
        this.longArr = longArr;
    }

    public double getLatArr() {
        return latArr;
    }

    public void setLatArr(double latArr) {
        this.latArr = latArr;
    }

    public int getHeureDep() {
        return heureDep;
    }

    public void setHeureDep(int heureDep) {
        this.heureDep = heureDep;
    }

    public int getMinDep() {
        return minDep;
    }

    public void setMinDep(int minDep) {
        this.minDep = minDep;
    }
    
    
}
