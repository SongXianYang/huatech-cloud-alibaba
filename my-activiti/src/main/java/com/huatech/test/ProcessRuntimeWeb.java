package com.huatech.test;

import com.huatech.uilts.SecurityUtil;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.activiti.api.model.shared.model.VariableInstance;
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
    @GetMapping("start/{id}")
    public String start(@PathVariable("id") String id) {
        processRuntime.start(ProcessPayloadBuilder.start()
                .withName("测试新特性启动流程实例_21212121")
                .withBusinessKey("新特性id")
                //流程定义id启动
                .withProcessDefinitionId(id)
                .withVariable("nameExecutor","bajie")
                //流程定义的key来启动
//                .withProcessDefinitionKey("")
                .build());
        return "启动成功";
    }

    /**
     * 查询流程实例
     */
    @GetMapping("pageList/{name}")
    public String pageList(@PathVariable("name") String name) {
        securityUtil.logInAs(name);
        Order order = new Order("DESC");
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
     * 也可以通过流程定义查询
     */

    /**
     * 删除流程实例
     */
    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") String id) {
        //参数流程实例id
        processRuntime.delete(ProcessPayloadBuilder.delete(id));
        return "删除成功！";
    }

    /**
     * 挂起流程(停止流程）
     */
    @GetMapping("suspend/{id}")
    public String suspend(@PathVariable("id") String id) {
        //参数：流程实例id
        processRuntime.suspend(ProcessPayloadBuilder.suspend(id));
        return "停止流程成功";
    }
    /**
     * 激活流程实例（恢复流程）
     */
    @GetMapping("resume/{id}")
    public String resume(@PathVariable("id") String id) {
        //参数：流程实例id
        processRuntime.resume(ProcessPayloadBuilder.resume(id));
        return "恢复流程成功";
    }
    /**
     * 获取流程实例参数
     */
    @GetMapping("getVariables/{id}")
    public String getVariables(@PathVariable("id") String id) {
        //参数：流程实例id
        List<VariableInstance> list = processRuntime.variables(ProcessPayloadBuilder.variables().withProcessInstanceId(id).build());
        for(VariableInstance vi : list){
            System.out.println("-------------------");
            System.out.println("getName：" + vi.getName());
            System.out.println("getValue：" + vi.getValue());
            System.out.println("getTaskId：" + vi.getTaskId());
            System.out.println("getProcessInstanceId：" + vi.getProcessInstanceId());
        }
        return "获取流程实例参数成功";
    }
}
