package lecture_7.Examples;

public interface Noisable {
    default void makeSomeNoise() {
        System.out.println("Make some noise");
    }
}
