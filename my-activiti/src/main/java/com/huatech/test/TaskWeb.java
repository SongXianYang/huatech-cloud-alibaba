package com.huatech.test;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 任务表
 * @author: SongXY
 * @create: 2021-07-16 22:17
 **/
@RestController
@RequestMapping("task")
@Api(tags = "任务表")
@Slf4j
public class TaskWeb {
    @Resource
    private TaskService taskService;

    //查询所有待办任务（权限最大）
    @GetMapping("getTask")
    public String getTask() {
        List<Task> list = taskService.createTaskQuery().list();
        for (Task task : list) {
            System.out.println("task = " + task.getId());
            System.out.println("task = " + task.getAssignee());
            System.out.println("task = " + task.getName());
            System.out.println("task = " + task.getDescription());
            System.out.println("task = " + task.getOwner());
        }
        return "success";
    }

    //查询自己待办任务
    @GetMapping("getAssigneeTask/{name}")
    public String getAssigneeTask(@PathVariable("name") String name) {
        List<Task> list = taskService.createTaskQuery().taskAssignee(name)
                .list();
        for (Task task : list) {
            System.out.println("task = " + task.getId());
            System.out.println("task = " + task.getAssignee());
            System.out.println("task = " + task.getName());
            System.out.println("task = " + task.getDescription());
            System.out.println("task = " + task.getOwner());
            System.out.println("task = " + task.getProcessInstanceId());
        }
        return "success";
    }

    /**
     * 执行完成任务
     * @param id
     * @return
     */
    @GetMapping("completeTask/{id}")
    public String completeTask(@PathVariable("id") String id) {

        //当前任务表的id
        taskService.complete(id);
        return "success";
    }

    /**
     * 完成任务时：需要填写一些意见 或者 要提交申请的（钱）
     * @param id
     * @return
     */
    @GetMapping("completeTaskUel/{id}")
    public String completeTaskUel(@PathVariable("id") String id) {
        Map<String, Object> variables = new HashMap<>();
        variables.put("pay", "1000");
        //当前任务表的id
        taskService.complete(id,variables);
        return "success";
    }

    //拾取任务
    @GetMapping("claimTask/{id}/{name}")

    public String claimTask(@PathVariable("id") String id, @PathVariable("name") String name) {
        Task task = taskService.createTaskQuery().taskId(id).singleResult();
        taskService.claim(id, name);
        return "success";
    }

    //归还与交办
    @GetMapping("setTaskAssignee/{id}/{name}")

    public String setTaskAssignee(@PathVariable("id") String id, @PathVariable("name") String name) {
        Task task = taskService.createTaskQuery().taskId(id).singleResult();
        taskService.setAssignee(id, name);

        return "success";
    }
}
