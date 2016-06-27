package junit;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.junit.Test;

public class TestActiviti {

	
	//创建数据流执行所需要的23张表
	@Test
	public void createTable(){
		ProcessEngineConfiguration processEngineConfiguration=ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration();
		//连接数据库的配置
		processEngineConfiguration.setJdbcDriver("com.mysql.jdbc.Driver");
		processEngineConfiguration.setJdbcUrl("jdbc:mysql://localhost:3306/Activiti?useUnicode=true&characterEncoding=utf-8");
		processEngineConfiguration.setJdbcUsername("root");
		processEngineConfiguration.setJdbcPassword("brent");
		
		/**
		 	public static final String DB_SCHEMA_UPDATE_FALSE="false"; 不能自动创建表
	        public static final String DB_SCHEMA_UPDATE_CREATE_DROP="create-drop";  先删除表再创建表
	        public static final String DB_SCHEMA_UPDATE_TRUE="TRUE";  如果表不存在，则自动创建表		 
		 */
		processEngineConfiguration.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
		//工作流核心对象，ProcessEngine对象
		ProcessEngine processEngine = processEngineConfiguration.buildProcessEngine();
		System.out.println("processEngine:"+ processEngine);
	
		
		
	}
	
	
	//使用配置文件创建数据流执行所需要的23张表
	@Test
	public void creaTeble_2(){
		ProcessEngineConfiguration processEngineConfiguration=ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti-cfg.xml");
		//工作流核心对象，ProcessEngine对象
		ProcessEngine processEngine = processEngineConfiguration.buildProcessEngine();
		System.out.println("processEngine:"+ processEngine);
	}
	

}
