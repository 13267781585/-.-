package com.code.user.dao;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.code.user.doamin.User;

public class UserDao {
	private jdbcConnection conn = new jdbcConnection();
	
	//�����Ƿ���ڸ��û����з��ظ��û���Ϣ��û���򷵻�null
	
	public User findUser(String name) {
		String sql = "select * from food_person_information where �û��� = '"+name+"';";
		System.out.println(sql);
		
		ResultSet set = conn.executeQuery(sql);
		try {
			if(set.next()) {
				User tempt = new User();
				tempt.setName(name);
				tempt.setPassword(set.getString("����"));
				
				conn.close();
				
				return tempt;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		conn.close();
		
		return null;
		
	}
	
	//����û�
	public boolean add(User user)
	{
		String name = user.getName();
		String password = user.getPassword();
		
		String sql = "insert into food_person_information values('"+name+"','"+password+"',now());";
		
		System.out.println(sql);
		
		int resultRow = conn.executeUpdate(sql);
		
		conn.close();
		
		if(resultRow==0)
			return true;
		return false;
		
	}

}
