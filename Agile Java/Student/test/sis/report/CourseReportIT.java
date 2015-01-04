package sis.report;

import java.util.Date;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import static sis.report.RosterReporter.NEWLINE;
import sis.studentInfo.CourseSession;

public class CourseReportIT {

    @Test
    public void testReport() {
        final Date date = new Date();
        CourseReport report = new CourseReport();
        report.add(CourseSession.create("ENGL", "101", date));
        report.add(CourseSession.create("CZEC", "200", date));
        report.add(CourseSession.create("ITAL", "410", date));
        report.add(CourseSession.create("CZEC", "220", date));
        report.add(CourseSession.create("ITAL", "330", date));
        assertEquals(
                "CZEC 200" + NEWLINE
                + "CZEC 220" + NEWLINE
                + "ENGL 101" + NEWLINE
                + "ITAL 330" + NEWLINE
                + "ITAL 410" + NEWLINE,
                report.text());
    }

}
