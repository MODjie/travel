package com.java.travel.ModularRealmAuthenticator;

import java.util.Collection;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.realm.Realm;

import com.java.travel.token.UserNamePasswordTelphoneToken;

public class MyModularRealmAuthenticator extends ModularRealmAuthenticator {
	@Override
	protected AuthenticationInfo doAuthenticate(AuthenticationToken authenticationToken)
			throws AuthenticationException {
		// TODO Auto-generated method stub
		
		// 判断getRealms()是否返回为空
        assertRealmsConfigured();
        // 强制转换回自定义的CustomizedToken
        UserNamePasswordTelphoneToken telphoneToken = (UserNamePasswordTelphoneToken) authenticationToken;
        // 所有Realm
        Collection<Realm> realms = getRealms();
     // 判断是单Realm还是多Realm
        if (realms.size() == 1)
            return doSingleRealmAuthentication(realms.iterator().next(), telphoneToken);
        else
            return doMultiRealmAuthentication(realms, telphoneToken);
	}
}
