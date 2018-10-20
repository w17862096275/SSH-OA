package cn.jboa.service;

import java.util.List;
import cn.jboa.entity.BizCheckResult;
import cn.jboa.entity.BizClaimVoucher;
import cn.jboa.entity.BizClaimVoucherDetail;
import cn.jboa.entity.ConditionEmployee;
import cn.jboa.entity.SysEmployee;
import cn.jboa.utils.PageSupport;

public interface SysEmployeeService {
	public SysEmployee login(SysEmployee employee);
	public String findIdByCondition(long positionId,long departmentId);  //查询部门经理
	public int saveBxd(BizClaimVoucher v,List<BizClaimVoucherDetail> list);  //添加有关报销单事务
	public List<BizClaimVoucher> findViewInfo(long id);
	public void update(BizClaimVoucher claimVoucher);
	public BizClaimVoucher load(long id);
	public BizClaimVoucher findInfoById(long id);
	public void saveResult(BizCheckResult result);
	public List<BizCheckResult> findResultByClaimId(long id);
	public SysEmployee findEmpBySn(String sn);
	
	//员工
	public PageSupport<BizClaimVoucher> pageList(ConditionEmployee condition,Integer pageNo,Integer pageSize);
	public Integer findtotalCount(ConditionEmployee condition);
	
	//部门经理
	public PageSupport<BizClaimVoucher> pageListManage(ConditionEmployee condition,Integer pageNo,Integer pageSize);
	public Integer findtotalCountManage(ConditionEmployee condition);
	
	//总经理
	public PageSupport<BizClaimVoucher> pageListZManage(ConditionEmployee condition,Integer pageNo,Integer pageSize);
	public Integer findtotalCountZManage(ConditionEmployee condition);
	
	//财务
	public PageSupport<BizClaimVoucher> pageListCManage(ConditionEmployee condition,Integer pageNo,Integer pageSize);
	public Integer findtotalCountCManage(ConditionEmployee condition);
}
