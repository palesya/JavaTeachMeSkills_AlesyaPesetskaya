package homework_9.Task1;

public class Main {
    public static void main(String[] args) {

        TwoDimVector twoDimVector=new TwoDimVector(1,5);
        TwoDimVector twoDimVector1=new TwoDimVector(9,12);
        ThreeDimVector threeDimVector=new ThreeDimVector(1,6,9);
        ThreeDimVector threeDimVector1=new ThreeDimVector(48,5,12);

        twoDimVector.countVectorLength();
        threeDimVector.countVectorLength();
        twoDimVector.countScalarMultiply(twoDimVector1);
        threeDimVector.countScalarMultiply(threeDimVector1);
        System.out.println("");
        System.out.println("Vectors' sum = "+twoDimVector.sumVectors(twoDimVector1).toString());
        System.out.println("Vectors' sum = "+threeDimVector.sumVectors(threeDimVector1).toString());
        System.out.println("Vectors' subtraction = "+twoDimVector.minusVectors(twoDimVector1).toString());
        System.out.println("Vectors' subtraction = "+threeDimVector.minusVectors(threeDimVector1).toString());
        twoDimVector.compareVectors(twoDimVector1);
        threeDimVector.compareVectors(threeDimVector1);

        twoDimVector.getVectorInfo();
        threeDimVector.getVectorInfo();
    }

}

