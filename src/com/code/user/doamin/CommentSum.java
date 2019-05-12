package com.code.user.doamin;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.code.user.dao.jdbcConnection;


 //��Բ�ͬ����ҳ�棬��ͬ�����ݱ���δ���

public class CommentSum 
{
	private String table_name;
	private Comment comment;
	private jdbcConnection conn = new jdbcConnection();
	
	public void setTable_name(String table_name)
	{
		this.table_name = table_name;
	}
	
	public String getTable_name()
	{
		return this.table_name;
	}
	
	public void setMessage(Comment comment)
	{
		this.comment = comment;
	}
	
	public Comment getMessage()
	{
		return this.comment;
	}
	
	//����message�͸������ݿ����
	public void addMessage(Comment comment)
	{
		this.setMessage(comment);
		
		String sql = "insert into " + table_name + " values('" + comment.getName() + "',now(),'" + comment.getContent() + "');";
		
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
	public Collection<Comment> getMessages()
	{
		Collection<Comment> set = new  ArrayList<Comment>();
		String sql = "select * from " + table_name + " order by ���� desc;";
		
		System.out.println(sql);
		
		ResultSet result = conn.executeQuery(sql);
		
		try {
			
			if(result!=null)
			{
			while(result.next())
			{
				Comment tempt = new Comment();
				
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
