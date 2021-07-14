package com.huatech.test;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentQuery;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: SongXY
 * @create: 2021-07-12 21:07
 **/
@RestController
@RequestMapping("test")
@Api(tags = "测试工作流")
@Slf4j
public class DeploymentWeb {
    @Resource
    private RepositoryService repositoryService;

    @ApiOperation("测试部署流程")
    @GetMapping("BPMNDeployment")
    public String BPMNDeployment() {
        final String pngName="BPMN/Part1_Deployment.png";
        final String fileName = "BPMN/Part1_Deployment.bpmn";
        Deployment deployment =  repositoryService.createDeployment()
                .addClasspathResource(fileName)
                .addClasspathResource(pngName)
                .name("测试请假流程")
                .deploy();
        return "SUCCESS";
    }

    @GetMapping("quy")
    private List<Deployment> getDeployment() {
        List<Deployment> list = repositoryService.createDeploymentQuery().list();
        for (Deployment deployment : list) {
            log.error("getDeploymentName: {}", deployment.getName());
            log.error("getDeploymentID: {}", deployment.getId());
            log.error("getDeploymentKey: {}", deployment.getKey());
            log.error("getDeployment: {}", deployment.getDeploymentTime());
        }
        return list;
    }
}
