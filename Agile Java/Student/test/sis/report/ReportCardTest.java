package sis.report;

import static org.junit.Assert.*;
import org.junit.Test;
import sis.studentInfo.Student;

/**
 *
 * @author marius
 */
public class ReportCardTest {

    public ReportCardTest() {
    }

    @Test
    public void testMessage() {
        ReportCard card = new ReportCard();
        assertEquals(ReportCard.A_MESSAGE,
                card.getMessage(Student.Grade.A));
        assertEquals(ReportCard.B_MESSAGE,
                card.getMessage(Student.Grade.B));
        assertEquals(ReportCard.C_MESSAGE,
                card.getMessage(Student.Grade.C));
        assertEquals(ReportCard.D_MESSAGE,
                card.getMessage(Student.Grade.D));
        assertEquals(ReportCard.F_MESSAGE,
                card.getMessage(Student.Grade.F));
    }

}
