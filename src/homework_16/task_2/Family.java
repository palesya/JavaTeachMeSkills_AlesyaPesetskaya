package homework_16.task_2;

import java.util.List;

public class Family {

    private String sName;
    private String address;
    private long averageSalaryPerMember;
    private List<Child> listOfChildren;

    public Family(String sName, String address, long averageSalaryPerMember, List<Child> listOfChildren) {
        this.sName = sName;
        this.address = address;
        this.averageSalaryPerMember = averageSalaryPerMember;
        this.listOfChildren = listOfChildren;
    }

    public String getSName() {
        return sName;
    }

    public String getAddress() {
        return address;
    }

    public long getAverageSalaryPerMember() {
        return averageSalaryPerMember;
    }

    public List<Child> getListOfChildren() {
        return listOfChildren;
    }

    @Override
    public String toString() {
        return "Family{" +
                "sName='" + sName + '\'' +
                ", address='" + address + '\'' +
                ", averageSalaryPerMember=" + averageSalaryPerMember +
                ", listOfChildren=" + listOfChildren +
                '}';
    }
}
