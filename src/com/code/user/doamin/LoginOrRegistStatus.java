package com.code.user.doamin;


/*
 * ��signָʾ��¼ע���״̬
 * 0.û�и��û�
 * 1.�������
 * 2.��¼�ɹ�
 * 3.���û��ѱ�ע��
 * 4.ע��ʧ��
 * 5.ע��ɹ�
 */

public class LoginOrRegistStatus {
	private static String message;
	
	public static String getMessage(int mes) {
		switch(mes)
		{
		case 0:{message = "û�и��û�!";break;}
		case 1:{message = "�������!";break;}
		case 2:{message = "��¼�ɹ�!";break;}
		case 3:{message = "���û��ѱ�ע��!";break;}
		case 4:{message = "ע��ʧ��!";break;}
		case 5:{message = "ע��ɹ�!";break;}
		
		}
		
		return message;
	}

}
