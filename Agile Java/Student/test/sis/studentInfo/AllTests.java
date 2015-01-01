package sis.studentInfo;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
            sis.studentInfo.StudentIT.class, 
            sis.studentInfo.CourseSessionIT.class,
            sis.report.RosterReporterIT.class,
            sis.studentInfo.DateUtilIT.class
        })
public class AllTests {

    
}
