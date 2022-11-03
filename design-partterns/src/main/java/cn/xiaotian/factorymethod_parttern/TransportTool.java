package cn.xiaotian.factorymethod_parttern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author xiaotian
 * @description
 * @date 2022-10-31 17:04
 */
public abstract class TransportTool {

    //public Transport createTransportTool(String toolName){
    //    //此处也可以策略模式，也能符合要求，甚至可以说更好，因为对象不会每次都去创建
    //    return TransportUtils.getTransportTool(toolName);
    //}
    public abstract Transport createTransportTool();
}
