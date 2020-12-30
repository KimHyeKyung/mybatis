package mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisManager {
	
	//static을 쓰면 MybatisManager.sqlSessionFactory로 접근 가능하다!!
	private static SqlSessionFactory sqlSessionFactory;
	

	public static SqlSessionFactory getSqlSessionFactory() {
		//처음 접속할때 한번만 만들자!
		if(sqlSessionFactory == null) {
			new MybatisManager();//초기화
		}
		return sqlSessionFactory;
	}
	
	
	//생성자를통한 외부 생성제한
	private MybatisManager() {
		String resource = "mybatis/mybatis-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
