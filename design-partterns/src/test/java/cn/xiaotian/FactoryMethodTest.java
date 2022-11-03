package cn.xiaotian;

import cn.xiaotian.factorymethod_parttern.Transport;
import cn.xiaotian.factorymethod_parttern.TransportTool;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author xiaotian
 * @description
 * @date 2022-10-31 16:15
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MainApplication.class)
public class FactoryMethodTest {

    @Resource
    private TransportTool transportTool;
    
    @Test
    public void testFactoryMethod() {
        //Transport t = transportTool.createTransportTool("Car");
        //t.deliver();

    }
}
