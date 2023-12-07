package cn.xiaotian.entity;

import lombok.Data;
import lombok.ToString;

/**
 * @author xiaotian
 * @description
 * @date 2023-02-14 14:16
 */
@Data
@ToString
public class Item {
    private String name;
    private String type;
    private String money;
    private Integer level;
    private Float weight;
}
