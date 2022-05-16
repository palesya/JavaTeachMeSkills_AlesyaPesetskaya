package homework_10;

public enum Position {
    DIRECTOR(1.5),
    WORKER(1);

    double coefficient;

    Position(double coefficient) {
        this.coefficient = coefficient;
    }
}
