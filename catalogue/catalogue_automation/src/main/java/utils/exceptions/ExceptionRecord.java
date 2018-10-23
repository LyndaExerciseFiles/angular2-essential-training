package utils.exceptions;

public class ExceptionRecord {

    public String sampleInfo;
    public String type;
    public String category;
    public String message;
    public String expectedValue;
    public String actualValue;
    public String dateTime;

    public ExceptionRecord () {

    }

    public ExceptionRecord (String sampleInfo, String type, String category, String message, String expectedValue, String actualValue) {

    }

    public String getSampleInfo() {
        return sampleInfo;
    }

    public void setSampleInfo(String sampleInfo) {
        this.sampleInfo = sampleInfo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

}

