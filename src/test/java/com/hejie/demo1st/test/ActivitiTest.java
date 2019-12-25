package com.hejie.demo1st.test;

import com.hejie.demo1st.util.SecurityUtil;
import org.activiti.api.process.model.ProcessDefinition;
import org.activiti.api.process.model.ProcessInstance;
import org.activiti.api.process.model.builders.ProcessPayloadBuilder;
import org.activiti.api.process.runtime.ProcessRuntime;
import org.activiti.api.runtime.shared.query.Page;
import org.activiti.api.runtime.shared.query.Pageable;
import org.activiti.api.task.model.Task;
import org.activiti.api.task.model.builders.ClaimTaskPayloadBuilder;
import org.activiti.api.task.model.builders.TaskPayloadBuilder;
import org.activiti.api.task.runtime.TaskRuntime;
import org.activiti.engine.impl.bpmn.parser.handler.TaskParseHandler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//spingboot与JUnit整合，测试流程定义的相关操作


@RunWith(SpringRunner.class)
@SpringBootTest
public class ActivitiTest {
    @Autowired
    private ProcessRuntime processRuntime; //实现流程定义相关操作
    @Autowired
    private TaskRuntime taskRuntime; //实现任务相关操作
    @Autowired
    private SecurityUtil securityUtil; //SpringSecurity相关的工具类

    //    流程定义信息的查看
    @Test
    public void testDefinition() {
//SpringBoot的认证工作
        securityUtil.logInAs("salaboy");
//分页查询出流程定义信息
//        注意：流程部署工作会自动部署，前提是bpmn文件必须在 resources\processes
        Page<ProcessDefinition> processDefinitionPage = processRuntime.processDefinitions(Pageable.of(0, 10));
        //查看已部署的流程个数


        System.out.println(processDefinitionPage.getTotalItems());

        for (Object pd : processDefinitionPage.getContent()) {
            System.out.println("流程定义" + pd);
        }
    }

    /**
     * 启动流程实例
     */
    @Test
    public void testStartProcess() {
        securityUtil.logInAs("salaboy");
        ProcessInstance pi = processRuntime.start(ProcessPayloadBuilder
                .start()
                .withProcessDefinitionKey("myProcess_1")
                .build());
        System.out.println("流程实例 ID：" + pi.getId());
    }

    //查询任务并完成任务
    @Test
    public void TestTask() {
        securityUtil.logInAs("salaboy");
        Page<Task> taskPage = taskRuntime.tasks(Pageable.of(0, 10));

        if (taskPage.getTotalItems() > 0) {
            for (Task task : taskPage.getContent()) {
                System.out.println("任务1：" + task);
//                拾取任务
                taskRuntime.claim(TaskPayloadBuilder.claim().withTaskId(task.getId()).build());
//                执行任务
                taskRuntime.complete(TaskPayloadBuilder.complete().withTaskId(task.getId()).build());
            }
//            再次查询任务
            if (taskPage.getTotalItems() > 0) {
                for (Task task : taskPage.getContent()) {
                    System.out.println("任务2：" + task);
                }
            }
         }
    }
}