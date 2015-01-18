package sis.summer;

import java.util.Date;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import sis.studentInfo.DateUtil;
import sis.studentInfo.Session;
import sis.studentInfo.SessionTest;

public class SummerCourseSessionTest extends SessionTest {

    public SummerCourseSessionTest() {
    }

    @Test
    public void testEndDate() {
        Date startDate = DateUtil.createDate(2003, 6, 9);
        Session session = createSession("ENGL", "200", startDate);
        Date eightWeeksOut = DateUtil.createDate(2003, 8, 1);
        assertEquals(eightWeeksOut, session.getEndDate());
    }

    @Override
    protected Session createSession(String department, String number, Date startDate) {
        return SummerCourseSession.create(department, number, startDate);
    }
}
