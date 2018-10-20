package cn.jboa.service;

import cn.jboa.entity.BizLeave;
import cn.jboa.utils.PageSupport;

public interface BizLeaveService {
	public void saveLeave(BizLeave bizLeave);
	public PageSupport<BizLeave> pageInfo(BizLeave bizLeave,Integer pageNo,Integer pageSize);
	public Integer totalCount(BizLeave bizLeave);
	public BizLeave findInfoById(long id);
	public PageSupport<BizLeave> pageBInfo(BizLeave bizLeave,Integer pageNo,Integer pageSize);
	public Integer totalBCount(BizLeave bizLeave);
	public void updateLeave(BizLeave bizLeave);
}
