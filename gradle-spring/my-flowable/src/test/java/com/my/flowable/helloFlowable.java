package com.my.flowable;

import org.flowable.engine.*;
import org.flowable.engine.common.impl.AbstractEngineConfiguration;
import org.flowable.engine.history.HistoricActivityInstance;
import org.flowable.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.repository.ProcessDefinition;
import org.flowable.engine.repository.ProcessDefinitionQuery;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author kevin
 * @ClassName helloFlowable.java
 * @Description TODO
 * @createTime 2020年11月23日 10:57:00
 */
public class helloFlowable {

    public static void main(String[] args) {

        //TODO 创建配置
        ProcessEngineConfiguration processEngineConfiguration = new StandaloneProcessEngineConfiguration()
                .setJdbcUrl("jdbc:mysql://192.168.0.181:3306/kevin-test")
                .setJdbcUsername("root")
                .setJdbcPassword("jieyundata.com")
                .setJdbcDriver("com.mysql.jdbc.Driver")
                .setDatabaseSchemaUpdate(AbstractEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
        //TODO 获取流程引擎
        ProcessEngine processEngine = processEngineConfiguration.buildProcessEngine();
        //TODO 定义流程（XML 或者 图形工具）
        //resource 目录下的bpmn文件
        RepositoryService repositoryService = processEngine.getRepositoryService();
        //TODO 部署流程
        Deployment deploy = repositoryService.createDeployment()
                .addClasspathResource("holiday-request.bpmn20.xml")
                .deploy();
        //查询流程定义
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
                .deploymentId(deploy.getId())
                .singleResult();
        System.out.println("Found process Definition:" + processDefinition.getName());
        //TODO 开启一个流程示例
        //输入请假数据
        Scanner scanner = new Scanner(System.in);
        System.out.println("Who are you?");
        String employee = scanner.nextLine();
        System.out.println("How many holidays do you want to request?");
        Integer nrOfHolidays = Integer.valueOf(scanner.nextLine());
        System.out.println("Why do you need them?");
        String description = scanner.nextLine();

        RuntimeService runtimeService = processEngine.getRuntimeService();
        Map<String, Object> holidayInfoMap = new HashMap<>();
        holidayInfoMap.put("employee", employee);
        holidayInfoMap.put("nrOfHolidays", nrOfHolidays);
        holidayInfoMap.put("description", description);
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("holidayRequest", holidayInfoMap);
        //查询流程的信息 查询manager需要审批的流程
        TaskService taskService = processEngine.getTaskService();
        List<Task> tasks = taskService.createTaskQuery().taskCandidateGroup("managers").list();
        tasks.forEach(task -> {
            System.out.println(task.getId() + ":" + task.getName());
        });
        System.out.println("input task id to complete");
        int taskId = Integer.parseInt(scanner.nextLine());
        Map<String, Object> variables = taskService.getVariables(String.valueOf(taskId));
        System.out.println("employee【" + variables.get("employee") + "】wants【" + variables.get("nrOfHolidays") + "】day,why【" + variables.get("description") + "】");
        System.out.println("do you agree:");
        //TODO 调用API 运行流程
        boolean approved = scanner.nextLine().toLowerCase().equals("y");
        variables = new HashMap<>();
        variables.put("approved",approved);
        taskService.complete(String.valueOf(taskId),variables);
        //TODO 运行流程 ，调用 回调方法
        //TODO 完成流程 查询流程 历史信息

        HistoryService historyService = processEngine.getHistoryService();
        List<HistoricActivityInstance> historys = historyService.createHistoricActivityInstanceQuery().processInstanceId(processInstance.getId())
                .finished()
                .orderByHistoricActivityInstanceEndTime().asc()
                .list();
        historys.forEach(history->{
            System.out.println(history.getActivityId()+"took"+history.getDurationInMillis()+" milliseconds");
        });


    }
}
