package cn.xiaotian;

import cn.xiaotian.Factory_parttern.factorymethod_parttern.Transport;
import cn.xiaotian.Factory_parttern.factorymethod_parttern.TransportTool;
import cn.xiaotian.Factory_parttern.factorymethod_parttern.TransportUtils;
import cn.xiaotian.Factory_parttern.factorymethod_parttern.computer.WindowsFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
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

    @Resource(name = "car")
    private TransportTool transportTool;
    
    @Test
    public void testFactoryMethod() {
        //Transport t = transportTool.createTransportTool("Car");
        //t.deliver();
        Transport car = TransportUtils.getTransportTool("Car");
        car.deliver();
    }

    @Test
    public void testFactoryMethod2() {
        WindowsFactory windowsFactory = new WindowsFactory();
        windowsFactory.selectShop();
    }

}
