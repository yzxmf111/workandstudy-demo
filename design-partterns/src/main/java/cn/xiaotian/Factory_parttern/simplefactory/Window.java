package cn.xiaotian.Factory_parttern.simplefactory;

/**
 * @author xiaotian
 * @description
 * @date 2023-02-06 17:35
 */
public class Window extends Computer{
    @Override
    public void playGamesByComputer(Computer computer) {
        System.out.println("用起来不错");
    }
}
