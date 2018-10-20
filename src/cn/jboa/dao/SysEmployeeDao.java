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
	public void saveCla(BizClaimVoucher b);  //添加报销单
	public void saveDetail(BizClaimVoucherDetail b);  //添加报销单明细
	public List<BizClaimVoucher> findViewById(long id);
	public void update(BizClaimVoucher claimVoucher);  //修改报销单明细
	public BizClaimVoucher load(long id);
	public BizClaimVoucher findInfoById(long id);
	public void saveResult(BizCheckResult result);
	public List<BizCheckResult> findResultByClaimId(long id);
	public SysEmployee findEmpById(String sn);  //根据编号查询用户信息
	
	//普通员工
	public List<BizClaimVoucher> pageInfo(ConditionEmployee condition,String hql,Integer pageNo,Integer pageSize);
	public Integer totalCount(ConditionEmployee condition,String hql);
	
	//部门经理
	public List<BizClaimVoucher> pageInfoManage(ConditionEmployee condition,String hql,Integer pageNo,Integer pageSize);
	public Integer totalCountManage(ConditionEmployee condition,String hql);
	
	//总经理
	public List<BizClaimVoucher> pageInfoZManage(ConditionEmployee condition,String hql,Integer pageNo,Integer pageSize);
	public Integer totalCountZManage(ConditionEmployee condition,String hql);
	
	//财务
	public List<BizClaimVoucher> pageInfoCManage(ConditionEmployee condition,String hql,Integer pageNo,Integer pageSize);
	public Integer totalCountCManage(ConditionEmployee condition,String hql);
}
