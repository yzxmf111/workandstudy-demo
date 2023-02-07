package cn.xiaotian.Factory_parttern.factorymethod_parttern;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author xiaotian
 * @description
 * @date 2022-10-31 17:07
 */
public class TransportUtils {

    public static Map<String, Transport> transportToolMap = new ConcurrentHashMap<>();

    public static void addTools(Transport transport) {
        if (!transportToolMap.containsValue(transport)) {
            transportToolMap.put(transport.getClass().getSimpleName(), transport);
        }
    }

    public static Transport getTransportTool(String category) {
        return transportToolMap.get(category);
    }
}
