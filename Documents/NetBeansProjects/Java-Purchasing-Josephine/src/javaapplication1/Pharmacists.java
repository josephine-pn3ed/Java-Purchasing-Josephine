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
public class Pharmacists extends User {

    public Pharmacists(String name, int age, String password, double totalAmount) {
        super(name, age, password, totalAmount);
    }

    @Override
    public double totalAmountPaid() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
