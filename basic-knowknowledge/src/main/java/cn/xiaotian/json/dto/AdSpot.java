package cn.xiaotian.json.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author yifan.tian
 * @Description
 * @Date 2023/8/22 16:57
 **/
@Data
public class AdSpot {
	private String resourceType;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDateTime startDate;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDateTime endDate;
	private List<ActivityArea> activityAreaList;
}
