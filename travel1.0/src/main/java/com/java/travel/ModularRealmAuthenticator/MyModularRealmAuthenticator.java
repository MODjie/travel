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
		
		// �ж�getRealms()�Ƿ񷵻�Ϊ��
        assertRealmsConfigured();
        // ǿ��ת�����Զ����CustomizedToken
        UserNamePasswordTelphoneToken telphoneToken = (UserNamePasswordTelphoneToken) authenticationToken;
        // ����Realm
        Collection<Realm> realms = getRealms();
     // �ж��ǵ�Realm���Ƕ�Realm
        if (realms.size() == 1)
            return doSingleRealmAuthentication(realms.iterator().next(), telphoneToken);
        else
            return doMultiRealmAuthentication(realms, telphoneToken);
	}
}
