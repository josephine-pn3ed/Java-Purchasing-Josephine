/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;


/**
 *
 * @author toringje_sd2022
 */
public class Medicine {
    private int medId;
    private String medicineName;
    private double medPrice;
    private int quantity;
    private String medDesc;

    public Medicine(){}

    public Medicine(int md,String medicineName, double medPrice, int quantity, String medDesc) {
        this.medId = md;
        this.medicineName = medicineName;
        this.medPrice = medPrice;
        this.quantity = quantity;
        this.medDesc = medDesc;
    }

    public int getMedId() {
        return medId;
    }

    public void setMedId(int medId) {
        this.medId = medId;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public double getMedPrice() {
        return medPrice;
    }

    public String getMedDesc() {
        return medDesc;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return medId+"\t|"+medicineName+"\t\t\t|"+medPrice+"\t\t|"+quantity+"\t\t|"+medDesc;
    }

}
   