package utils.exceptions;

public class CommonVerificationException extends CommonException {

    public String expectedValue;
    public String actualValue;

    public CommonVerificationException(String msg) {
        super(msg);
        type = "VERIFICATION";
    }

    public CommonVerificationException(String msg, String expected, String actual) {
        super(msg);
        type = "VERIFICATION";
        expectedValue = expected;
        actualValue = actual;
    }

    public String getExpectedValue() {
        return expectedValue;
    }

    public void setExpectedValue(String expectedValue) {
        this.expectedValue = expectedValue;
    }

    public String getActualValue() {
        return actualValue;
    }

    public void setActualValue(String actualValue) {
        this.actualValue = actualValue;
    }

}

