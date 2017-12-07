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
public class TicketEntity {
    private int trajetId;
    private int utilId;
    private String typeUtil;

    public TicketEntity(int trajetId, int utilId, String typeUtil) {
        this.trajetId = trajetId;
        this.utilId = utilId;
        this.typeUtil = typeUtil;
    }

    public int getTrajetId() {
        return trajetId;
    }

    public void setTrajetId(int trajetId) {
        this.trajetId = trajetId;
    }

    public int getUtilId() {
        return utilId;
    }

    public void setUtilId(int utilId) {
        this.utilId = utilId;
    }

    public String getTypeUtil() {
        return typeUtil;
    }

    public void setTypeUtil(String typeUtil) {
        this.typeUtil = typeUtil;
    }
    
    
}
