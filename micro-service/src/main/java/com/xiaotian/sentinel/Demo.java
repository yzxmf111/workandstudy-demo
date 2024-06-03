package com.xiaotian.sentinel;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.alibaba.dubbo.common.threadpool.support.fixed.FixedThreadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

/**
 * @Author yifan.tian
 * @Description
 * @Date 2024/5/31 10:28
 **/
public class Demo {

	@SentinelResource("HelloWorld")
	public void helloWorld() {
		// 资源中的逻辑
		System.out.println("hello world");
	}

	private static void initFlowRules(){
		List<FlowRule> rules = new ArrayList<>();
		FlowRule rule = new FlowRule();
		rule.setResource("HelloWorld");
		rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
		// Set limit QPS to 20.
		rule.setCount(20);
		rules.add(rule);
		FlowRuleManager.loadRules(rules);
	}

	public static void main(String[] args) {
		Demo demo = new Demo();
		AsyncUtil.execute(
				() ->  demo.helloWorld()
		);

	}


}
