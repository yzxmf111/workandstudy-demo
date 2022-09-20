package cn.xiaotian.chainofresponsibilitypattern;

import org.springframework.stereotype.Component;

/**
 * @author xiaotian
 * @description
 * @date 2022-09-20 13:59
 */
@Component
public class FilterTwo implements Filter{

    @Override
    public boolean chain() {
        System.out.println("FilterTwo 的逻辑正在执行");
        return true;
    }
}
