package cn.xiaotian.json.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @Author yifan.tian
 * @Description
 * @Date 2023/8/22 16:27
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class DeliverActivity extends ActivityBaseInfo{
	private String floorName;
	private String floorNum;
	private String floorType;
	private List<AdSpot> resourceInfoList;
}
