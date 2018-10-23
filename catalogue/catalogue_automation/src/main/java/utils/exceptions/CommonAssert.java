package utils.exceptions;

import org.junit.Assert;

public class CommonAssert {

    public static void assertTrue(String message, boolean condition, ExceptionType type) {
        try {
            Assert.assertTrue(message, condition);

        } catch (AssertionError assertionError) {
            CommonException ifmException = null;
            switch (type){
                case ASSERT:
                    ifmException = new CommonAssertException(assertionError.getMessage());
                    break;
                case VERIFICATION:
                    ifmException = new CommonVerificationException(assertionError.getMessage());
                    break;
            }
            CommonExceptionHandler.handleException(ifmException);
        }
    }

    public static void assertTrueStopTest(String message, boolean condition, ExceptionType type) throws CommonException {
        try {
            Assert.assertTrue(message, condition);
        } catch (AssertionError assertionError) {
            CommonException cmException = null;
            switch (type) {
                case ASSERT:
                    cmException = new CommonAssertException(assertionError.getMessage());
                    break;
                case VERIFICATION:
                    cmException= new CommonVerificationException(assertionError.getMessage());
                    break;
            }
            CommonExceptionHandler.handleException(cmException);
            throw cmException;

        }
    }

    public static void assertFalse(String message, boolean condition, ExceptionType type) {
        try {
            Assert.assertFalse(message, condition);

        } catch (AssertionError assertionError) {
            CommonException cmException = null;
            switch (type){
                case ASSERT:
                    cmException = new CommonAssertException(assertionError.getMessage());
                    break;
                case VERIFICATION:
                    cmException = new CommonVerificationException(assertionError.getMessage());
                    break;
            }
            CommonExceptionHandler.handleException(cmException);
        }
    }

    public static void assertTrue(String message, String expected, String actual, boolean condition, ExceptionType type) {
        try {
            Assert.assertTrue(message, condition);

        } catch (AssertionError assertionError) {
            CommonException cmException = null;
            switch (type){
                case ASSERT:
                    cmException = new CommonAssertException(assertionError.getMessage());
                    break;
                case VERIFICATION:
                    cmException = new CommonVerificationException(assertionError.getMessage(), expected, actual);
                    break;
            }
            CommonExceptionHandler.handleException(cmException);
        }
    }

    public static void fail(String message) {
        CommonException cmException = null;
        cmException = new CommonAssertException(message);
        //ifmException = new IfmVerificationException(message);
        CommonExceptionHandler.handleException(cmException);
    }

    public static void fail(String message, String expected, String actual, ExceptionType type) {
        CommonException cmException = null;
        switch (type){
            case ASSERT:
                cmException = new CommonAssertException(message);
                break;
            case VERIFICATION:
                cmException = new CommonVerificationException(message, expected, actual);
                break;
        }
        CommonExceptionHandler.handleException(cmException);
    }
}
