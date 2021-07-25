package com.huatech.test;

import io.swagger.annotations.Api;
import org.activiti.api.runtime.shared.query.Pageable;
import org.activiti.api.task.model.Task;
import org.activiti.api.task.model.builders.TaskPayloadBuilder;
import org.activiti.api.task.runtime.TaskRuntime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description: 新特性任务
 * @author: SongXY
 * @create: 2021-07-22 10:32
 **/

@RestController
@RequestMapping("taskRuntimeWeb")
@Api(tags = "新特性任务")
public class TaskRuntimeWeb {
    @Resource
    private TaskRuntime taskRuntime;
    /**
     * 获取任务
     */
    @GetMapping("getTask")
    public String getTask() {
        List<Task> list = taskRuntime.tasks(Pageable.of(0, 100)).getContent();
        for (Task tk : list) {
            System.out.println("-------------------");
            System.out.println("getId：" + tk.getId());
            System.out.println("getName：" + tk.getName());
            System.out.println("getStatus：" + tk.getStatus());
            System.out.println("getCreatedDate：" + tk.getCreatedDate());
            if (tk.getAssignee().isEmpty()) {
                System.out.println("该任务需要拾取");
            } else {
                System.out.println("当前任务环节审核人是:"+tk.getAssignee());
            }
        }
        return "获取任务Success";
    }

    /**
     * 完成任务、拾取任务
     */
    @GetMapping("completeTask/{id}")
    public String completeTask(@PathVariable("id") String id) {
        //获取当前任务
        Task task = taskRuntime.task(id);
        //判断当前环节时候有执行人
        if (task.getAssignee().isEmpty()) {
            //没有就先拾取
            taskRuntime.claim(TaskPayloadBuilder.claim().withTaskId(id).build());
            System.out.println("拾取任务成功");
        }
        //完成该任务
        taskRuntime.complete(TaskPayloadBuilder.complete()
                .withTaskId(id)
                .withVariable("pay",111)
                .build());
        System.out.println("完成任务成功");
        return "完成任务、拾取任务Success";
    }

}
