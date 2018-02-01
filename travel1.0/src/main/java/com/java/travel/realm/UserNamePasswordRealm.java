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
		//����������û���
		String nickName = (String) token.getPrincipal();	
		//�鿴UsernamePasswordToken��֪��getCredentials()�����ķ���ֵ��char []���͵ģ����Բ���ֱ��ת����string��
		char [] ch = (char[]) token.getCredentials();
		//�������������
		String password = new String(ch);		
		ExUser exUser;
		// ����û�������Ϊ11λ��������ǵ绰���룬ȥ���ݿ��ѯ�������ѯ�����򷵻�null��
		//����ǳƳ��ȴ���11�����ʾ����Ƿ�������null��
		//�����ѯ���ˣ����жϽ��յ����룬���Ϊ��֤�����ʾ��֤���¼�����������ͨ��¼��������ȷ�����������֤
		if (nickName.length() == 11) {
			exUser = exUserService.selectByTelphoneNum(nickName);
			if (exUser != null) {
				if (password.equals("��֤��")) {
					password="��֤��";
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
