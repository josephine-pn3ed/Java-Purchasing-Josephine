/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.ArrayList;

/**
 *
 * @author 2ndyrGroupC
 */
public class ListOfReceipts {
    static ArrayList<Receipt> receipts;

    public ListOfReceipts() {
        receipts = new ArrayList();
    }
    
    public static void add(int ID, String desc, double price, int quantity, double total) {
        receipts.add(new Receipt(ID, desc, price, quantity, total));
    }
    
    public static void retrieve() {
        System.out.println("\n\t\t*** R E C E I P T ***");
        System.out.println("ID\tMEDICINE\t\t\tPRICE\tQUANTITY\tTOTAL\n");
        receipts.stream().forEach((r) -> {
            System.out.println(r);
        });
    }
    
}
