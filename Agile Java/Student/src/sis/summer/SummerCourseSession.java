package sis.summer;

import java.util.Date;
import sis.studentInfo.Session;

public class SummerCourseSession extends Session {

    private static final int SUMMER_SESSION_COURSE_LENGTH = 8;

    static public SummerCourseSession
            create(String department, String number, Date startDate) {
        return new SummerCourseSession(department, number, startDate);
    }

    protected SummerCourseSession(String department, String number, Date startDate) {
        super(department, number, startDate);
    }

    @Override
    protected int getSessionLength() {
        return SUMMER_SESSION_COURSE_LENGTH;
    }

}
