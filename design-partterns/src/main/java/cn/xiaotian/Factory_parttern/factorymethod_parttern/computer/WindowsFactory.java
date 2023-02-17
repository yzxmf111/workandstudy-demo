package cn.xiaotian.Factory_parttern.factorymethod_parttern.computer;

/**
 * @author xiaotian
 * @description
 * @date 2023-02-14 11:23
 */
public class WindowsFactory extends ComputerFactory{

    @Override
    public Computer buyComputer() {
        Windows windows = new Windows();
        windows.setName("华硕");
        windows.setType("14寸，144HZ");
        return windows;
    }
}
