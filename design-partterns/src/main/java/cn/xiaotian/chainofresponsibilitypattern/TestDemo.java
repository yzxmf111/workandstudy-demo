package cn.xiaotian.chainofresponsibilitypattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @author xiaotian
 * @description
 * @date 2022-09-20 14:03
 */
@Component
public class TestDemo {

    @Autowired
    private FilterManageImpl filterManage;

    @Resource
    private Filter filterOne;

    @Resource
    private Filter filterTwo;

    @Resource
    private Filter filterThree;

    @Resource
    private Filter filterFour;

    @Resource
    private Filter filterFive;

    @PostConstruct
    public void test(){
        filterManage.register(filterOne, filterOne.getClass().getSimpleName());
        filterManage.register(filterTwo, filterTwo.getClass().getSimpleName());
        filterManage.register(filterThree, filterThree.getClass().getSimpleName());
        filterManage.register(filterFour, filterFour.getClass().getSimpleName());
        filterManage.register(filterFive, filterFive.getClass().getSimpleName());
        filterManage.init();
        filterManage.execute();
    }

}
