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

public class TelphoneCodeRealm extends AuthorizingRealm{

	@Resource
	ExUserService exUserService;
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		String telphoneNum = (String) token.getPrincipal();
		ExUser exUser = exUserService.selectByTelphoneNum(telphoneNum);
		if (exUser != null) {
			AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(exUser.getTEL(), "ok", "xx");
			return authcInfo;
		} else {		
			return null;
		}
	}

}
