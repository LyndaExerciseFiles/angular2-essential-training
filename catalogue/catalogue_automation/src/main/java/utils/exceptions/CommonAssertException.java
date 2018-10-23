package utils.exceptions;

public class CommonAssertException extends CommonException{

    public String category;

    public CommonAssertException (String msg) {
        super(msg);
        type = "ASSERT";
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
