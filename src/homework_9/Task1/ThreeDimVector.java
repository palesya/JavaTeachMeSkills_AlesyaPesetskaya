package homework_9.Task1;

public class ThreeDimVector {

    private int x;
    private int y;
    private int z;
    private static final String description="This is three dim vector";

    public ThreeDimVector(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void countVectorLength() {
        System.out.println("");
        System.out.printf("Vector's length = %.2f", Math.sqrt(Math.pow(this.getX(), 2) + Math.pow(this.getY(), 2) + Math.pow(this.getZ(), 2)));
    }

    public void countScalarMultiply(ThreeDimVector vector) {
        System.out.println("");
        System.out.printf("Scalar multiplication = %d", this.getX() * vector.getX() + this.getY() * vector.getY() + this.getZ() * vector.getZ());
    }

    public ThreeDimVector sumVectors(ThreeDimVector vector) {
        int a = this.getX() + vector.getX();
        int b = this.getY() + vector.getY();
        int c = this.getZ() + vector.getZ();
        return new ThreeDimVector(a, b, c);
    }

    public ThreeDimVector minusVectors(ThreeDimVector vector) {
        int a = this.getX() - vector.getX();
        int b = this.getY() - vector.getY();
        int c = this.getZ() - vector.getZ();
        return new ThreeDimVector(a, b, c);
    }

    public void getVectorInfo(){
        System.out.println("-------------------");
        System.out.println(description);
        System.out.printf("with coordinates x = %d , y = %d, z = %d",this.getX(),this.getY(),this.getZ());
        System.out.println("");
    }

    public void compareVectors(ThreeDimVector vector) {
        if(this.getX() == vector.getX()&&this.getY() == vector.getY()&&this.getZ() == vector.getZ()){
            System.out.println("Vectors are equal");
        }else{
            System.out.println("Vectors are not equal");
        }
    }



    @Override
    public String toString() {
        return "{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
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

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }
}
