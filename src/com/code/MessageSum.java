package com.code;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;


 //��Բ�ͬ����ҳ�棬��ͬ�����ݱ���δ���

public class MessageSum 
{
	private String table_name;
	private Message message;
	private jdbcConnection conn = new jdbcConnection();
	
	public void setTable_name(String table_name)
	{
		this.table_name = table_name;
	}
	
	public String getTable_name()
	{
		return this.table_name;
	}
	
	public void setMessage(Message message)
	{
		this.message = message;
	}
	
	public Message getMessage()
	{
		return this.message;
	}
	
	//����message�͸������ݿ����
	public void addMessage(Message message)
	{
		this.setMessage(message);
		
		String sql = "insert into " + table_name + " values('" + message.getName() + "',now(),'" + message.getContent() + "');";
		
		System.out.println(sql);
		
		if(conn.executeUpdate(sql)==1)
		{
			System.out.println("���ݿ�������۳ɹ�!");
		}
		else
		{
			System.out.println("���ݿ��������ʧ��!");
		}
		
		
	}
	
	
	//�������ݿ�����ݣ�����һ������
	public Collection<Message> getMessages()
	{
		Collection<Message> set = new  ArrayList<Message>();
		String sql = "select * from " + table_name + " order by ���� desc;";
		
		System.out.println(sql);
		
		ResultSet result = conn.executeQuery(sql);
		
		try {
			
			if(result!=null)
			{
			while(result.next())
			{
				Message tempt = new Message();
				
				tempt.setName(result.getString("�û���"));
				tempt.setDay(result.getString("����"));
				tempt.setContent(result.getString("����"));
				
				set.add(tempt);
				
			}
			}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
		return set;
	}

	
	
}
