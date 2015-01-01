package sis.studentInfo;

import sis.studentInfo.DateUtil;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import org.junit.Test;
import static org.junit.Assert.*;

public class DateUtilIT {

    public DateUtilIT() {
    }

    @Test
    public void testCreateDate() {
        Date date = DateUtil.createDate(2000, 1, 1);
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        assertEquals(2000, calendar.get(Calendar.YEAR));
        assertEquals(Calendar.JANUARY, calendar.get(Calendar.MONTH));
        assertEquals(1, calendar.get(Calendar.DAY_OF_MONTH));
    }

}