package com.huatech.test;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description: 流程定义
 * @author: SongXY
 * @create: 2021-07-14 05:39
 **/
@RestController
@RequestMapping("ProcessDefinition")
@Api(tags = "流程定义")
@Slf4j
public class ProcessDefinitionWeb {
    @Resource
    private RepositoryService repositoryService;

    @ApiOperation("获取流程定义")
    @GetMapping("get")
    public List<ProcessDefinition> get() {
        List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery().list();
        list.forEach(pd->{
            System.out.println(pd.getKey());
            System.out.println(pd.getVersion());
            System.out.println(pd.getName());
        });
        return list;
    }
    @ApiOperation("获取流程定义")
    @GetMapping("del")
    public void del() {
        final String deploymentId="9fbfd641-e315-11eb-9855-dc41a90b0905";
        repositoryService.deleteDeployment(deploymentId,true);
        log.info("del: "+"SUCCESS");
    }
}
