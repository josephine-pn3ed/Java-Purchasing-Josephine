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
public class Senior  extends User {

    public Senior(String name, int age, String password, double totalAmount) {
        super(name, age, password, totalAmount);
    }

    @Override
    public double totalAmountPaid() {
        super.setTotalAmount(super.getTotalAmount()*0.8);
        return super.getTotalAmount();
    }
}
    
    

