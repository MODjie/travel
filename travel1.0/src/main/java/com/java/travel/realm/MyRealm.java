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
	 * Ϊ����ǰ��¼���û������ɫ��Ȩ��
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * ��֤��ǰ��¼���û�
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
