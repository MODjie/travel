package com.java.travel.test;

import com.java.travel.util.IndustrySMS;

public class DuanXinTest {

	public static void main(String[] args) {
		// 获取开发者账号信息
		// AccountInfo.execute();

		// 验证码通知短信接口
		int num = IndustrySMS.execute("15659561005");
		System.out.println(num);
		// 生成随机验证码
		// System.out.println(IndustrySMS.yanZhengNum());

		// 会员营销短信接口
		// AffMarkSMS.execute();

		// 短信邮验证码通知短信接口
		// IndustryEmailSMS.execute();

		// 短信邮验证码通知短信接口
		// AffMarkEmailSMS.execute();

		// 语音验证码
		// VoiceCode.execute();

	}
}
