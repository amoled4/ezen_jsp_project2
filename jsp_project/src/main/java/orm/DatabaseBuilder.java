package orm;

import java.io.IOException;
import java.sql.Connection;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.TransactionIsolationLevel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DatabaseBuilder {
	private static Logger log = LoggerFactory.getLogger(DatabaseBuilder.class);
	private static SqlSessionFactory factory;
	private static final String config = "orm/MybatisConfig.xml";
	
	static {
		try {
			factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader(config));
		} catch (IOException e) {
			// TODO: handle exception
			log.info("Mybatis 설정 오류");
			e.printStackTrace();
		}
	}
	public static SqlSessionFactory getFactory() {
		return factory;
	}
}
