package sis.report;

import java.util.ArrayList;
import java.util.Collections;
import static sis.report.RosterReporter.NEWLINE;
import sis.studentInfo.CourseSession;

class CourseReport {

    private final ArrayList<CourseSession> sessions = new ArrayList<>();

    void add(CourseSession session) {
        sessions.add(session);
    }

    public String text() {
        Collections.sort(sessions);
        StringBuilder builder = new StringBuilder();
        for (CourseSession session : sessions)
            builder.append(session.getDepartment()).append(" ").
                    append(session.getNumber()).append(NEWLINE);
        return builder.toString();
    }

}
