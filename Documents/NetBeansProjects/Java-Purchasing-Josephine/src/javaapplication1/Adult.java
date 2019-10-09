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
public class Adult extends User {

    @Override
    public double totalAmountPaid() {
        return  super.getTotalAmount();
    }

    public Adult(String name, int age, String password, double totalAmount) {
        super(name, age, password, totalAmount);
    }

    
}
