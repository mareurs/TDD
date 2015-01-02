package sis.report;

import java.util.Date;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import sis.studentInfo.CourseSession;
import sis.studentInfo.Student;

public class RosterReporterIT {

    public RosterReporterIT() {
    }

    @Test
    public void testCreate() {
        CourseSession session = CourseSession.create("ENG", 101, new Date());
        RosterReporter report = new RosterReporter(session);
        session.enroll(new Student("A"));
        session.enroll(new Student("B"));
        System.out.println(report.getReport());
        assertEquals(
                RosterReporter.ROSTER_REPORT_HEADER
                + "A" + RosterReporter.NEWLINE
                + "B" + RosterReporter.NEWLINE
                + RosterReporter.ROSTER_REPORT_FOOTER
                + "2" + RosterReporter.NEWLINE, report.getReport());
    }

}
