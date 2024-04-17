package Java.lang;

/**
 * @Author: yxxmf
 * @Date: 2024/04/14/23:20
 * @Description:
 */
public class Object {

    public static void main(String[] args) {
       Object o = new Object();
        ClassLoader classLoader = o.getClass().getClassLoader();

        System.out.println(classLoader);
    }
}
