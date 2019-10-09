/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.io.InputStream;
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
public class ListOfAllergyMed {

    ArrayList<AllergyMedicine> allergyMeds;
    Scanner inputID = new Scanner(System.in);
    Scanner inputName = new Scanner(System.in);
    Scanner inputPrice = new Scanner(System.in);
    Scanner inputQuantity = new Scanner(System.in);
    Scanner inputDescription = new Scanner(System.in);
    Scanner inputGName = new Scanner(System.in);
    Scanner inputBName = new Scanner(System.in);
    Scanner inputUses = new Scanner(System.in);

    public ListOfAllergyMed() {
        allergyMeds = new ArrayList<>();
        populate();
    }

    public void displayMeds() {
        System.out.println("\n\t\t*** M E D I C I N E S  F O R  A L L E R G Y  ***\n");
        System.out.println("ID\t|MEDICINE\t\t\t|PRICE\t\t|QUANTITY\t\t|DESCRIPTION\n");
        Iterator itr = allergyMeds.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        System.out.println("\n");
    }

    public boolean updateMed(int ID, int quantity) {
        for (AllergyMedicine a : allergyMeds) {
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
        allergyMeds.add(new AllergyMedicine(401, "Cetirizine Dihydrochloride", 20.25, 30,
                "BRAND NAME:Zyriz; GENERIC NAME:Cetirizine Dihydrochloride; USES:for allergies"));
        allergyMeds.add(new AllergyMedicine(402, "Loratadine", 23.75, 30,
                "BRAND NAME:Lorexa QD; GENERIC NAME:Loratadine; USES:for allergies"));
        allergyMeds.add(new AllergyMedicine(403, "Antihistamine", 22.15, 30,
                "BRAND NAME:Allerta; GENERIC NAME:Antihistamine; USES:for allergies"));
    }

    public void displayMed(int Id) {
        System.out.println("\n\t\t\t- Medicine's Information -");
        allergyMeds.stream().filter((allergyMed) -> (allergyMed.getMedId() == Id)).map((allergyMed) -> {
            System.out.println("Name : " + allergyMed.getMedicineName());
            return allergyMed;
        }).map((allergyMed) -> {
            System.out.println("Description : " + allergyMed.getMedDesc());
            return allergyMed;
        }).map((allergyMed) -> {
            System.out.println("Price : " + allergyMed.getMedPrice());
            return allergyMed;
        }).forEach((allergyMed) -> {
            System.out.println("Quantity : " + allergyMed.getQuantity());
        });
    }

    public double price(int id) {
        for (AllergyMedicine allergyMed : allergyMeds) {
            if (allergyMed.getMedId() == id) {
                return allergyMed.getMedPrice();
            }
        }
        return 0;
    }
    
    public void addMedicine() {
        System.out.println("--- ADD ALLERGY MEDICINE ---");
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
        allergyMeds.add(new AllergyMedicine(allergyMeds.get(allergyMeds.size()-1).getMedId()+1, med, price, quantity, "BRAND NAME:" + bName + "; GENERIC NAME:" + gName + "; USES:" + use));
    }
    
    public void removeMedicine() {
        System.out.println("\n--- REMOVE ALLERGY MEDICINE ---");
        System.out.print("Enter Medicine ID : ");
        int id = inputID.nextInt();
        for (int i = 0; i < allergyMeds.size(); i++) {
            if (allergyMeds.get(i).getMedId() == id) {
                allergyMeds.remove(i);
                System.out.println(allergyMeds.get(i).getMedicineName() + " is removed.");
                break;
            }
        }
    }

    public void run(String username) {
        displayMeds();
        Scanner inputID = new Scanner(System.in);
        System.out.print("Choice Medicine ID : ");
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
