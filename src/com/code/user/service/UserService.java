package com.code.user.service;

import com.code.user.dao.UserDao;
import com.code.user.doamin.User;

public class UserService {
	private UserDao userDao = new UserDao();
	private int sign = 0;
	
	/*
	 * ��signָʾ��¼ע���״̬
	 * 0.û�и��û�
	 * 1.�������
	 * 2.��¼�ɹ�
	 * 3.���û��ѱ�ע��
	 * 4.ע��ʧ��
	 * 5.ע��ɹ�
	 */
	
	//��¼��֤
	public int login(User loginUser)
	{
		User user = userDao.findUser(loginUser.getName());
		
		if(user!=null) {
			if(loginUser.getPassword().equals(user.getPassword()))
				sign = 2;
			else
				sign = 1;
			
		}
		else {
			sign = 0;
		}
		return sign;
	}
	
	//ע����֤
	
	public int regist(User registUser)
	{
		User user = userDao.findUser(registUser.getName());
		
		if(user!=null) {
			sign = 3;
			
		}
		else {
			
			if(userDao.add(registUser))
			{
				sign = 4;
				
			}
			else
				sign = 5;
		}
		return sign;
	}

}
