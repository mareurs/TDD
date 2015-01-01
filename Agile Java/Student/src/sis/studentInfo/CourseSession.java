package sis.studentInfo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class CourseSession {
    private static final short COURSE_LENGTH_WEEKS = 16;

    private final String department;
    private final int number;
    private final List<Student> students = new ArrayList<>();
    private final Date startDate;

    public CourseSession(String department, int number, Date startDate) {
        this.department = department;
        this.number = number;
        this.startDate = startDate;
    }

    public int getNumber() {
        return this.number;
    }

    public String getDepartment()
    {
        return this.department;
    }

    public void enroll(Student student) {
        students.add(student);
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
        return startDate;
    }
    
    public List<Student> getAllStudents()
    {
        return students;
    }
    
}

