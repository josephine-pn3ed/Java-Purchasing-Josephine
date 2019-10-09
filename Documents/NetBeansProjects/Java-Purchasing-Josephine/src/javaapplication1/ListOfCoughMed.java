/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import static javaapplication1.ListOfUsers.adults;
import static javaapplication1.ListOfUsers.seniors;
import static javaapplication1.ListOfReceipts.retrieve;
import static javaapplication1.ListOfReceipts.add;

/**
 *
 * @author 2ndyrGroupC
 */
public class ListOfCoughMed {

    ArrayList<CoughMedicine> coughMeds;
    Scanner inputID = new Scanner(System.in);
    Scanner inputName = new Scanner(System.in);
    Scanner inputPrice = new Scanner(System.in);
    Scanner inputQuantity = new Scanner(System.in);
    Scanner inputDescription = new Scanner(System.in);
    Scanner inputGName = new Scanner(System.in);
    Scanner inputBName = new Scanner(System.in);
    Scanner inputUses = new Scanner(System.in);

    public ListOfCoughMed() {
        coughMeds = new ArrayList<>();
        populate();
    }

    public void displayMeds() {
        System.out.println("\n\t\t*** M E D I C I N E S  F O R  C O U G H  ***\n");
        System.out.println("ID\t|MEDICINE\t\t\t|PRICE\t\t|QUANTITY\t\t|DESCRIPTION\n");
        Iterator itr = coughMeds.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        System.out.print("\n");
    }

    public boolean updateMed(int ID, int quantity) {
        for (CoughMedicine a : coughMeds) {
            if (a.getMedId() == ID) {
                if (a.getQuantity() >= quantity) {
                    a.setQuantity(a.getQuantity() - quantity);
                    System.out.println(a.getQuantity());
                    add(ID, a.getMedicineName(), a.getMedPrice(), quantity, quantity * a.getMedPrice());
                    return true;
                } else if (a.getQuantity() == 0) {
                    System.out.println("There are no available medicine.");
                } else {
                    System.out.println("There are only " + a.getQuantity() + " available.");
                    break;
                }
            }
        }
        return false;
    }

    public void populate() {
        coughMeds.add(new CoughMedicine(101, "Carbocisteine + Zinc", 42.50, 30,
                "BRAND NAME:Solmux Advance; GENERIC NAME:Carbocisteine + Zinc; USES:for cough"));
        coughMeds.add(new CoughMedicine(102, "Ambroxol HCI", 32.75, 30,
                "BRAND NAME:Expel OD; GENERIC NAME:Ambroxol HCI; USES:for cough"));
        coughMeds.add(new CoughMedicine(103, "Dextromethorphan HBr Phenylpropanolamine HCI Paracetamol", 9.75, 30,
                "BRAND NAME:Tuseran Forte; GENERIC NAME:Dextromethorphan HBr Phenylpropanolamine HCI Paracetamol; USES:for cough"));
    }

    public void displayMed(int Id) {
        System.out.println("\n\t\t\t- Medicine's Information -");
        coughMeds.stream().filter((coughMed) -> (coughMed.getMedId() == Id)).map((coughMed) -> {
            System.out.println("Name : " + coughMed.getMedicineName());
            return coughMed;
        }).map((coughMed) -> {
            System.out.println("Description : " + coughMed.getMedDesc());
            return coughMed;
        }).map((coughMed) -> {
            System.out.println("Price : " + coughMed.getMedPrice());
            return coughMed;
        }).forEach((coughMed) -> {
            System.out.println("Quantity : " + coughMed.getQuantity());
        });
    }

    public double price(int id) {
        for (CoughMedicine coughMed : coughMeds) {
            if (coughMed.getMedId() == id) {
                return coughMed.getMedPrice();
            }
        }
        return 0;
    }

    public void addMedicine() {
        System.out.println("--- ADD COUGH MEDICINE ---");
        System.out.print("Enter Medicine Name : ");
        String med = inputName.nextLine();
        System.out.print("Enter Medicine Price : ");
        double price = inputPrice.nextDouble();
        System.out.print("Enter Medicine Quantity : ");
        int quantity = inputQuantity.nextInt();
        System.out.print("Enter Medicine Brand Name : ");
        String bName = inputBName.nextLine();
        System.out.print("Enter Medicine Generic Name : ");
        String gName = inputGName.nextLine();
        System.out.print("Enter Medicine Use :");
        String use = inputUses.nextLine();
        coughMeds.add(new CoughMedicine(coughMeds.get(coughMeds.size()-1).getMedId()+1, med, price, quantity, "BRAND NAME:" + bName + "; GENERIC NAME:" + gName + "; USES:" + use));
    }
    
    public void removeMedicine() {
        System.out.println("\n--- REMOVE COUGH MEDICINE ---");
        System.out.print("Enter Medicine ID : ");
        int id = inputID.nextInt();
        for (int i = 0; i < coughMeds.size(); i++) {
            if (coughMeds.get(i).getMedId() == id) {
                coughMeds.remove(i);
                System.out.println(coughMeds.get(i).getMedicineName() + " is removed.");
                break;
            }
        }
    }

    public void run(String username) {
        displayMeds();
        Scanner inputID = new Scanner(System.in);
        System.out.print("Choose Medicine ID : ");
        int ID = inputID.nextInt();
        displayMed(ID);
        System.out.println("\nDo you want to purchase ? (y / n)");
        System.out.print("Enter choice : ");
        Scanner input = new Scanner(System.in);
        String choice = input.nextLine();
        if ("y".equals(choice)) {
            Scanner inputquan = new Scanner(System.in);
            System.out.print("Quantity : ");
            int quantity = inputquan.nextInt();
            boolean purchase = updateMed(ID, quantity);
            if (purchase == true) {
                for (Adult adult : adults) {
                    if (adult.getName().equals(username)) {
                        adult.setTotalAmount((quantity * price(ID)) + adult.getTotalAmount());
                        System.out.println("Total Amount: " + adult.getTotalAmount());
                        retrieve();
                        break;
                    }
                }
                for (Senior senior : seniors) {
                    if (senior.getName().equals(username)) {
                        senior.setTotalAmount((quantity * price(ID)) + senior.getTotalAmount());
                        System.out.println("Total Amount: " + senior.getTotalAmount());
                        retrieve();
                        break;
                    }
                }
            }
        }
    }
}
