package com.huatech.test;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.HistoryService;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.impl.history.HistoryManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description: 查询已办列表
 * @author: SongXY
 * @create: 2021-07-17 17:40
 **/
@RestController
@RequestMapping("HistoricTask")
@Api(tags = "查询已办列表")
@Slf4j
public class HistoricTaskWeb {
    @Resource
    private HistoryService service;

    /**
     * 根据用户查已办
     */
    @GetMapping("getHistoricTaskByName/{name}")
    public String getHistoricTaskByName(@PathVariable("name") String name) {
        List<HistoricTaskInstance> list = service.createHistoricTaskInstanceQuery().taskAssignee(name).orderByHistoricTaskInstanceEndTime().desc().list();
        for (HistoricTaskInstance historicTaskInstance : list) {
            System.out.println("historicTaskInstance = " + historicTaskInstance.getId());
            System.out.println("historicTaskInstance = " + historicTaskInstance.getProcessInstanceId());
            System.out.println("historicTaskInstance = " + historicTaskInstance.getProcessDefinitionId());
            System.out.println("historicTaskInstance = " + historicTaskInstance.getName());
        }
        return "success";
    }
    /**
     *根据流程实例id查已办
     */
    @GetMapping("getProcessDefinitionId/{id}")
    public String getProcessDefinitionId(@PathVariable("id") String id) {
        List<HistoricTaskInstance> list = service.createHistoricTaskInstanceQuery().processInstanceId(id).orderByHistoricTaskInstanceEndTime().desc().list();
        for (HistoricTaskInstance historicTaskInstance : list) {
            System.out.println("historicTaskInstance = " + historicTaskInstance.getId());
            System.out.println("historicTaskInstance = " + historicTaskInstance.getProcessInstanceId());
            System.out.println("historicTaskInstance = " + historicTaskInstance.getProcessDefinitionId());
            System.out.println("historicTaskInstance = " + historicTaskInstance.getName());
        }
        return "success";
    }
}
