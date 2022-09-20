package cn.xiaotian.chainofresponsibilitypattern;

import javafx.beans.binding.When;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author xiaotian
 * @description
 * @date 2022-09-20 13:57
 */
@Component
public class FilterManageImpl implements FilterManage {

    private Map<String, FilterStatus> filterStatusMap = new ConcurrentHashMap<String, FilterStatus>(); // 过滤器状态

    @Override
    public boolean register(Filter filter, String filterName) {
        FilterStatus filterStatus = FilterStatus.builder().filterName(filterName).filter(filter).order(filterStatusMap.size()).build();
        filterStatusMap.put(filterName, filterStatus);
        return true;
    }

    public void init() {
        Map<String, FilterStatus> sortedMap = new LinkedHashMap<String, FilterStatus>();
        List<Map.Entry<String, FilterStatus>> list = new ArrayList<>(filterStatusMap.entrySet());
        Collections.sort(list, (o1, o2) -> {
                    return o1.getValue().compareTo(o2.getValue());
                }
        );
        Iterator<Map.Entry<String, FilterStatus>> iterator = list.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, FilterStatus> next = iterator.next();
            sortedMap.put(next.getKey(), next.getValue());
        }
        filterStatusMap = sortedMap;
    }

    public void execute() {
        for (FilterStatus filterStatus : filterStatusMap.values()) {
            filterStatus.getFilter().chain();
        }
    }
}
