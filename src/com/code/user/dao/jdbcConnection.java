package com.code.user.dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;
import java.sql.Connection;
import java.sql.Driver;

public class jdbcConnection{

	public Connection conn = null;
	public Statement sta = null;
	public ResultSet set = null;
	private static String driverName = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://127.0.0.1:3306/test1?characterEncoding=utf-8";
	private static String dbName = "root";
	private static String dbPassword = "123456";
	
	public jdbcConnection() 
	{
		try
		{
			Class.forName(driverName);
			System.out.println("�������سɹ�!");
		}
		catch(ClassNotFoundException  e)
		{
			System.out.println("���ݿ����Ӵ���1!");
			e.printStackTrace();
			
		}
		
		
	}
	
	//��ȡ����
	public Connection getConnection()
	{
		try
		{
			conn = DriverManager.getConnection(url,dbName,dbPassword);

			System.out.println("���ݿ����ӳɹ�!");
			
		}
		catch(SQLException e)
		{
			System.out.println("���ݿ����Ӵ���2!");
			e.printStackTrace();
		}
		if(conn==null)
		{
			System.out.println("���ݿ�����Ϊ�գ�");
			System.exit(0);
		}
		
		return conn;
	}
	
	
	 //����
	public int executeUpdate(String sql)
	{
		int result = 0;
		
		try
		{
			conn = getConnection();
			
			sta = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			result = sta.executeUpdate(sql);
			
		}
		catch(SQLException ex)
		{
			result = 0;
			
		}
		
		return result;
	
	
	}
	
	//��ѯ����
	public ResultSet executeQuery(String sql) 
	{
		try
		{
			conn = getConnection();
			
			sta = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY); //����Ϊָ�����ǰ����ƶ�����ֻ�� 
			
		    set = sta.executeQuery(sql);
		}
		catch(SQLException ex)
		{
			System.err.println(ex.getMessage());
			
		}
		
		return set;
	}
		//�ر�����
	public void close()
	{
		try
		{
			if(set!=null)
			{
			  set.close();
			}
			if(sta!=null)
			{
				sta.close();
			}
			if(conn!=null)
			{
				conn.close();
			}
			
			/*Enumeration<Driver> drivers = DriverManager.getDrivers();            //�ر����ݿ����������ֹ�ڴ�й©
			
			while(drivers.hasMoreElements())
			{
				Driver driver = drivers.nextElement();
				
				DriverManager.deregisterDriver(driver);
			}
			*/
			
		}
		catch(SQLException ex)
		{
			ex.printStackTrace(System.err);
		}
		System.out.println("���ݿ�رճɹ���");
		
	}
	

}
