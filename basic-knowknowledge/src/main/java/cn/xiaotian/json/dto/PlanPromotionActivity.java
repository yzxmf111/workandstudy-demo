package cn.xiaotian.json.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author yifan.tian
 * @Description
 * @Date 2023/8/22 16:26
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class PlanPromotionActivity extends ActivityBaseInfo{
	private String activityRule;
}
