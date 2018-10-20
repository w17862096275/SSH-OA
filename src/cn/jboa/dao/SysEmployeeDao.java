package cn.jboa.dao;

import java.util.List;
import cn.jboa.entity.BizCheckResult;
import cn.jboa.entity.BizClaimVoucher;
import cn.jboa.entity.BizClaimVoucherDetail;
import cn.jboa.entity.ConditionEmployee;
import cn.jboa.entity.SysEmployee;

public interface SysEmployeeDao {
	public List<SysEmployee> login(String sn);
	public List<String> findIdById(long positionId,long departmentId);
	public void saveCla(BizClaimVoucher b);  //��ӱ�����
	public void saveDetail(BizClaimVoucherDetail b);  //��ӱ�������ϸ
	public List<BizClaimVoucher> findViewById(long id);
	public void update(BizClaimVoucher claimVoucher);  //�޸ı�������ϸ
	public BizClaimVoucher load(long id);
	public BizClaimVoucher findInfoById(long id);
	public void saveResult(BizCheckResult result);
	public List<BizCheckResult> findResultByClaimId(long id);
	public SysEmployee findEmpById(String sn);  //���ݱ�Ų�ѯ�û���Ϣ
	
	//��ͨԱ��
	public List<BizClaimVoucher> pageInfo(ConditionEmployee condition,String hql,Integer pageNo,Integer pageSize);
	public Integer totalCount(ConditionEmployee condition,String hql);
	
	//���ž���
	public List<BizClaimVoucher> pageInfoManage(ConditionEmployee condition,String hql,Integer pageNo,Integer pageSize);
	public Integer totalCountManage(ConditionEmployee condition,String hql);
	
	//�ܾ���
	public List<BizClaimVoucher> pageInfoZManage(ConditionEmployee condition,String hql,Integer pageNo,Integer pageSize);
	public Integer totalCountZManage(ConditionEmployee condition,String hql);
	
	//����
	public List<BizClaimVoucher> pageInfoCManage(ConditionEmployee condition,String hql,Integer pageNo,Integer pageSize);
	public Integer totalCountCManage(ConditionEmployee condition,String hql);
}
