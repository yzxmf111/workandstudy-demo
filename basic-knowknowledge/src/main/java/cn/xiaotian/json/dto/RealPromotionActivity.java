package cn.xiaotian.json.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author yifan.tian
 * @Description
 * @Date 2023/8/22 16:27
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class RealPromotionActivity extends ActivityBaseInfo{
	private String activityPurpose;
	private String activityMode;
	private Boolean acrossSchedule;
}
