package cn.jboa.serviceImpl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.jboa.dao.BizLeaveDao;
import cn.jboa.entity.BizClaimVoucher;
import cn.jboa.entity.BizLeave;
import cn.jboa.service.BizLeaveService;
import cn.jboa.utils.PageSupport;
@Service("bizLeaveService")
public class BizLeaveServiceImpl implements BizLeaveService{
	@Resource
	private BizLeaveDao bizLeaveDao;
	@Override
	public void saveLeave(BizLeave bizLeave) {
		bizLeaveDao.saveLeave(bizLeave);
	}
	public BizLeaveDao getBizLeaveDao() {
		return bizLeaveDao;
	}
	public void setBizLeaveDao(BizLeaveDao bizLeaveDao) {
		this.bizLeaveDao = bizLeaveDao;
	}
	@Override
	public PageSupport<BizLeave> pageInfo(BizLeave bizLeave, Integer pageNo, Integer pageSize) {
		PageSupport<BizLeave> pageSupport = null;
		try {
			StringBuilder sb = new StringBuilder("from BizLeave b where b.createEmp.sn = :createSn ");
			if(bizLeave.getStarttime()!=null){
				sb.append(" and b.starttime > :starttime");
			}
			if(bizLeave.getEndtime()!=null){
				sb.append(" and b.endtime < :endtime");
			}
			sb.append(" order by b.id desc");
			List<BizLeave> leaveList = bizLeaveDao.leavePage(bizLeave, sb.toString(), pageNo, pageSize);
			pageSupport = new PageSupport<BizLeave>();
			pageSupport.setItems(leaveList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageSupport;
	}
	@Override
	public Integer totalCount(BizLeave bizLeave) {
		Integer totalCount = 0;
		try {
			StringBuilder sb = new StringBuilder("select count(b.id) from BizLeave b where b.createEmp.sn = :createSn ");
			if(bizLeave.getStarttime()!=null){
				sb.append(" and b.starttime > :starttime");
			}
			if(bizLeave.getEndtime()!=null){
				sb.append(" and b.endtime < :endtime");
			}
			totalCount = bizLeaveDao.leavePageTotal(bizLeave, sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return totalCount;
	}
	@Override
	public BizLeave findInfoById(long id) {
		return bizLeaveDao.getInfoById(id);
	}
	@Override
	public PageSupport<BizLeave> pageBInfo(BizLeave bizLeave, Integer pageNo, Integer pageSize) {
		PageSupport<BizLeave> pageSupport = null;
		try {
			StringBuilder sb = new StringBuilder("from BizLeave b where b.createEmp.sysDepartment.id = :departmentId and b.status = '´ýÉóÅú' ");
			if(bizLeave.getStarttime()!=null){
				sb.append(" and b.starttime > :starttime");
			}
			if(bizLeave.getEndtime()!=null){
				sb.append(" and b.endtime < :endtime");
			}
			sb.append(" order by b.id desc");
			List<BizLeave> leaveList = bizLeaveDao.leavePage(bizLeave, sb.toString(), pageNo, pageSize);
			pageSupport = new PageSupport<BizLeave>();
			pageSupport.setItems(leaveList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageSupport;
	}
	@Override
	public Integer totalBCount(BizLeave bizLeave) {
		Integer totalCount = 0;
		try {
			StringBuilder sb = new StringBuilder("select count(b.id) from BizLeave b where b.createEmp.sysDepartment.id = :departmentId and b.status = '´ýÉóÅú' ");
			if(bizLeave.getStarttime()!=null){
				sb.append(" and b.starttime > :starttime");
			}
			if(bizLeave.getEndtime()!=null){
				sb.append(" and b.endtime < :endtime");
			}
			totalCount = bizLeaveDao.leavePageTotal(bizLeave, sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return totalCount;
	}
	@Override
	public void updateLeave(BizLeave bizLeave) {
		try {
			BizLeave leave = bizLeaveDao.load(bizLeave.getId());
			leave.setStatus(bizLeave.getStatus());
			leave.setApproveOpinion(bizLeave.getApproveOpinion());
			leave.setModifytime(new Date());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
