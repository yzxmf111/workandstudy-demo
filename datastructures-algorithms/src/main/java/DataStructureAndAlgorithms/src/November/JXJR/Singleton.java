package November.JXJR;

public class Singleton {
    private static volatile Singleton instance;
    private Singleton(){};
    public static Singleton getInstance(Singleton instance) {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;

    }
}
