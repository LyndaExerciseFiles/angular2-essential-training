package utils;

import java.util.Calendar;

public class DateUtils {

    private static String currentDateString = "";
    private static final int END_OF_YEAR_POSITION = 4;
    private static final int END_OF_MONTH_POSITION = 6;
    private static final int END_OF_DAY_POSITION = 8;
    private static final int START_OF_YEAR_POSITION = 0;
    private static final int START_OF_MONTH_POSITION = 4;
    private static final int START_OF_DAY_POSITION = 6;

    private DateUtils() {
    }

    public static String getCurrentDateTime() {
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.YEAR) + "_" + (cal.get(Calendar.MONTH) + 1) + "_" + cal.get(Calendar.DAY_OF_MONTH) + "_" +
                cal.get(Calendar.HOUR_OF_DAY) + "_" + cal.get(Calendar.MINUTE) + "_" + cal.get(Calendar.SECOND);
    }

    public static String getCurrentDateStringStatic() {

        if (currentDateString == null || "".equals(currentDateString)) {
            Calendar cal = Calendar.getInstance();

            currentDateString +=
                    cal.get(Calendar.YEAR) + "_" + (cal.get(Calendar.MONTH) + 1) + "_"
                            + cal.get(Calendar.DAY_OF_MONTH) + "_" + cal.get(Calendar.HOUR_OF_DAY) + "_"
                            + cal.get(Calendar.MINUTE) + "_" + cal.get(Calendar.SECOND);
        }

        return currentDateString;
    }

    public static String getDateForErrorReportLocation(){
        String dateString = "";

        Calendar cal = Calendar.getInstance();

        dateString += cal.get(Calendar.DAY_OF_MONTH) + "-" + (cal.get(Calendar.MONTH) + 1) + "-"
                + cal.get(Calendar.YEAR);

        return dateString;
    }
}