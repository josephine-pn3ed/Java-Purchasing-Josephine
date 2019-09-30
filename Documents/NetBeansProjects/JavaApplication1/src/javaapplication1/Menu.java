/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.Scanner;

/**
 *
 * @author 2ndyrGroupC
 */
public class Menu {

    public static void main(String[] args) {

        List list = new List();
        Set set = new Set();
        Queue queue = new Queue();

        while (true) {

            System.out.println("MENU");
            System.out.println("\t1 . LIST\n\t2 . QUEUE\n\t3 . SET");

            Scanner sc = new Scanner(System.in);

            System.out.print("ENTER OPTION : ");
            int option = sc.nextInt();

            if (option == 1) {
                while (true) {
                    System.out.println("\nYOU ARE NOW IN LIST MODE : ");
                    System.out.println("\tc . CREATE\n\tr . RETRIEVE\n\tu . UPDATE\n\td . DELETE\n\te . EXIT");

                    System.out.print("ENTER OPTION : ");
                    Scanner sl = new Scanner(System.in);
                    String opt = sl.nextLine();

                    if ("a".equals(opt)) {
                        list.add();
                        System.out.println("Student added!");
                    } else if ("b".equals(opt)) {
                        list.display();
                    } else if ("c".equals(opt)) {
                        list.update();
                        System.out.println("List updated!");
                    } else if ("d".equals(opt)) {
                        list.remove();
                    } else if ("e".equals(opt)) {
                        break;
                    }
                }
            } else if (option == 2) {
                while (true) {
                    System.out.println("\nYOU ARE NOW IN QUEUE MODE : ");
                    System.out.println("\tc . CREATE\n\tr . RETRIEVE\n\tu . UPDATE\n\td . DELETE\n\tc . EXIT");

                    System.out.print("ENTER OPTION : ");
                    Scanner sl = new Scanner(System.in);
                    String opt = sl.nextLine();

                    if ("a".equals(opt)) {
                        queue.add();
                        System.out.println("Student added!");
                    } else if ("b".equals(opt)) {
                        queue.display();
                    } else if ("c".equals(opt)) {
                        queue.update();
                        System.out.println("List updated!");
                    } else if ("d".equals(opt)) {
                        queue.remove();
                    } else if ("e".equals(opt)) {
                        break;
                    }
                }
            } else if (option == 3) {
                while (true) {
                    System.out.println("\nYOU ARE NOW IN SET MODE : ");
                    System.out.println("\tc . CREATE\n\tr . RETRIEVE\n\tu . UPDATE\n\td . DELETE\n\tc . EXIT");

                    System.out.print("ENTER OPTION : ");
                    Scanner sl = new Scanner(System.in);
                    String opt = sl.nextLine();

                    if ("a".equals(opt)) {
                        set.add();
                        System.out.println("Student added!");
                    } else if ("b".equals(opt)) {
                        set.display();
                    } else if ("c".equals(opt)) {
                        set.update();
                        System.out.println("List updated!");
                    } else if ("d".equals(opt)) {
                        set.remove();
                    } else if ("e".equals(opt)) {
                        break;
                    }
                }
            } else {
                System.out.println("OUT OF OPTION!");
                break;
            }
        }

    }

}
