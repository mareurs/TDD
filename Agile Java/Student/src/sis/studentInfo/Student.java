package sis.studentInfo;

public class Student {

    static final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;
    static final String IN_STATE = "CO";

    private final String name;
    private int credits;
    private String state = "";

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

}
