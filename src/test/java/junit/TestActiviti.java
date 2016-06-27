package junit;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.junit.Test;

public class TestActiviti {

	
	//����������ִ������Ҫ��23�ű�
	@Test
	public void createTable(){
		ProcessEngineConfiguration processEngineConfiguration=ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration();
		//�������ݿ������
		processEngineConfiguration.setJdbcDriver("com.mysql.jdbc.Driver");
		processEngineConfiguration.setJdbcUrl("jdbc:mysql://localhost:3306/Activiti?useUnicode=true&characterEncoding=utf-8");
		processEngineConfiguration.setJdbcUsername("root");
		processEngineConfiguration.setJdbcPassword("brent");
		
		/**
		 	public static final String DB_SCHEMA_UPDATE_FALSE="false"; �����Զ�������
	        public static final String DB_SCHEMA_UPDATE_CREATE_DROP="create-drop";  ��ɾ�����ٴ�����
	        public static final String DB_SCHEMA_UPDATE_TRUE="TRUE";  ��������ڣ����Զ�������		 
		 */
		processEngineConfiguration.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
		//���������Ķ���ProcessEngine����
		ProcessEngine processEngine = processEngineConfiguration.buildProcessEngine();
		System.out.println("processEngine:"+ processEngine);
	
		
		
	}
	
	
	//ʹ�������ļ�����������ִ������Ҫ��23�ű�
	@Test
	public void creaTeble_2(){
		ProcessEngineConfiguration processEngineConfiguration=ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti-cfg.xml");
		//���������Ķ���ProcessEngine����
		ProcessEngine processEngine = processEngineConfiguration.buildProcessEngine();
		System.out.println("processEngine:"+ processEngine);
	}
	

}
