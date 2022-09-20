package cn.xiaotian.chainofresponsibilitypattern;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xiaotian
 * @description
 * @date 2022-09-20 14:01
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FilterStatus {

    //过滤器执行顺序
    private Integer order;

    private Filter filter;

    private String filterName;

    //是否启用
    private Boolean isEnable;

    public int compareTo(FilterStatus filterStatus) {
        return this.getOrder() - filterStatus.getOrder();
    }
}
