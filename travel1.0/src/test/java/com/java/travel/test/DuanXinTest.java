package com.java.travel.test;

import com.java.travel.util.IndustrySMS;

public class DuanXinTest {

	public static void main(String[] args) {
		// ��ȡ�������˺���Ϣ
		// AccountInfo.execute();

		// ��֤��֪ͨ���Žӿ�
		int num = IndustrySMS.execute("15659561005");
		System.out.println(num);
		// ���������֤��
		// System.out.println(IndustrySMS.yanZhengNum());

		// ��ԱӪ�����Žӿ�
		// AffMarkSMS.execute();

		// ��������֤��֪ͨ���Žӿ�
		// IndustryEmailSMS.execute();

		// ��������֤��֪ͨ���Žӿ�
		// AffMarkEmailSMS.execute();

		// ������֤��
		// VoiceCode.execute();

	}
}
