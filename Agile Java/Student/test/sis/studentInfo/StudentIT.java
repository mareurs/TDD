/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sis.studentInfo;

import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

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

    @Test
    public void testStudentStatus() {
        Student student = new Student("a");

        assertEquals(0, student.getCredits());
        assertFalse(student.isFullTime());

        student.addCredit(3);
        assertEquals(3, student.getCredits());
        assertFalse(student.isFullTime());

        student.addCredit(4);
        assertEquals(7, student.getCredits());
        assertFalse(student.isFullTime());

        student.addCredit(5);
        assertEquals(Student.CREDITS_REQUIRED_FOR_FULL_TIME, student.getCredits());
        assertTrue(student.isFullTime());
    }

    @Test
    public void testInState() {
        Student student = new Student("a");
        assertFalse(student.isInState());
        student.setState(Student.IN_STATE);
        assertTrue(student.isInState());
        student.setState("MD");
        assertFalse(student.isInState());
    }

}
