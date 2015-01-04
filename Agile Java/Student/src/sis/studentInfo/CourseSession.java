package sis.studentInfo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class CourseSession implements Comparable<CourseSession> {

    private static final short COURSE_LENGTH_WEEKS = 16;
    private static int count;
    private final String department;
    private final String number;
    private final List<Student> students = new ArrayList<>();
    private final Date startDate;
    private int credits;

    static public CourseSession create(String department, String number, Date startDate) {
        incrementCount();
        return new CourseSession(department, number, startDate);
    }

    static void resetCount() {
        CourseSession.count = 0;
    }

    static int getCount() {
        return CourseSession.count;
    }

    private CourseSession(String department, String number, Date startDate) {
        this.department = department;
        this.number = number;
        this.startDate = (Date) startDate.clone();
    }

    static private void incrementCount() {
        CourseSession.count++;
    }

    public String getNumber() {
        return this.number;
    }

    public String getDepartment() {
        return this.department;
    }

    public void enroll(Student student) {
        students.add(student);
        student.addCredit(credits);
    }

    public int size() {
        return students.size();
    }

    public Student get(int index) {
        return students.get(index);
    }

    public Date getEndDate() {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(startDate);
        calendar.add(Calendar.WEEK_OF_YEAR, COURSE_LENGTH_WEEKS);
        calendar.add(Calendar.DAY_OF_MONTH, -3);
        return calendar.getTime();
    }

    public Date getStartDate() {
        return (Date) startDate.clone();
    }

    public List<Student> getAllStudents() {
        return students;
    }

    void setNumberOfCredits(int credits) {
        this.credits = credits;
    }

    @Override
    public int compareTo(CourseSession o) {
        int compareDepartments = department.compareTo(o.department);
        if (compareDepartments != 0)
            return compareDepartments;

        return number.compareTo(o.number);
    }

}
