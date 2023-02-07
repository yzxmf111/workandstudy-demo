package cn.xiaotian.Factory_parttern.simplefactory;

/**
 * @author xiaotian
 * @description
 * @date 2023-02-06 17:34
 */
public class Mac extends Computer{

    @Override
    public void playGamesByComputer(Computer computer) {
        System.out.println("用起来很一般");
    }
}
