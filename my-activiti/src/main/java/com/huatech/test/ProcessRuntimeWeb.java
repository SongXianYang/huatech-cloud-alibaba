package com.huatech.test;

import com.huatech.uilts.SecurityUtil;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.activiti.api.process.model.ProcessInstance;
import org.activiti.api.process.model.builders.ProcessPayloadBuilder;
import org.activiti.api.process.runtime.ProcessRuntime;
import org.activiti.api.runtime.shared.query.Order;
import org.activiti.api.runtime.shared.query.Page;
import org.activiti.api.runtime.shared.query.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description: activiti中ProcessRuntime新特性
 * @author: SongXY
 * @create: 2021-07-20 20:51
 **/
@RestController
@RequestMapping("processRuntimeWeb")
@Api(tags = "activiti中ProcessRuntime新特性")
@Slf4j
public class ProcessRuntimeWeb {
    @Resource
    private SecurityUtil securityUtil;
    @Resource
    private ProcessRuntime processRuntime;

    /**
     * 启动流程实例
     */
    @GetMapping("start")
    public String start() {
        processRuntime.start(ProcessPayloadBuilder.start()
                .withName("测试新特性启动流程实例")
                .withBusinessKey("新特性id")
                .withProcessDefinitionId("")
                .withProcessDefinitionKey("")
                .build());
        return "启动成功";
    }

    /**
     * 查询流程实例
     */
    @GetMapping("pageList/{name}")
    public String pageList(@PathVariable("name") String name) {
        securityUtil.logInAs(name);
        Order order = new Order("fsfs");
        Page<ProcessInstance> page = processRuntime.processInstances(Pageable.of(0, 100, order));
        List<ProcessInstance> list = page.getContent();
        for (ProcessInstance pi : list) {
            System.out.println("-----------------------");
            System.out.println("getId：" + pi.getId());
            System.out.println("getName：" + pi.getName());
            System.out.println("getStartDate：" + pi.getStartDate());
            System.out.println("getStatus：" + pi.getStatus());
            System.out.println("getProcessDefinitionId：" + pi.getProcessDefinitionId());
            System.out.println("getProcessDefinitionKey：" + pi.getProcessDefinitionKey());
        }
        return "查询成功";
    }
    /**
     * 也可以查询流程定义
     */
}
