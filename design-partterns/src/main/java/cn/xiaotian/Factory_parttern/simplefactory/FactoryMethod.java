package cn.xiaotian.Factory_parttern.simplefactory;

/**
 * @author xiaotian
 * @description
 * @date 2023-02-06 17:42
 */
public interface FactoryMethod {

    /**
     * @return
     */
    public abstract Computer getComputer();

     default void doSomething(String computerOS) {
         Computer computer = getComputer();
         computer.playGamesByComputer(computer);
     }
}
