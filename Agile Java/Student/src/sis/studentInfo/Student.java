package sis.studentInfo;

import java.util.ArrayList;
import java.util.List;

public class Student {

    static final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;
    static final String IN_STATE = "CO";

    public static enum Grade {

        A, B, C, D, E, F
    };

    private final String name;
    private int credits;
    private String state = "";
    private final List<Grade> grades = new ArrayList<>();
    private GradingStrategy gradingStrategy = new RegularGradingStrategy();

    public Student(String name) {
        this.name = name;
        credits = 0;
    }

    public String getName() {
        return name;
    }

    boolean isFullTime() {
        return credits >= CREDITS_REQUIRED_FOR_FULL_TIME;
    }

    int getCredits() {
        return credits;
    }

    void addCredit(int addedCredits) {
        this.credits += addedCredits;
    }

    boolean isInState() {
        return state.equals(IN_STATE);
    }

    void setState(String state) {
        this.state = state;
    }

    double getGpa() {
        if (grades.isEmpty())
            return 0.0;
        double total = 0.0;
        for (Grade grade : grades) {
            total += gradingStrategy.getGradePointsFor(grade);
        }
        return total / grades.size();
    }

    void addGrade(Grade grade) {
        grades.add(grade);
    }

    void setGradingStrategy(GradingStrategy gradingStrategy) {
        this.gradingStrategy = gradingStrategy;
    }

}
