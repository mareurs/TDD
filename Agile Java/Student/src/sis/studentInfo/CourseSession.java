package sis.studentInfo;

import java.util.Date;

public class CourseSession extends Session {

    private static final short COURSE_LENGTH_WEEKS = 16;

    private static int count;

    static public CourseSession create(String department, String number, Date startDate) {
        incrementCount();
        return new CourseSession(department, number, startDate);
    }

    protected CourseSession(String department, String number, Date startDate) {
        super(department, number, startDate);
    }

    static void resetCount() {
        CourseSession.count = 0;
    }

    static int getCount() {
        return CourseSession.count;
    }

    static private void incrementCount() {
        CourseSession.count++;
    }

    @Override
    protected int getSessionLength() {
        return COURSE_LENGTH_WEEKS;
    }

}
