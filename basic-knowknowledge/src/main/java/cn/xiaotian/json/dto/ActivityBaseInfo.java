package cn.xiaotian.json.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author yifan.tian
 * @Description
 * @Date 2023/8/22 16:33
 **/
@Data
public class ActivityBaseInfo {
	protected String activityId;
	protected String activityName;
	protected String activityType;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	protected LocalDateTime activityStartDate;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	protected LocalDateTime activityEndDate;
	protected String price;
	private List<ActivityArea> ActivityAreaList;
	private String source;
}
