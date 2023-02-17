package cn.xiaotian.Factory_parttern.factorymethod_parttern.computer;

import lombok.Data;

/**
 * @author xiaotian
 * @description
 * @date 2023-02-09 14:25
 */
@Data
public abstract class Computer {

    private String type;
    private String name;

    public abstract void showDetails(Computer computer);
}
