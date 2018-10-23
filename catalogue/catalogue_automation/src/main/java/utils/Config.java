package utils;

import org.apache.commons.lang3.StringUtils;
import utils.exceptions.CommonAssert;
import utils.exceptions.ExceptionType;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Config {

    private static boolean useJobManagerButton = false;
    private static boolean overrideUseJobManagerButtonParameter = false;

    private Config() {
    }


    public static String getCheckSheetName1() {
        return System.getProperty("CheckSheetName1");
    }

    public static String getCheckSheetName2() {
        return System.getProperty("CheckSheetName2");
    }

    public static String getAppName() {
        return System.getProperty("AppName");
    }

    public static String getDriverType() {
        return System.getProperty("DriverType");
    }

    public static Integer getRepeatTime() {
        return Integer.valueOf(System.getProperty("RepeatTime"));
    }

    public static String getFranchiseName() {
        return System.getProperty("Franchise");
    }

    public static Boolean getIsLocalRun() {
        String isLocalRun = System.getProperty("IsLocalRun");
        if (isLocalRun != null) {
            return Boolean.valueOf(isLocalRun);
        } else {
            return false;
        }
    }

    public static String getBrand() {
        return System.getProperty("Brand");
    }

    public static String getDebugMode() {
        return System.getProperty("DebugMode");
    }

    public static String getSampleFileName() {
        return System.getProperty("SampleFileName");
    }

    public static String getRegion() {
        return System.getProperty("Region");
    }

    public static String getFileRegion() {
        return System.getProperty("FileRegion");
    }

    public static String getCurrentLiveDataVersion() {
        return System.getProperty("CurrentLiveDataVersion");
    }

    public static String getCustomerName() {
        return System.getProperty("CustomerName");
    }

    public static String getVinFilePath() {
        return System.getProperty("VinFilePath");
    }

    public static String getWorkflowForJob() {
        return System.getProperty("WorkflowForJob");
    }

    public static String getEnvironment() {
        return System.getProperty("Environment");
    }

    public static String getUsername() {
        String username = System.getProperty("Username");
        CommonAssert.assertTrue("'Username' parameter not supplied", username != null && username.length() > 0, ExceptionType.ASSERT);
        return username;
    }

    public static String getPassword() {
        String password = System.getProperty("Password");
        CommonAssert.assertTrue("'Password' parameter not supplied", password != null && password.length() > 0, ExceptionType.ASSERT);
        return password;
    }

    public static String getTempDirectory() {
        return System.getProperty("java.io.tmpdir");
    }

    public static String getEmailRecipients() {
        return System.getProperty("EmailRecipients");
    }

    public static String getFailedEmailRecipients() {
        return System.getProperty("FailedEmailRecipients");
    }

    public static String getActiveDataDirectory() {
        return System.getProperty("ActiveDataDirectory");
    }

    public static List<String> getMarketList() {
        String markets = System.getProperty("marketList");
        List<String> marketList = Arrays.asList(markets.split("\\s*,\\s*"));
        return marketList;
    }

    public static Integer getEndYear() {
        return Integer.valueOf(System.getProperty("EndYear"));
    }

    public static Integer getCutOffYear() {
        // specify the year you want to start getting samples from i.e. we want samples from 1997 onwards
        return Integer.valueOf(System.getProperty("CutOffYear"));
    }

    public static boolean isActiveDataLogEnabled() {
        return Boolean.valueOf(System.getProperty("PrintLogEnabled"));
    }

    public static boolean useDefaultSetting() {
        String useDefaultSetting = System.getProperty("UseDefaultSetting");
        if (useDefaultSetting != null) {
            return Boolean.valueOf(useDefaultSetting);
        } else {
            return true;
        }
    }

    public static String getApplicationUrl() {
        return System.getProperty("ApplicationURL");
    }

    public static boolean getCustomURL() {
        return Boolean.valueOf(System.getProperty("CustomURL"));
    }

    public static String getHarmonyUrl() {
        return System.getProperty("HarmonyURL");
    }

    public static String getLoginUrl() {
        return System.getProperty("LoginURL");
    }

    public static boolean getUseJobManagerButton() {
        if (!overrideUseJobManagerButtonParameter) {
            return Boolean.valueOf(System.getProperty("UseJobManagerButton"));
        } else {
            return useJobManagerButton;
        }
    }

    public static void setUseJobManagerButton(boolean useJobManagerButtonOverride) {
        overrideUseJobManagerButtonParameter = true;
        useJobManagerButton = useJobManagerButtonOverride;
    }

    public static boolean getUseLozenge() {
        return Boolean.valueOf(System.getProperty("UseLozenge"));
    }

    public static boolean getUseLandingPage() {
        return Boolean.valueOf(System.getProperty("UseLandingPage"));
    }

    public static String getBrowser() {
        return System.getProperty("Browser");
    }

    public static String getApplicationLanguage() {
        return System.getProperty("ApplicationLanguage");
    }

    public static String getDataDescriptionLanguage() {
        return System.getProperty("DataDescriptionLanguage");
    }

    public static String getDateFormat() {
        return System.getProperty("DateFormat");
    }

    public static String getTestType() {
        return System.getProperty("TestType");
    }

    public static String getProductCode() {
        return System.getProperty("ProductCode") == null ? "SST" : System.getProperty("ProductCode");
    }

    public static boolean getIsRunOnTouchScreen() {
        return System.getProperty("IsRunOnTouchScreen") == null ? false : Boolean.valueOf(System.getProperty("IsRunOnTouchScreen"));
    }

    public static int getMaxSample() {
        String maxSample = System.getProperty("MaxSample");
        if (StringUtils.isNumeric(maxSample)){
            return Integer.valueOf(maxSample);
        } else {
            return Integer.MAX_VALUE;
        }
    }

    public static String getDynamicsUsername() {
        String username = System.getProperty("DynamicsUsername");
        CommonAssert.assertTrue("Dynamics 'Username' parameter not supplied", username != null && username.length() > 0, ExceptionType.ASSERT);
        return username;
    }

    public static String getDynamicsPassword() {
        String password = System.getProperty("DynamicsPassword");
        CommonAssert.assertTrue("Dynamics 'Password' parameter not supplied", password != null && password.length() > 0, ExceptionType.ASSERT);
        return password;
    }

    public static int getStartNumber() {
        String start = System.getProperty("StartNumber");
        CommonAssert.assertTrue("'StartNumber' parameter not supplied or supplied incorrectly", start != null && start.length() > 0 && start.matches("[0-9]+"), ExceptionType.ASSERT);
        return Integer.parseInt(start);
    }

    public static int getEndNumber() {
        String end = System.getProperty("EndNumber");
        CommonAssert.assertTrue("'EndNumber' parameter not supplied or supplied incorrectly", end != null && end.length() > 0 && end.matches("[0-9]+"), ExceptionType.ASSERT);
        return Integer.parseInt(end);
    }

    public static boolean getIsJapCatalogue(){
        // AL 11/10/2013 - to select the data source combo item
        return Boolean.valueOf(System.getProperty("IsJAPCatalogue"));
    }

    public static Map<String, String> getAllParameters(){
        Map<String,String> params = new HashMap<String, String>();
        params.put("Browser", getBrowser());
        params.put("Environment", getEnvironment());
        params.put("Franchise", getFranchiseName());
        params.put("Region", getRegion());
        params.put("LoginUrl", getLoginUrl());
        params.put("ApplicationUrl", getApplicationUrl());
        params.put("ProductCode", getProductCode());
        params.put("ActiveDataDirectory", getActiveDataDirectory());
        params.put("ApplicationLanguage", getApplicationLanguage());
        params.put("DataDescriptionLanguage", getApplicationLanguage());
        return params;
    }

    public static Map<String, String> getAllParametersForEmails(){
        Map<String,String> params = new HashMap<String, String>();
        params.put("DriverType", getDriverType());
        params.put("LoginUrl", getLoginUrl());
        params.put("HarmonyUrl", getHarmonyUrl());
        params.put("ApplicationUrl", getApplicationUrl());
        params.put("ProductCode", getProductCode());
        params.put("ActiveDataDirectory", getActiveDataDirectory());
        params.put("ErrorReportFilePath", getErrorReportFilePath());
        params.put("EmailRecipients", getEmailRecipients());
        return params;
    }

    public static boolean isOnline() {
        String isOnline = System.getProperty("isOnline");
        if ("false".equalsIgnoreCase(isOnline)){
            return false;
        } else{
            return true;
        }
    }

    public static String getCatalogFileName() {
        String catalogFileName = System.getProperty("CatalogFileName");
        if (StringUtils.isEmpty(catalogFileName)) {
            return "allRegionCheckCatalogueMarket";
        } else {
            return catalogFileName;
        }
    }

    public static String getVinFileName() {
        String vinFileName = System.getProperty("VinFileName");
        if (StringUtils.isEmpty(vinFileName)) {
            return "fullVinSearchStatic";
        } else {
            return vinFileName;
        }
    }

    public static String getErrorReportFilePath() {
        return System.getProperty("ErrorReportFilePath");
    }

    public static String getDialogScriptFilePath() {
        return System.getProperty("DialogScriptFilePath");
    }

    public static String readEncoding() {
        if (System.getProperty("ReadEncoding") != null) {
            return System.getProperty("ReadEncoding");
        } else {
            return "UTF-16";
        }
    }

    public static boolean getSendStartEmail() {
        return "TRUE".equalsIgnoreCase(System.getProperty("SendStartEmail"));
    }

    public static boolean getSendEmailForFailedTestOnly() {
        String value = System.getProperty("SendEmailForFailedTestOnly");
        if (value == null) {
            return true;
        } else return "TRUE".equalsIgnoreCase(value);
    }

    public static String getReportFilePath() {
        if (System.getProperty("ReportFilePath").endsWith("\\")) {
            return System.getProperty("ReportFilePath");
        } else {
            return System.getProperty("ReportFilePath") + "\\";
        }
    }

    public static String getPerformanceBaselineFilename() {
        return System.getProperty("PerformanceBaselineFilename");
    }

    public static boolean getSendPassEmail() {
        return !"FALSE".equalsIgnoreCase(System.getProperty("SendPassEmail"));
    }

    public static String getMobileDeviceName() {
        return System.getProperty("MobileDeviceName");
    }

    public static boolean isUseRealMobileDevice() {
        return "TRUE".equalsIgnoreCase(System.getProperty("UseRealMobileDevice"));
    }

    public static String getMobilePlatformVersion() {
        return System.getProperty("MobilePlatformVersion");
    }

    public static String getMobileDeviceIdentifier() {
        return System.getProperty("MobileDeviceIdentifier");
    }

    public static String getXCodeOrganizationId() {
        return System.getProperty("XCodeOrganizationId");
    }

    public static boolean isSkipJavascriptErrorCheckOnClick() {
        return "TRUE".equalsIgnoreCase(System.getProperty("SkipJavascriptErrorCheckOnClick"));
    }

    /**
     *  Due to an unknown reason, Open File Dialog lost focus in test server.
     *  Use CMDOW to reclaim Open File dialog focus. Download CMDOW from https://ritchielawrence.github.io/cmdow/
     * @return
     */
    public static String getCmdowPath() {
        return System.getProperty("CmdowPath");
    }
}

