package cn.xiaotian.basejava;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @Author yifan.tian
 * @Description
 * @Date 2023/8/21 10:12
 **/

@Data
public class ActivityInfoQueryRequest {
	private List<Integer> productIds;
	private List<Integer> generalStoreIds;
	private List<String> categoryGroup;
	private List<List<Integer>> purchaseCategory;
	private Date scheduleStartDate;
	private Date scheduleFinishDate;
	private Date latestConfirmTime;
	private String saLevel;
	private Integer recommendationType;
	private String activityId;
	private Integer activityStatus;
	private Integer dataStatus;
	private Integer purchaseConfirmStatus;
}
