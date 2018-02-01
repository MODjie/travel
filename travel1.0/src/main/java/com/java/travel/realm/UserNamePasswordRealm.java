package com.java.travel.realm;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.java.travel.entity.ExUser;
import com.java.travel.service.ExUserService;

public class UserNamePasswordRealm extends AuthorizingRealm {

	@Resource
	ExUserService exUserService;

	/**
	 * 为当限前登录的用户授予角色和权限
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 验证当前登录的用户
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//接收输入的用户名
		String nickName = (String) token.getPrincipal();	
		//查看UsernamePasswordToken可知，getCredentials()方法的返回值是char []类型的，所以不能直接转化成string。
		char [] ch = (char[]) token.getCredentials();
		//接收输入的密码
		String password = new String(ch);		
		ExUser exUser;
		// 如果用户名长度为11位，则假设是电话号码，去数据库查询，如果查询不到则返回null。
		//如果昵称长度大于11，则表示输入非法，返回null，
		//如果查询到了，则判断接收的密码，如果为验证码则表示验证码登录，否则就是普通登录，则传入正确的密码进行验证
		if (nickName.length() == 11) {
			exUser = exUserService.selectByTelphoneNum(nickName);
			if (exUser != null) {
				if (password.equals("验证码")) {
					password="验证码";
				}else  {
					password=exUser.getPASSWORD();
				}
				AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(exUser.getTEL(), password,"xx");
				return authcInfo;
			}else {
				return null;
			}
		} else if (nickName.length() > 11) {
			return null;
		} else {
			exUser = exUserService.selectByNickName(nickName);	
			if (exUser != null) {
				AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(exUser.getNICKNAME(), exUser.getPASSWORD(),
						"xx");
				return authcInfo;
			}
			else {
				return null;
			}
		}
	}

}
