/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 2ndyrGroupC
 */
public class ListOfUsers {

    static ArrayList<Adult> adults;
    static ArrayList<Senior> seniors;
    static ArrayList<Pharmacists> pharmacists;
    private String name;
    private String password;
    private int age;
    Scanner inputName = new Scanner(System.in);
    Scanner inputPass = new Scanner(System.in);
    Scanner inputAge = new Scanner(System.in);
    Scanner registeruser = new Scanner(System.in);
    Scanner logInuser = new Scanner(System.in);

    public ListOfUsers() {
        adults = new ArrayList();
        seniors = new ArrayList();
        pharmacists = new ArrayList();
        adults.add(new Adult("melvin", 22, "melvin123", 0.0));
        seniors.add(new Senior("toring", 60, "toring123", 0.0));
        pharmacists.add(new Pharmacists("josephine", 21, "j", 0.0));
    }

    public void register() {
        System.out.println("\n*** REGISTER ***");
        System.out.println("1 -- Register as USER\n2 -- Register as PHARMACIST\n");
        System.out.print("Enter a choice : ");
        String inputUser = registeruser.nextLine();
        System.out.print("Enter username : ");
        name = inputName.nextLine();
        System.out.print("Enter password : ");
        password = inputPass.nextLine();
        System.out.print("Enter age : ");
        age = inputAge.nextInt();

        if ("1".equals(inputUser)) {
            if (age < 18) {
                System.out.println("You are under age!");
            } else if (age >= 60) {
                seniors.add(new Senior(name, age, password, 0.0));
                System.out.println("You are registered!");
            } else {
                adults.add(new Adult(name, age, password, 0.0));
                System.out.println("You are registered!");
            }
        } else if ("2".equals(inputUser)) {
            if (age < 18) {
                System.out.println("You are under age!");
            } else {
                pharmacists.add(new Pharmacists(name, age, password, 0.0));
                System.out.println("You are registered!");
            }
        } else {
            System.out.println("None of the choices.");
        }
    }

    public String logIn() {
        System.out.println("\n*** LOG IN ***");
        System.out.println("1 -- Register as USER\n2 -- Register as PHARMACIST");
        System.out.print("Enter a choice : ");
        String inputUser = logInuser.nextLine();
        System.out.print("Enter username : ");
        name = inputName.nextLine();
        if ("1".equals(inputUser)) {
            for (Adult adult : adults) {
                if (adult.getName().equals(name)) {
                    while (true) {
                        System.out.print("Enter password : ");
                        password = inputPass.nextLine();
                        if (adult.getPassword().equals(password)) {
                            System.out.println("You are now logged in!");
                            return "adult";
                        } else {
                            System.out.println("Incorrect password!");
                        }
                    }
                }
            }
            for (int i = 0; i < seniors.size(); i++) {
                if (seniors.get(i).getName().equals(name)) {
                    while (true) {
                        System.out.print("Enter password : ");
                        password = inputPass.nextLine();
                        if (seniors.get(i).getPassword().equals(password)) {
                            System.out.println("You are now logged in!");
                            return "senior";
                        } else {
                            System.out.println("Incorrect password!");
                        }
                    }
                } else if (i == seniors.size() - 1) {
                    System.out.println("You are not yet registered!");
                }
            }
        } else if ("2".equals(inputUser)) {
            for (Pharmacists pharmacist : pharmacists) {
                if (pharmacist.getName().equals(name)) {
                    while (true) {
                        System.out.print("Enter password : ");
                        password = inputPass.nextLine();
                        if (pharmacist.getPassword().equals(password)) {
                            System.out.println("You are now logged in!");
                            return "pharmacist";
                        } else {
                            System.out.println("Incorrect password!");
                        }
                    }
                }
            }
        }
        return null;
    }

}
