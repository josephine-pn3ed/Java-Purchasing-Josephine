package appsamp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeSet;

public class Appsamp {

    public static void main(String[] args) {
        TreeSet<String> student = new TreeSet();
        PriorityQueue<Double> grade = new PriorityQueue();
        ArrayList<String> courses = new ArrayList();

        student.add("Cabungcag");
        student.add("Gigante");
        student.add("Duran");
        student.add("Rivas");
        student.add("Tanilon");

        grade.add(1.5);
        grade.add(1.8);
        grade.add(2.0);
        grade.add(1.0);
        grade.add(1.2);

        courses.add("*Java ");
        courses.add("*Website Develpment 3");
        courses.add("*Big Data");
        courses.add("*Architecture of Information Systems");
        courses.add("*SD Elective");

        System.out.println("\t\tPN Class 2021 Record\n");

        Scanner myObj = new Scanner(System.in);
        System.out.println("Options: \n 1 - List of Students \n 2 - Highest Grade Recorded \n 3 - Courses Taking");
        System.out.print("Selection: ");

        int choice = myObj.nextInt();
        switch (choice) {

            case 1:
                System.out.println("\n\tGroup 3 - PN Philippines Scholars");
                student.remove("Cabungcag, Chilla Jean");
                Iterator<String> itr = student.iterator();
                while (itr.hasNext()) {
                    System.out.println("\t\t" + itr.next());
                }

                Scanner add = new Scanner(System.in);
                System.out.print("Add new Student: ");
                String addStudent = add.nextLine();
                System.out.println(addStudent + " is added to the list.");
                student.add(addStudent);
                Iterator<String> adds = student.iterator();
                while (adds.hasNext()) {
                    System.out.println("\t\t" + adds.next());
                }

                Scanner ret = new Scanner(System.in);
                System.out.print("Retrieve Student: ");
                String retStudent = ret.nextLine();
                if (student.contains(retStudent)) {
                    System.out.println(retStudent + " is in list.");
                } else {
                    System.out.println(retStudent + " is not in list.");
                }
                student.add(retStudent);

                System.out.print("Student to Update: ");
                String updateStudent = add.nextLine();
                if (student.contains(updateStudent)) {
                    student.remove(updateStudent);
                    System.out.print("Update to: ");
                    String newStudent = add.nextLine();
                    student.add(newStudent);
                    Iterator<String> up = student.iterator();
                    while (up.hasNext()) {
                        System.out.println("\t\t" + up.next());
                    }
                }

                System.out.print("Delete a Student: ");
                String delStudent = add.nextLine();
                System.out.println("You deleted " + delStudent);
                student.remove(delStudent);
                Iterator<String> del = student.iterator();
                while (del.hasNext()) {
                    System.out.println("\t\t" + del.next());
                }

                break;

            case 2:
                System.out.println("\n\tGroup 3 - Highest Grade Recorded");
                System.out.println("\t\t\t is " + grade.peek());

                Scanner addGrade = new Scanner(System.in);
                System.out.print("Add new students' grade: ");
                Double newGrade = addGrade.nextDouble();
                System.out.println(newGrade + " is added to the grades' list.");
                grade.add(newGrade);
                Iterator<Double> addG = grade.iterator();
                while (addG.hasNext()) {
                    System.out.println("\t\t" + addG.next());
                }
                
                Scanner retG = new Scanner(System.in);
                System.out.print("Retrieve Student Grade: ");
                Double retGrade = retG.nextDouble();
                if (grade.contains(retGrade)) {
                    System.out.println(retGrade + " is in list.");
                } else {
                    System.out.println(retGrade + " is not in list.");
                }
                grade.add(retGrade);
                
                

                break;

            case 3:
                System.out.println("\n\tGroup 3 - Courses Taking");
                courses.set(0, "*Java 2");
                Iterator<String> itr1 = courses.iterator();
                while (itr1.hasNext()) {
                    System.out.println("\t\t" + itr1.next());
                }

                break;

            default:
                System.out.println(choice + " is not a valid Menu Option! Please Select Another.");
        }

    }
}
