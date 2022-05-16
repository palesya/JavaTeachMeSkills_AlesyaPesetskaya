package homework_7.Figures;

public class FigureMain {
    public static void main(String[] args) {
        Figure parallelogram=new Parallelogram(8,10,14);
        Figure trapezoid=new Trapezoid(10,12,11,13,18);
        Figure rhombus=new Rhombus(7,12,12);
        Figure triangle=new Triangle(7,12,11);
        Figure rectangle=new Rectangle(10,18);
        Figure circle =new Circle(10);


        Figure[]figures={parallelogram,trapezoid,rhombus,triangle,rectangle,circle};
        for (Figure el:figures) {
            System.out.println("------------------------------------------");
            String figureName= el.getClass().toString().split("\\.")[2];
            System.out.printf("Counted squares of %s = %.2f",figureName,el.countSquare());
            System.out.println();
            System.out.printf("Counted perimeter of %s = %.2f",figureName,el.countPerimeter());
            System.out.println();

        }
    }
}
