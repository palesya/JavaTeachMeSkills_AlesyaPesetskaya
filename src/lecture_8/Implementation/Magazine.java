package lecture_8.Implementation;

import lecture_8.Printable;

public class Magazine implements Printable {

    private String name;

    public Magazine(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void print() {
        System.out.println("This is a magazine "+this.getName());
    }

    public static void printMagazines(Printable[] printable){
        for (Printable el:printable) {
            if(el instanceof Magazine){
                el.print();
            }
        }
    }
}
