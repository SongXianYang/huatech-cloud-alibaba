package com.huatech.test;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 流程实例类
 * @author: SongXY
 * @create: 2021-07-14 22:24
 **/
@RestController
@RequestMapping("ProcessInstance")
@Api(tags = "流程实例类")
@Slf4j
public class ProcessInstanceWeb {

    @Resource
    private RuntimeService runtimeService;
    final static String id ="88ce6a43-e4b3-11eb-a7ba-dc41a90b0905";


    /***
     * 写死的
     * @return
     */
    @ApiOperation("启动流程实例")
    @GetMapping("start")
    public String startProcessInstance() {
        /**
         *第一参数：act_re_procdef 表中key
         * 第二参数：业务表id（填写请假理由或者时间等表）
         */
        runtimeService.startProcessInstanceByKey("Process_sxy_task", "业务丫丫id");
        return "success";
    }

    /**
     * 在启动的时候传下一步接收人
     * @return
     */
    @ApiOperation("启动流程实例带表达式")
    @GetMapping("startUel")
    public String startProcessInstanceUel() {
        /**
         *第一参数：act_re_procdef 表中key
         * 第二参数：业务表id（填写请假理由或者时间等表）
         * 第三个参数是  指定下一步接收人
         */
        Map<String, Object> variables = new HashMap<>();
        variables.put("nameExecutor", "bajie");
        runtimeService.startProcessInstanceByKey("Process_uel_1", "uel业务丫丫id",variables);
        return "success";
    }

    @ApiOperation("查询流程实例")
    @GetMapping("queProcessInstance")
    public String queProcessInstance() {
        List<ProcessInstance> list = runtimeService.createProcessInstanceQuery().list();
        for (ProcessInstance processInstance : list) {
            System.out.println("processInstance = " + processInstance.getId());
            System.out.println("processInstance = " + processInstance.getDeploymentId());
            System.out.println("processInstance = " + processInstance.isEnded());
            System.out.println("processInstance = " + processInstance.isSuspended());
            System.out.println("processInstance = " + processInstance.getBusinessKey());
        }
        return "success";
    }

    @ApiOperation("挂起与激活")
    @GetMapping("hangUp")
    public String hangUp() {

        runtimeService.suspendProcessInstanceById(id);
        return "success";
    }

    @ApiOperation("删除")
    @GetMapping("del")
    public String del() {
        runtimeService.deleteProcessInstance(id,"第二个参数  说明你为啥要删除 删除得理由");
        return "success";
    }

}
