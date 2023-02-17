package cn.xiaotian.Factory_parttern.factorymethod_parttern.computer;

/**
 * @author xiaotian
 * @description
 * @date 2023-02-09 14:47
 */
public abstract class ComputerFactory {

    public abstract Computer buyComputer();

    public void selectShop() {
        Computer computer = buyComputer();
        computer.showDetails(computer);
    }
}
