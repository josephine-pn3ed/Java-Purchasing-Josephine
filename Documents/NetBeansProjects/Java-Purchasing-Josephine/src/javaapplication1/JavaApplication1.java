/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.Scanner;
import static javaapplication1.ListOfReceipts.retrieve;
import static javaapplication1.ListOfUsers.adults;
import static javaapplication1.ListOfUsers.seniors;

/**
 *
 * @author toringje_sd2022
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ListOfUsers users = new ListOfUsers();
        ListOfAllergyMed a = new ListOfAllergyMed();
        ListOfCoughMed c = new ListOfCoughMed();
        ListOfHeadAcheMed h = new ListOfHeadAcheMed();
        ListOfPainRelieverMed p = new ListOfPainRelieverMed();
        while (true) {
            ListOfReceipts receipt = new ListOfReceipts();
            boolean exit = false;
            String user = null;
            boolean pay = false;
            boolean logOutP = false;
            String username = null;
            Scanner input1 = new Scanner(System.in);
            Scanner input2 = new Scanner(System.in);
            Scanner input3 = new Scanner(System.in);
            Scanner inputp = new Scanner(System.in);
            Scanner inputa = new Scanner(System.in);
            Scanner inputr = new Scanner(System.in);

            System.out.println("\n☻ ☻ ☻ ☻ ☻  W E L C O M E  T O  J E S S M E L  P H A R M A C Y  ☻ ☻ ☻ ☻ ☻");

            while (exit == false) {
                System.out.println("\n C H O I C E S \n1 -- Register\n2 -- Log in\n");
                System.out.print("Enter choice : ");
                String choice1 = input1.nextLine();
                switch (choice1) {
                    case "1":
                        users.register();
                        break;
                    case "2":
                        user = users.logIn();
                        exit = true;
                        break;
                }
            }
            if ("adult".equals(user) || "senior".equals(user)) {
                while (pay == false) {
                    System.out.println("\n C H O I C E S \n1 -- Types of medicines\n2 -- Pay\n");
                    System.out.print("Enter choice : ");
                    String choice2 = input2.nextLine();
                    switch (choice2) {
                        case "1":
                            System.out.println("\nTypes of Medicines : ");
                            System.out.println("\t1 -- for cough\n\t2 -- for headache\n\t3 -- for pain reliever\n\t4 -- for allergy\n");
                            System.out.print("Enter choice : ");
                            String choice3 = input3.nextLine();
                            if ("1".equals(choice3)) {
                                c.run(username);
                            } else if ("2".equals(choice3)) {
                                h.run(username);
                            } else if ("3".equals(choice3)) {
                                p.run(username);
                            } else if ("4".equals(choice3)) {
                                a.run(username);
                            }
                            break;
                        case "2":
                            boolean end = false;
                            System.out.println("\n--- P A Y ---");
                            for (Adult adult : adults) {
                                if (adult.getName().equals(username)) {
                                    adult.totalAmountPaid();
                                    retrieve();
                                    System.out.println("Your total payment is " + adult.getTotalAmount());
                                    end = true;
                                    break;
                                }
                            }
                            if (end == true) {
                                pay = true;
                                break;
                            }
                            for (Senior senior : seniors) {
                                if (senior.getName().equals(username)) {
                                    senior.totalAmountPaid();
                                    retrieve();
                                    System.out.println("\n20% discount!");
                                    System.out.println("Your total payment is " + senior.getTotalAmount());
                                    break;
                                }
                            }
                            pay = true;
                            break;
                    }

                }
            } else if ("pharmacist".equals(user)) {
                while (logOutP == false) {
                    System.out.println("\n C H O I C E S \n1 -- View Medicines\n2 -- Add Medicine\n3 -- Log Out\n");
                    System.out.print("Enter choice : ");
                    String choicep = inputp.nextLine();
                    switch (choicep) {
                        case "1":
                            System.out.println("\n--- V I E W  M E D I C I N E ---");
                            c.displayMeds();
                            h.displayMeds();
                            p.displayMeds();
                            a.displayMeds();
                            break;
                        case "2":
                            System.out.println("\n--- A D D  M E D I C I N E ---\nTypes of Medicines : ");
                            System.out.println("\t1 -- adding cough medicines\n\t2 -- adding headache medicine\n\t3 -- adding pain reliever medicine\n\t4 -- adding allergy medicine\n");
                            System.out.print("Enter choice : ");
                            String choicea = inputa.nextLine();
                            if ("1".equals(choicea)) {
                                c.addMedicine();
                                c.displayMeds();
                            } else if ("2".equals(choicea)) {
                                h.addMedicine();
                                h.displayMeds();
                            } else if ("3".equals(choicea)) {
                                p.addMedicine();
                                p.displayMeds();
                            } else if ("4".equals(choicea)) {
                                a.addMedicine();
                                a.displayMeds();
                            }
                            break;
                        case "3":
                            System.out.println("\n--- R E M O V E  M E D I C I N E ---\nTypes of Medicines : ");
                            System.out.println("\t1 -- removing cough medicines\n\t2 -- removing headache medicine\n\t3 -- removing pain reliever medicine\n\t4 -- removing allergy medicine\n");
                            System.out.print("Enter choice : ");
                            String choicer = inputr.nextLine();
                            if ("1".equals(choicer)) {
                                c.removeMedicine();
                            } else if ("2".equals(choicer)) {
                                h.removeMedicine();
                            } else if ("3".equals(choicer)) {
                                p.removeMedicine();
                            } else if ("4".equals(choicer)) {
                                a.removeMedicine();
                            }
                            break;
                        case "4":
                            logOutP = true;
                            break;
                    }
                }
            }
        }
    }

}
