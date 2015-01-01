package sis.report;

import sis.studentInfo.CourseSession;
import sis.studentInfo.Student;

public class RosterReporter {
    static final String NEWLINE = System.getProperty("line.separator");
    static final String ROSTER_REPORT_HEADER = "Student" + NEWLINE + "-" + NEWLINE;
    static final String ROSTER_REPORT_FOOTER = NEWLINE + "# students = ";

    private final CourseSession session;
    
    RosterReporter(CourseSession session) {
        this.session = session;
    }

    public String getReport() {
        StringBuilder result = new StringBuilder();

        writeHeader(result);
        writeBody(result);
        writeFooter(result);
        
        return result.toString();
    }

    private void writeFooter(StringBuilder result) {
        result.append(ROSTER_REPORT_FOOTER);
        result.append(session.size()).append(NEWLINE);
    }

    private void writeBody(StringBuilder result) {
        for(Student student:session.getAllStudents())
            result.append(student.getName()).append(NEWLINE);
    }

    private void writeHeader(StringBuilder result) {
        result.append(ROSTER_REPORT_HEADER);
    }

}

