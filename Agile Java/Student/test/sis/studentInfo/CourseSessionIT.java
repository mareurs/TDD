package sis.studentInfo;

import java.util.Date;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class CourseSessionIT {

    static private final int CREDITS = 3;

    private final CourseSession session;
    private final Date startDate;

    public CourseSessionIT() {
        startDate = DateUtil.createDate(2003, 1, 6);
        session = createCourseSession();
    }

    @Before
    public void setUp() {
    }

    @Test
    public void testCreate() {
        assertEquals("ENGL", session.getDepartment());
        assertEquals("101", session.getNumber());
        assertEquals(0, session.size());
        assertEquals(startDate, session.getStartDate());
    }

    @Test
    public void testEnrollStudents() {
        Student student1 = new Student("Anca");
        session.enroll(student1);
        assertEquals(1, session.size());
        assertEquals(CREDITS, student1.getCredits());

        Student student2 = new Student("Marius");
        session.enroll(student2);
        assertEquals(2, session.size());
        assertEquals(CREDITS, student1.getCredits());

        assertEquals(student1, session.get(0));
        assertEquals(student2, session.get(1));
    }

    @Test
    public void testCourseDates() {
        Date endDate = DateUtil.createDate(2003, 4, 25);
        assertEquals(endDate, session.getEndDate());
    }

    @Test
    public void testCount() {
        CourseSession.resetCount();
        createCourseSession();
        assertEquals(1, CourseSession.getCount());
        createCourseSession();
        assertEquals(2, CourseSession.getCount());
    }

    public void testComparable() {
        final Date date = new Date();
        CourseSession sessionA = CourseSession.create("CMSC", "101", date);
        CourseSession sessionB = CourseSession.create("ENGL", "101", date);
        assertTrue(sessionA.compareTo(sessionB) < 0);
        assertTrue(sessionB.compareTo(sessionA) > 0);
        CourseSession sessionC = CourseSession.create("CMSC", "101", date);
        assertEquals(0, sessionA.compareTo(sessionC));
    }

    /*
     Privates
     */
    private CourseSession createCourseSession() {
        CourseSession result = CourseSession.create("ENGL", "101", startDate);
        result.setNumberOfCredits(CourseSessionIT.CREDITS);
        return result;
    }

}
