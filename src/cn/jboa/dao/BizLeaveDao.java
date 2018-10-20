package cn.jboa.dao;

import java.util.List;

import cn.jboa.entity.BizLeave;

public interface BizLeaveDao {
	public void saveLeave(BizLeave bizleave);
	public List<BizLeave> leavePage(BizLeave bizLeave,String hql,Integer pageNo,Integer pageSize);
	public Integer leavePageTotal(BizLeave bizLeave,String hql);
	public BizLeave getInfoById(long id);
	public BizLeave load(long id);
}
