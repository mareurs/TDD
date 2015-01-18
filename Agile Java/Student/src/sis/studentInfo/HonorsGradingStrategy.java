package sis.studentInfo;

public class HonorsGradingStrategy extends BasicGradingStrategy {

    @Override
    public int getGradePointsFor(Student.Grade grade) {
        int points = super.getGradePointsFor(grade);
        if (points > 0)
            return points + 1;
        return points;
    }

}
