package sis.studentInfo;

import java.util.Date;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class CourseSessionTest extends SessionTest {

    static private final int CREDITS = 3;

    private final Session session;
    private final Date startDate;

    public CourseSessionTest() {
        startDate = DateUtil.createDate(2003, 1, 6);
        session = createSession();
    }

    @Before
    public void setUp() {
    }

    @Test
    public void testCourseDates() {
        Date endDate = DateUtil.createDate(2003, 4, 25);
        assertEquals(endDate, session.getEndDate());
    }

    @Test
    public void testCount() {
        CourseSession.resetCount();
        createSession();
        assertEquals(1, CourseSession.getCount());
        createSession();
        assertEquals(2, CourseSession.getCount());
    }

    @Override
    protected Session createSession(String department, String number, Date startDate) {
        Session result = CourseSession.create(department, number, startDate);
        result.setNumberOfCredits(CourseSessionTest.CREDITS);
        return result;
    }

    /*
     Privates
     */
    private Session createSession() {
        return CourseSession.create("ENGL", "101", startDate);
    }
}
