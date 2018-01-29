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

public class MyRealm extends AuthorizingRealm {

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
		String nickName = (String) token.getPrincipal();
		ExUser exUser = exUserService.selectByNickName(nickName);
		if (exUser != null) {
			AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(exUser.getNICKNAME(), exUser.getPASSWORD(), "xx");
			return authcInfo;
		} else {
			return null;
		}
	}

}
