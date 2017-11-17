package cn.com;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.com.bean.Employee;

public class SelectDemo {

	private static volatile String a = null;
	public static void main(String[] args) throws Exception {
		InputStream inputStream = Resources.getResourceAsStream("mybatisConfig.xml");
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory factory = builder.build(inputStream);
		SqlSession sqlSession = factory.openSession();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("salary", 10000);
		List<Employee> result = sqlSession.selectList("cn.com.dao.EmployeesMapper.selectByMinSalary",
				params);
		List<Employee> result1 = sqlSession.selectList("cn.com.dao.EmployeesMapper.selectByMinSalary");
		params.put("EMPLOYEE_ID", 1);
		List<Employee> result2 = sqlSession.selectList("cn.com.dao.EmployeesMapper.selectByPrimaryKey");
		System.out.println(result.size());
		System.out.println(result1.size());
		System.out.println(result2.size());
	}

}