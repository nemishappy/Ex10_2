/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this tstudlate file, choose Tools | Tstudlates
 * and open the tstudlate in the editor.
 */
package ex10_client2;

import java.util.List;
import java.util.Scanner;
import servicedclient.Student;

/**
 *
 * @author nemishappy
 */
public class Ex10_Client2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Boolean isDone = false;
        String name;
        int id;
        double gpa;

        do {
            System.out.println("==== Student DBMS lite ==== ");
            System.out.println("1.View All Student.");
            System.out.println("2.Insert Student.");
            System.out.println("3.Update Student.");
            System.out.println("4.Delete Student.");
            System.out.println("0.Exit.");
            System.out.println("============================ ");
            int i = sc.nextInt();
            switch (i) {
                case 0:
                    isDone = true;
                    break;
                case 1:
                    printAllStudent(findAllStudent());
                    break;
                case 2:
                    sc.nextLine();
                    System.out.println("Enter Student Name:");
                    name = sc.nextLine();
                    System.out.println("Enter Gpa:");
                    gpa = sc.nextDouble();
                    insertStudent(name, gpa);

                    System.out.println("Successful.");
                    break;
                case 3:
                    System.out.println("Enter Student ID:");
                    id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter New Student Name:");
                    name = sc.nextLine();
                    System.out.println("Enter new Gpa:");
                    gpa = sc.nextDouble();
                    if (updateStudent(id, name, gpa)) {
                        System.out.println("Successful.");
                    } else {
                        System.out.println("Not found.");
                    }
                    

                    System.out.println("Successful.");
                    break;
                case 4:
                    System.out.println("Enter Student ID:");
                    id = sc.nextInt();
                    sc.nextLine();
                    if (deleteStudent(id)) {
                        System.out.println("Successful.");
                    } else {
                        System.out.println("Not found.");
                    }
                    break;
                default:
                    System.out.println("Please enter number 0-4");
            }
            System.out.println("============================ ");
        } while (!isDone);

    }

    public static void printAllStudent(List<Student> studentList) {
        for (Student stu : studentList) {
            System.out.print(stu.getId() + " ");
            System.out.print(stu.getName() + " ");
            System.out.println(stu.getGpa() + " ");
        }
    }

    private static Student findStudentbyId(int id) {
        servicedclient.StudentWebService_Service service = new servicedclient.StudentWebService_Service();
        servicedclient.StudentWebService port = service.getStudentWebServicePort();
        return port.findStudentbyId(id);
    }

    private static List<Student> findAllStudent() {
        servicedclient.StudentWebService_Service service = new servicedclient.StudentWebService_Service();
        servicedclient.StudentWebService port = service.getStudentWebServicePort();
        return port.findAllStudent();
    }

    private static void insertStudent(String name, double gpa) {
        servicedclient.StudentWebService_Service service = new servicedclient.StudentWebService_Service();
        servicedclient.StudentWebService port = service.getStudentWebServicePort();
        port.insertStudent(name, gpa);
    }

    private static boolean updateStudent(int id,String name, double gpa) {
        servicedclient.StudentWebService_Service service = new servicedclient.StudentWebService_Service();
        servicedclient.StudentWebService port = service.getStudentWebServicePort();
        Student stud = findStudentbyId(id);
        if (stud != null) {
            stud.setName(name);
            stud.setGpa(gpa);
            port.updateStudent(stud);
        }else{
            return false;
        }
        return true;
    }

    private static boolean deleteStudent(int id) {
        servicedclient.StudentWebService_Service service = new servicedclient.StudentWebService_Service();
        servicedclient.StudentWebService port = service.getStudentWebServicePort();
        Student stud = findStudentbyId(id);
        if (stud != null) {
            port.deleteStudent(stud);
        } else {
            return false;
        }
        return true;
    }

}
