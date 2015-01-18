package sis.studentInfo;

import java.util.ArrayList;
import java.util.List;

public class Student {

    static final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;
    static final String IN_STATE = "CO";

    public static enum Grade {

        A(4), B(3), C(2), D(1), F(0);

        private final int points;

        Grade(int points) {
            this.points = points;
        }

        int getPoints() {
            return points;
        }
    };

    private final String name;
    private int credits;
    private String state = "";
    private final List<Grade> grades = new ArrayList<>();
    private GradingStrategy gradingStrategy = new BasicGradingStrategy();

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

    void addCredits(int addedCredits) {
        this.credits += addedCredits;
    }

    boolean isInState() {
        return state.equals(IN_STATE);
    }

    void setState(String state) {
        this.state = state;
    }

    double getGpa() {
        if (grades.isEmpty()) {
            return 0.0;
        }
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
