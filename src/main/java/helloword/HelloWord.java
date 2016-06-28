package helloword;

import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;


public class HelloWord {
	ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
	//部署流程定义
	@Test
	public void deploymentProcessDefination(){
		Deployment deployment=processEngine.getRepositoryService()//获得与流程定义和部署对象相关的Service
		.createDeployment()//创建一个部署对象
		.name("HELLOWORDACTIVITI")//添加部署对象的名称
		.addClasspathResource("diagrams/helloword.bpmn")//从classpath中加载资源文件，一次只能加载一个
		.addClasspathResource("diagrams/helloword.png")//从classpath中加载资源文件，一次只能加载一个
		.deploy();//完成部署
		
		System.out.println(deployment.getId());
		System.out.println(deployment.getName());
	}
	//启动流程实例
	@Test
	public void startProcessInstance(){
		ProcessInstance processInstance = processEngine.getRuntimeService()//获得正在执行的的流程实例和执行对象相关的Service
		.startProcessInstanceByKey("helloword");//对应hellowprd。bpmn文件中的id属性。默认使用最新版本的流程定义启动
		System.out.println(processInstance.getId());
		System.out.println(processInstance.getName());
	}
	//查询当前用户的个人任务
	@Test
	public void findMyProcessTask(){
		List<Task> list =processEngine.getTaskService()//获取与任务相关的service
		.createTaskQuery()//创建任务查询对象
		.taskAssignee("李四")//指定任务执行人
		.list();
		
		if (list!=null && list.size()>0) {
			for (Task task:list) {
				System.out.println("taskID:"+task.getId());
			}
		}
	}
	//完成我的任务
	@Test
	public void completaMyProcessTask(){
		//任务id
		processEngine.getTaskService()
		.complete("2508");
		System.out.println("完成任务：2508");
	}

}
