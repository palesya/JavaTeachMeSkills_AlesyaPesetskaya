package Homework_9.AdditionalTask;


import Homework_9.AdditionalTask.vectors.ThreeDimVector;
import Homework_9.AdditionalTask.vectors.TwoDimVector;

public class Main {
    public static void main(String[] args) {
        TwoDimVector twoDimVector = new TwoDimVector(new int[]{1, 5});
        TwoDimVector twoDimVector1 = new TwoDimVector(new int[]{9, 12});
        ThreeDimVector threeDimVector = new ThreeDimVector(new int[]{1, 6, 9});
        ThreeDimVector threeDimVector1 = new ThreeDimVector(new int[]{48, 5, 12});

        twoDimVector.countVectorLength();
        threeDimVector.countVectorLength();
        System.out.println("");

        twoDimVector.countScalarMultiply(twoDimVector1);
        threeDimVector.countScalarMultiply(threeDimVector1);
        System.out.println("");

        System.out.println("");
        twoDimVector.sumVectors(twoDimVector1);
        threeDimVector.sumVectors(threeDimVector1);

        System.out.println("");
        twoDimVector.minusVectors(twoDimVector1);
        threeDimVector.minusVectors(threeDimVector1);
        System.out.println("--------------------");

        twoDimVector.compareVectors(twoDimVector1);
        threeDimVector.compareVectors(threeDimVector1);

        twoDimVector.getVectorInfo();
        threeDimVector.getVectorInfo();
    }
}
