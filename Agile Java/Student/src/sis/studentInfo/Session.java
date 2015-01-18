package sis.studentInfo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

abstract public class Session implements Comparable<Session> {

    private static final int DAYS_FROM_FRIDAY_TO_MONDAY = 3;
    private static final int DAYS_IN_WEEK = 7;

    private final String department;
    private final String number;
    private final List<Student> students = new ArrayList<>();
    private final Date startDate;
    private int numberOfCredits;

    abstract protected int getSessionLength();

    protected Session(
            String department, String number, Date startDate) {
        this.department = department;
        this.number = number;
        this.startDate = startDate;
    }

    public int size() {
        return students.size();
    }

    void setNumberOfCredits(int numberOfCredits) {
        this.numberOfCredits = numberOfCredits;
    }

    public String getDepartment() {
        return department;
    }

    public String getNumber() {
        return number;
    }

    int getNumberOfStudents() {
        return students.size();
    }

    public void enroll(Student student) {
        student.addCredits(numberOfCredits);
        students.add(student);
    }

    Student get(int index) {
        return students.get(index);
    }

    protected Date getStartDate() {
        return startDate;
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public Date getEndDate() {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(getStartDate());
        final int daysInWeek = DAYS_IN_WEEK;
        final int daysFromFridayToMonday = DAYS_FROM_FRIDAY_TO_MONDAY;
        int numberOfDays
                = getSessionLength() * daysInWeek - daysFromFridayToMonday;
        calendar.add(Calendar.DAY_OF_YEAR, numberOfDays);
        return calendar.getTime();
    }

    @Override
    public int compareTo(Session that) {
        int compare = this.getDepartment().compareTo(that.getDepartment());
        if (compare != 0) {
            return compare;
        }

        return this.getNumber().compareTo(that.getNumber());
    }

}
