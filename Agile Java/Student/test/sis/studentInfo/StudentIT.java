/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sis.studentInfo;

import sis.studentInfo.Student;
import java.awt.SecondaryLoop;
import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StudentIT {
    
    public StudentIT() {
    }
    
    @Before
    public void setUp() {
    } 
   
    @After
    public void tearDown() {
    }

    @Test
    public void createStudent() {
        final String firstStudentName = "John Doe";
        Student firstStudent = new Student(firstStudentName);
        assertThat(firstStudentName, is(firstStudent.getName()));
        
        final String seconfStudentName = "Jane Doe";
        Student secondStudent = new Student(seconfStudentName);
        assertThat(seconfStudentName, is(secondStudent.getName()));
    }
    
}
