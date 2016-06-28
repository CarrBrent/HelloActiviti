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
	//�������̶���
	@Test
	public void deploymentProcessDefination(){
		Deployment deployment=processEngine.getRepositoryService()//��������̶���Ͳ��������ص�Service
		.createDeployment()//����һ���������
		.name("HELLOWORDACTIVITI")//��Ӳ�����������
		.addClasspathResource("diagrams/helloword.bpmn")//��classpath�м�����Դ�ļ���һ��ֻ�ܼ���һ��
		.addClasspathResource("diagrams/helloword.png")//��classpath�м�����Դ�ļ���һ��ֻ�ܼ���һ��
		.deploy();//��ɲ���
		
		System.out.println(deployment.getId());
		System.out.println(deployment.getName());
	}
	//��������ʵ��
	@Test
	public void startProcessInstance(){
		ProcessInstance processInstance = processEngine.getRuntimeService()//�������ִ�еĵ�����ʵ����ִ�ж�����ص�Service
		.startProcessInstanceByKey("helloword");//��Ӧhellowprd��bpmn�ļ��е�id���ԡ�Ĭ��ʹ�����°汾�����̶�������
		System.out.println(processInstance.getId());
		System.out.println(processInstance.getName());
	}
	//��ѯ��ǰ�û��ĸ�������
	@Test
	public void findMyProcessTask(){
		List<Task> list =processEngine.getTaskService()//��ȡ��������ص�service
		.createTaskQuery()//���������ѯ����
		.taskAssignee("����")//ָ������ִ����
		.list();
		
		if (list!=null && list.size()>0) {
			for (Task task:list) {
				System.out.println("taskID:"+task.getId());
			}
		}
	}
	//����ҵ�����
	@Test
	public void completaMyProcessTask(){
		//����id
		processEngine.getTaskService()
		.complete("2508");
		System.out.println("�������2508");
	}

}
