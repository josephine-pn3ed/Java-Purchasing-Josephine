/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author 2ndyrGroupC
 */
public class Receipt {
    private final int ID;
    private final String medicine;
    private final double price;
    private final int quantity;
    private final double total;

    public Receipt(int ID, String medicine, double price, int quantity, double total) {
        this.ID = ID;
        this.medicine = medicine;
        this.price = price;
        this.quantity = quantity;
        this.total = total;
    }

    @Override
    public String toString() {
        return ID + "\t" + medicine + "\t\t\t" + price + "\t" + quantity + "\t" + total;
    }
}
