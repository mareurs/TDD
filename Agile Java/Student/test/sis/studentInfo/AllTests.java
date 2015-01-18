package sis.studentInfo;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import sis.report.RosterReporterIT;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
            StudentTest.class,
            CourseSessionTest.class,
            RosterReporterIT.class,
            DateUtilTest.class,
            BasicGradingStrategyTest.class,
            HonorsGradingStrategyTest.class
        })
public class AllTests {

}
