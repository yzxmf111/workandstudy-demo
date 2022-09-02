package xiaotian.EffectiveJava;

/**
 * @author xiaotian
 * @description
 * @date 2022-08-19 11:30
 */
public class Singleton {

    private static Singleton SINGLETON = new Singleton();

    private Singleton() {}

    public static Singleton newInstance () {
        return SINGLETON;
    }
}
