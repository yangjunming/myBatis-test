package cn.com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.com.bean.Employee;

public interface EmployeesMapper {

	public List<Employee> selectByPrimaryKey(@Param("employeeId") int employeeId);

	public List<Employee> selectByMinSalary(@Param("minSalary") int minSalary);

}
