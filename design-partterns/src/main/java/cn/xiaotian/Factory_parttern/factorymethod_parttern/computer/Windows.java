package cn.xiaotian.Factory_parttern.factorymethod_parttern.computer;

import cn.xiaotian.Factory_parttern.factorymethod_parttern.computer.Computer;

/**
 * @author xiaotian
 * @description
 * @date 2023-02-09 14:26
 */
public class Windows extends Computer {


    @Override
    public void showDetails(Computer computer) {
        System.out.println("电脑型号:"+computer.getType() + ",name:" + computer.getName());
    }
}
