package Patterns.Creational.Singleton;

public class SingletonService {

    private static SingletonService instance;

    private SingletonService() {
    }

    public static SingletonService getSingletonInstance() {
        if (instance != null) {
            return instance;
        }
        synchronized (SingletonService.class) {
            if (instance == null)
                instance = new SingletonService();
        }
        return instance;
    }
}
