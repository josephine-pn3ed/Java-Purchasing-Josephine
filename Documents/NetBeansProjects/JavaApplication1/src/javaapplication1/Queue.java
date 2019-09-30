/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author 2ndyrGroupC
 */
public class Queue {

    private ArrayDeque<ArrayList<String>> accounts = new ArrayDeque<ArrayList<String>>();

    Scanner input = new Scanner(System.in);

    public void add() {
        ArrayList<String> account = new ArrayList<String>();
        System.out.println("\nPlease input ID number, Name, Course: ");
        System.out.print("ID number : ");
        account.add(input.nextLine());
        System.out.print("Name : ");
        account.add(input.nextLine());
        System.out.print("Course : ");
        account.add(input.nextLine());
        accounts.push(account);
    }

    public void display() {
        System.out.println("\nDislay list of accounts : ");
        Iterator itr = accounts.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
    
    public void remove() {}

    public void update() {
//       System.out.println("\nPlease input ID number: ");
//       String id = input.nextLine();     
//       for (int i = 0; i < accounts.size(); i++) {
//           if (accounts.get(i).get(0).equals(id)) {
//               System.out.println(accounts.get(i));
//               System.out.print("Change Username: ");
//               String username = input.nextLine();
//               System.out.print("Change Password: ");
//               String passw = input.nextLine();
//               accounts.get(i).set(1, username);
//               accounts.get(i).set(2, passw);
//           }
//           break;
//       }
//       
    }

}
