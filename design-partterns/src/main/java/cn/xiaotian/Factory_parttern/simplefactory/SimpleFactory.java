package cn.xiaotian.Factory_parttern.simplefactory;

import org.apache.commons.lang3.StringUtils;

/**
 * @author xiaotian
 * @description
 * @date 2023-02-06 10:13
 */
public class SimpleFactory {

    /**
     * 缺点：违背了开闭原则。
     */
    public static Computer getComputerByOperationSystem(String osType) {
        if (StringUtils.equals(osType, "windows")) {
            //业务逻辑
            return new Window();
        } else if(StringUtils.equals(osType, "mac")) {
            //业务逻辑
            return new Mac();
        } else {
            //业务逻辑
            return new Linux();
        }

    }
}
