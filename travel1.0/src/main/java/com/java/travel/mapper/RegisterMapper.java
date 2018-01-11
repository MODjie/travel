package com.java.travel.mapper;

import com.java.travel.entity.Register;

public interface RegisterMapper {
    /**
     * ͨ��ע����ɾ��ע���û�
     * @param REGISTERID
     * @return
     */
	int deleteByPrimaryKey(Short REGISTERID);

    /**
     * ���ע���û�
     * @param record
     * @return
     */
    int insert(Register record);
    
    /**
     * ����һ������,ֻ���벻Ϊnull���ֶ�,����Ӱ����Ĭ��ֵ���ֶ�
     * ֧��Oracle����,UUID,����Mysql��INDENTITY�Զ�����(�Զ���д)
     * ����ʹ�ô���Ĳ���ֵ,����ֵ��ʱ,�Ż�ʹ�����С�UUID,�Զ�����
     * @param record
     * @return
     */
    int insertSelective(Register record);

    Register selectByPrimaryKey(Short REGISTERID);

    int updateByPrimaryKeySelective(Register record);

    int updateByPrimaryKey(Register record);
}