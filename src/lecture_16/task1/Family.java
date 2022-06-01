package lecture_16.task1;

import java.util.List;

public class Family {

    private String sname;
    private int age;
    private List<Member> members;

    public Family(String sname, int age, List<Member> members) {
        this.sname = sname;
        this.age = age;
        this.members = members;
    }

    public String getSname() {
        return sname;
    }

    public int getAge() {
        return age;
    }

    public List<Member> getMembers() {
        return members;
    }

    @Override
    public String toString() {
        return "Family{" +
                "sname='" + sname + '\'' +
                ", age=" + age +
                ", members=" + members +
                '}';
    }
}
