package com.java.travel.util;

import java.text.MessageFormat;



/**
 * ��֤��֪ͨ���Žӿ�
 * 
 * @ClassName: IndustrySMS
 * @Description: ��֤��֪ͨ���Žӿ�
 *
 */
public class IndustrySMS
{
	private static String operation = "/industrySMS/sendSMS";
	private static String accountSid = Config.ACCOUNT_SID;
	private static String to = "";
	private static String smsContent = "��С���Ρ�������֤��Ϊ{0,number,######}������2��������ȷ���룬��Ǳ��˲���������Դ˶��š�";
	public static int yanZhengNum;//���ɵ������֤��
	//private static String smsContent = "����������������֤��Ϊ123456������2��������ȷ���룬��Ǳ��˲���������Դ˶��š�";
	
	/**
	 * ��������֤��
	 * @return
	 */
	public static Integer yanZhengNum() {
		StringBuffer num=new StringBuffer();
		for(int i=1;i<=6;i++){
			int d=(int)(Math.random()*9+1);
			num.append(d);
			}
		yanZhengNum = Integer.parseInt(num.toString());
		smsContent = MessageFormat.format(smsContent,yanZhengNum);
		System.out.println(yanZhengNum+smsContent);
		return yanZhengNum;
	}
	
	
	/**
	 * ��֤��֪ͨ����
	 * @param phoneNum
	 * @return ������֤��
	 */
	public static int execute(String phoneNum)
	{
		int num = yanZhengNum();
		String url = Config.BASE_URL + operation;
		String body = "accountSid=" + accountSid + "&to=" + phoneNum + "&smsContent=" + smsContent
				+ HttpUtil.createCommonParam();
		System.out.println("smsContent"+smsContent);
		// �ύ����
		String result = HttpUtil.post(url, body);
		System.out.println("result:" + System.lineSeparator() + result);
		return num;
	}
}
