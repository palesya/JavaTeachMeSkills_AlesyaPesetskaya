package homework_9.Task1;

public class TwoDimVector {
    private int x;
    private int y;
    private static final String description="This is two dim vector";

    public TwoDimVector(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void countVectorLength() {
        System.out.println("");
        System.out.printf("Vector's length  = %.2f",Math.sqrt(Math.pow(this.getX(), 2) + Math.pow(this.getY(), 2)));
    }

    public void countScalarMultiply(TwoDimVector vector) {
        System.out.println("");
        System.out.printf("Scalar multiplication = %d", this.getX() * vector.getX() + this.getY() * vector.getY());
    }

    public TwoDimVector sumVectors(TwoDimVector vector) {
        int a = this.getX() + vector.getX();
        int b = this.getY() + vector.getY();
        return new TwoDimVector(a, b);
    }

    public TwoDimVector minusVectors(TwoDimVector vector) {
        int a = this.getX() - vector.getX();
        int b = this.getY() - vector.getY();
        return new TwoDimVector(a, b);
    }

    public void getVectorInfo(){
        System.out.println("-------------------");
        System.out.println(description);
        System.out.printf("with coordinates x = %d , y = %d",this.getX(),this.getY());
        System.out.println("");
    }

    public void compareVectors(TwoDimVector vector) {
        if(this.getX() == vector.getX()&&this.getY() == vector.getY()){
            System.out.println("Vectors are equal");
        }else{
            System.out.println("Vectors are not equal");
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
