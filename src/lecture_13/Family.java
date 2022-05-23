package lecture_13;

import java.util.List;

public class Family {
    private String sName;
    private List<Child> childList;

    public Family(String sName, List<Child> childList) {
        this.sName = sName;
        this.childList = childList;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public List<Child> getChildList() {
        return childList;
    }

    public void setChildList(List<Child> childList) {
        this.childList = childList;
    }

    @Override
    public String toString() {
        return "Family{" +
                "sName='" + sName + '\'' +
                ", childList=" + childList +
                '}';
    }
}
