package Patterns.Creational.Factory;

public class BreadFactory {

    public Bread produceBread(BreadTypes type) {
        Bread producesBread = null;
        try {
            switch (type) {
                case DARK:
                    producesBread = new DarkBreadImpl();
                    break;
                case WHITE:
                    producesBread = new WhiteBreadImpl();
                    break;
            }
        } catch (NullPointerException ex) {
            throw new IllegalArgumentException("Such type doesn't exist.");
        }
        return producesBread;
    }

}
