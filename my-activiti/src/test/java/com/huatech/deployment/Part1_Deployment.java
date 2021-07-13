package com.huatech.deployment;

import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.impl.repository.DeploymentBuilderImpl;
import org.activiti.engine.repository.Deployment;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


/**
 * @description: 测试部署
 * @author: SongXY
 * @create: 2021-07-12 17:30
 **/
@SpringBootTest
@Slf4j
public class Part1_Deployment {
    @Autowired
    private RepositoryService repositoryService;
    @Test
    public void BPMNDeployment() {
        String fileName = "BPMN/Test.bpmn";
        DeploymentBuilderImpl deployment = (DeploymentBuilderImpl) repositoryService.createDeployment()
                .addClasspathResource(fileName)
                .name("测试请假流程")
                .deploy();
        log.info("BPMNDeployment: {}",deployment);
    }
}

