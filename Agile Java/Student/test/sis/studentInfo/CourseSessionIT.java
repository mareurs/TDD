package sis.studentInfo;

import sis.studentInfo.CourseSession;
import sis.studentInfo.DateUtil;
import sis.studentInfo.Student;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class CourseSessionIT {
    
    private final CourseSession session;
    private final Date startDate;

    
    public CourseSessionIT() {
        startDate = DateUtil.createDate(2003, 1, 6);
        session = new CourseSession("ENGL", 101, startDate);
    }
    
    @Before
    public void setUp()
    {
    }
    
    @Test
    public void testCreate() {
        assertEquals("ENGL", session.getDepartment());
        assertEquals(101, session.getNumber());
        assertEquals(0, session.size());
        assertEquals(startDate, session.getStartDate());
    }
    
    @Test
    public void testEnrollStudents(){        
        Student student1 = new Student("Anca");
        session.enroll(student1);
        assertEquals(1, session.size());
        
        Student student2 = new Student("Marius");
        session.enroll(student2);
        assertEquals(2, session.size());
        
        assertEquals(student1, session.get(0));
        assertEquals(student2, session.get(1));                
    }
    
    @Test
    public void testCourseDates()
    {
        Date endDate = DateUtil.createDate(2003, 4, 25);        
        assertEquals(endDate, session.getEndDate());
    }
    
    
    /*
    Privates
    */
        
}
