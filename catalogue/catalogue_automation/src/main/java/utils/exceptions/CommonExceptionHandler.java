package utils.exceptions;

import jxl.write.WriteException;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import utils.Config;
import utils.Constant;
import utils.DateUtils;

import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommonExceptionHandler {
    private static Logger log = Logger.getLogger(CommonExceptionHandler.class);

    private static List<ExceptionRecord> errorRecordList = new ArrayList<ExceptionRecord>();

    private static String testName;

    private static String errorReportFilePath;

    private static StringBuilder sampleInfoBuilder = new StringBuilder();

    public static String getSampleInfo() {
        return sampleInfoBuilder.toString();
    }

    public static void appendSampleInfo(String sampleInfo) {
        sampleInfoBuilder.append(sampleInfo).append(Constant.NEW_LINE);
    }

    public static void clearSampleInfo() {
        sampleInfoBuilder = new StringBuilder();
    }

    public static void clearExceptions() {
        errorRecordList = new ArrayList<ExceptionRecord>();
    }

//    public static void setSampleInfo(String sampleInfo) {
//        IfmExceptionHandler.sampleInfo = sampleInfo;
//    }

    public static void setTestName(String testNameParam) {
        testName = testNameParam;
    }

    public static void setErrorReportFilePath(String errorReportFile) {
        errorReportFilePath = errorReportFile;
    }

    public static String getErrorReportFilePath() {
        return errorReportFilePath;
    }

    public static String getTestName() {
        return testName;
    }

    public static boolean hasException() {
        return errorRecordList.size() > 0;
    }

    /**
     * Export the error records out to excel file
     */
    public static void createErrorReport () throws WriteException, IOException {
        String reportFolder = Config.getErrorReportFilePath();
        List<String> colHeaders = new ArrayList<String>(Arrays.asList(new String[]{"Sample Information",
                "Exception Type",
                "Exception category",
                "Exception Message",
                "Expected Value",
                "Actual Value",
                "Date Time"}));

        if (createDir(reportFolder)) {
            String reportFile = reportFolder + "\\" + testName + "ExceptionReport" + DateUtils.getCurrentDateTime() + ".xls";
            WriteExcel writeExcel = new WriteExcel(reportFile);
            log.info("Error report is generated: " + reportFile);
            setErrorReportFilePath(reportFile);

            writeExcel.openWorkBook();

            writeExcel.writeHeaderRow(colHeaders);
            for (ExceptionRecord exRecord : errorRecordList) {
                String[] content = {exRecord.getSampleInfo(),
                        exRecord.getType(),
                        exRecord.getCategory(),
                        exRecord.getMessage(),
                        exRecord.getExpectedValue(),
                        exRecord.getActualValue(),
                        exRecord.getDateTime()};
                writeExcel.writeContent(content);
            }
            writeExcel.write();
            writeExcel.close();
        } else {
            log.error("Error report directory " + reportFolder + " could not be created, thus report was not saved.\n\n");
            log.info(StringUtils.join(colHeaders, "|"));
            for (ExceptionRecord exRecord : errorRecordList) {
                log.info(exRecord.getSampleInfo() + "|" +
                        exRecord.getType() + "|" +
                        exRecord.getCategory() + "|" +
                        exRecord.getMessage() + "|" +
                        exRecord.getExpectedValue() + "|" +
                        exRecord.getActualValue() + "|" +
                        exRecord.getDateTime());
            }
        }
    }

    public static void handleException(CommonException cmEx) {
        ExceptionRecord exceptionRecord = new ExceptionRecord();
        exceptionRecord.setType(cmEx.getType());
        exceptionRecord.setSampleInfo(sampleInfoBuilder.toString());
        exceptionRecord.setMessage(cmEx.getMessage());
        if (cmEx instanceof AssertException){
            exceptionRecord.setCategory(((CommonAssertException) cmEx).getCategory());
        } else if (cmEx instanceof AssertException){
            exceptionRecord.setExpectedValue(((CommonVerificationException) cmEx).getExpectedValue());
            exceptionRecord.setActualValue(((CommonVerificationException) cmEx).getActualValue());
        }
        errorRecordList.add(exceptionRecord);
    }

    public static String getStackTrace(Throwable throwable) {
        Writer writer = new StringWriter();
        PrintWriter printWriter = new PrintWriter(writer);
        throwable.printStackTrace(printWriter);
        return writer.toString();
    }

    private static String getHostName() {
        InetAddress addr;
        try {
            addr = InetAddress.getLocalHost();
            return addr.getHostName();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static boolean createDir(String dirName) {
        boolean success = false;
        try {
            if ((new File(dirName)).exists()) {
                success = true;
            } else {
                success = (new File(dirName)).mkdirs();
                if (success) {
                    log.debug("Directories: " + dirName + " created");
                }
            }

        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return success;
    }
}
