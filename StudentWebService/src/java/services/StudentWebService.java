/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import model.Student;
import controller.StudentTable;
import java.util.List;
import javax.jws.Oneway;

/**
 *
 * @author nemishappy
 */
@WebService(serviceName = "StudentWebService")
public class StudentWebService {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "findStudentbyId")
    public Student findStudentbyId(@WebParam(name = "id") int id) {
        //TODO write your implementation code here:
        return StudentTable.findStudentById(id);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "insertStudent")
    public void insertStudent(@WebParam(name = "name") String name, @WebParam(name = "gpa") double gpa) {
        //TODO write your implementation code here:
        Student stud = new Student();
        stud.setName(name);
        stud.setGpa(gpa);
        StudentTable.insertStudent(stud);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "updateStudent")
    public void updateStudent(@WebParam(name = "stud") Student stud) {
        //TODO write your implementation code here:
        StudentTable.updateStudent(stud);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteStudent")
    @Oneway
    public void deleteStudent(@WebParam(name = "id") Student stud) {
        StudentTable.removeStudent(stud);
    } 

    /**
     * Web service operation
     */
    @WebMethod(operationName = "findAllStudent")
    public List<Student> findAllStudent() {
        //TODO write your implementation code here:
        return StudentTable.findAllStudent();
    }
        
    
    /**
     * This is a sample web service operation
     */
    
}
