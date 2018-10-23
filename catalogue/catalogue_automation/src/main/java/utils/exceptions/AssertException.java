package utils.exceptions;

public class AssertException extends CommonException {

    public String category;

    public AssertException (String msg) {
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
