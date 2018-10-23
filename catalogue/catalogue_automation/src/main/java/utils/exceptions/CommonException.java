package utils.exceptions;

import org.apache.log4j.Logger;
import utils.CommonUtil;

import java.util.Calendar;

public class CommonException extends Exception {

    public String type;
    public String sampleInfo;
    public String dateTime;

    public Logger log;

    public CommonException () {}

    public CommonException (String msg) {
        super(msg);
        dateTime = getCurrentDateTime();
        log = Logger.getLogger(this.getClass());
        CommonUtil.appendSampleInfo(log, msg + " - FAIL");
    }

    public String getSampleInfo() {
        return sampleInfo;
    }

    public void setSampleInfo(String sampleInfo) {
        this.sampleInfo = sampleInfo;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getType() {
        return type;
    }

    private static String getCurrentDateTime() {
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.DAY_OF_MONTH) + "/" + (cal.get(Calendar.MONTH) + 1) + "/"
                + cal.get(Calendar.YEAR) + "  " + cal.get(Calendar.HOUR_OF_DAY) + ":"
                + cal.get(Calendar.MINUTE) + ":" + cal.get(Calendar.SECOND);
    }

    public static void applicationTestErrorHandling(String errorMessage) {
        CommonException commonException = new AssertException(errorMessage);
        commonException.setSampleInfo(CommonExceptionHandler.getSampleInfo());
        CommonExceptionHandler.handleException(commonException);
    }

}
