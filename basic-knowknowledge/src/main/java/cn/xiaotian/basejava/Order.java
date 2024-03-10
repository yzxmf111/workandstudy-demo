package cn.xiaotian.basejava;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
class Order {
    /**
     * 订单号
     */
    private String orderNum;


    /**
     * 付款时间
     */
    private String payTime;

    /**
     * 支付金额
     */
    private Integer actualAmount;
}
