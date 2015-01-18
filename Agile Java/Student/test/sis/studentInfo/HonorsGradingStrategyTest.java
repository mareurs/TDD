package sis.studentInfo;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author marius
 */
public class HonorsGradingStrategyTest {

    public HonorsGradingStrategyTest() {
    }

    @Test
    public void testGetGradePoints() {
        GradingStrategy strategy = new HonorsGradingStrategy();
        assertEquals(5, strategy.getGradePointsFor(Student.Grade.A));
        assertEquals(4, strategy.getGradePointsFor(Student.Grade.B));
        assertEquals(3, strategy.getGradePointsFor(Student.Grade.C));
        assertEquals(2, strategy.getGradePointsFor(Student.Grade.D));
        assertEquals(0, strategy.getGradePointsFor(Student.Grade.F));
    }
}
