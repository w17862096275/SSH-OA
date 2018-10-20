package cn.jboa.serviceImpl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import cn.jboa.dao.SysEmployeeDao;
import cn.jboa.entity.BizCheckResult;
import cn.jboa.entity.BizClaimVoucher;
import cn.jboa.entity.BizClaimVoucherDetail;
import cn.jboa.entity.ConditionEmployee;
import cn.jboa.entity.SysEmployee;
import cn.jboa.service.SysEmployeeService;
import cn.jboa.utils.PageSupport;
@Service("employeeService")
public class SysEmployeeServiceImpl implements SysEmployeeService{
	@Resource
	private SysEmployeeDao employeeDao;
	@Override
	public SysEmployee login(SysEmployee employee) {
		SysEmployee emp = new SysEmployee();
		List<SysEmployee> employeeList = employeeDao.login(employee.getSn());
		if(employeeList.size()>0&&employeeList!=null){
			emp = (SysEmployee)employeeList.get(0);
			if(emp.getPassword().equals(employee.getPassword())){
				emp.setMark("2"); //正确
				return emp;
			}else{
				emp.setMark("1"); //密码错误
			}
		}else{
			emp.setMark("0"); //编号错误
		}
		return emp;
	}
	public SysEmployeeDao getEmployeeDao() {
		return employeeDao;
	}
	public void setEmployeeDao(SysEmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	@Override
	public String findIdByCondition(long positionId, long departmentId) {
		List<String> list = employeeDao.findIdById(positionId, departmentId);
		String sn = list.get(0);
		return sn;
	}
	@Override
	public int saveBxd(BizClaimVoucher v,List<BizClaimVoucherDetail> list) {
		int line = 0;
		try {
			employeeDao.saveCla(v);
			for(int i=0;i<list.size();i++){
				BizClaimVoucherDetail b = list.get(i);
				b.setBizClaimVoucher(v);
				employeeDao.saveDetail(b);
			}
			line = 1;
		} catch (Exception e) {
			e.printStackTrace();
			line = 0;
		}
		return line;
	}
	@Override
	public PageSupport<BizClaimVoucher> pageList(ConditionEmployee condition, Integer pageNo, Integer pageSize) {
		PageSupport<BizClaimVoucher> pageSupport = null;
		try {
			StringBuilder sb = new StringBuilder("from BizClaimVoucher b "
					+ "where b.sysEmployeeByCreateSn.sn = :sn ");
			if(condition.getStatus()!=null&&!condition.getStatus().equals("")&&!condition.getStatus().equals("全部")){
				sb.append("and b.status = :status ");
			}
			if(condition.getBeginTime()!=null){
				sb.append("and b.createTime > :beginTime ");
			}
			if(condition.getEndTime()!=null){
				sb.append("and b.createTime < :endTime ");
			}
			sb.append("order by b.status asc,b.createTime desc ");
			List<BizClaimVoucher> infoList = employeeDao.pageInfo(condition,sb.toString(), pageNo, pageSize);
			pageSupport = new PageSupport<BizClaimVoucher>();
			pageSupport.setItems(infoList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageSupport;
	}
	@Override
	public Integer findtotalCount(ConditionEmployee condition) {
		Integer line = null;
		try {
			StringBuilder sb = new StringBuilder("select count(b.id) "
					+ "from BizClaimVoucher b "
					+ "where b.sysEmployeeByCreateSn.sn = :sn ");
			if(condition.getStatus()!=null&&condition.getStatus()!=""&&!condition.getStatus().equals("全部")){
				sb.append("and b.status = :status ");
			}
			if(condition.getBeginTime()!=null){
				sb.append("and b.createTime > :beginTime ");
			}
			if(condition.getEndTime()!=null){
				sb.append("and b.createTime < :endTime ");
			}
			sb.append("order by b.status asc,b.createTime desc ");
			line = employeeDao.totalCount(condition, sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return line;
	}
	@Override
	public List<BizClaimVoucher> findViewInfo(long id) {
		return employeeDao.findViewById(id);
	}
	@Override
	public void update(BizClaimVoucher claimVoucher) {
		employeeDao.update(claimVoucher);
	}
	@Override
	public BizClaimVoucher load(long id) {
		BizClaimVoucher bb = null;
		try {
			bb = employeeDao.load(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bb;
	}
	@Override
	public PageSupport<BizClaimVoucher> pageListManage(ConditionEmployee condition, Integer pageNo, Integer pageSize) {
		PageSupport<BizClaimVoucher> pageSupport = null;
		try {
			StringBuilder sb = new StringBuilder("from BizClaimVoucher b "
					+ "where b.sysEmployeeByCreateSn.sysDepartment.id = :departmentId and b.status != '新创建' ");
			if(condition.getStatus()!=null&&!condition.getStatus().equals("")&&!condition.getStatus().equals("全部")){
				sb.append("and b.status = :status ");
			}
			if(condition.getBeginTime()!=null){
				sb.append("and b.createTime > :beginTime ");
			}
			if(condition.getEndTime()!=null){
				sb.append("and b.createTime < :endTime ");
			}
			sb.append("order by b.status asc,b.createTime desc ");
			List<BizClaimVoucher> infoList = employeeDao.pageInfo(condition,sb.toString(), pageNo, pageSize);
			pageSupport = new PageSupport<BizClaimVoucher>();
			pageSupport.setItems(infoList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageSupport;
	}
	@Override
	public Integer findtotalCountManage(ConditionEmployee condition) {
		Integer line = null;
		try {
			StringBuilder sb = new StringBuilder("select count(b.id) "
					+ "from BizClaimVoucher b "
					+ "where b.sysEmployeeByCreateSn.sysDepartment.id = :departmentId and b.status != '新创建' ");
			if(condition.getStatus()!=null&&condition.getStatus()!=""&&!condition.getStatus().equals("全部")){
				sb.append("and b.status = :status ");
			}
			if(condition.getBeginTime()!=null){
				sb.append("and b.createTime > :beginTime ");
			}
			if(condition.getEndTime()!=null){
				sb.append("and b.createTime < :endTime ");
			}
			sb.append("order by b.status asc,b.createTime desc ");
			line = employeeDao.totalCountManage(condition, sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return line;
	}
	@Override
	public BizClaimVoucher findInfoById(long id) {
		return employeeDao.findInfoById(id);
	}
	@Override
	public void saveResult(BizCheckResult result) {
		employeeDao.saveResult(result);
	}
	@Override
	public PageSupport<BizClaimVoucher> pageListZManage(ConditionEmployee condition, Integer pageNo, Integer pageSize) {
		PageSupport<BizClaimVoucher> pageSupport = null;
		try {
			StringBuilder sb = new StringBuilder("from BizClaimVoucher b "
					+ "where b.sysEmployeeByNextDealSn.sn = :sn and b.status != '新创建' ");
			if(condition.getStatus()!=null&&!condition.getStatus().equals("")&&!condition.getStatus().equals("全部")){
				sb.append("and b.status = :status ");
			}
			if(condition.getBeginTime()!=null){
				sb.append("and b.createTime > :beginTime ");
			}
			if(condition.getEndTime()!=null){
				sb.append("and b.createTime < :endTime ");
			}
			sb.append("order by b.status asc,b.createTime desc ");
			List<BizClaimVoucher> infoList = employeeDao.pageInfoZManage(condition,sb.toString(), pageNo, pageSize);
			pageSupport = new PageSupport<BizClaimVoucher>();
			pageSupport.setItems(infoList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageSupport;
	}
	@Override
	public Integer findtotalCountZManage(ConditionEmployee condition) {
		Integer line = null;
		try {
			StringBuilder sb = new StringBuilder("select count(b.id) "
					+ "from BizClaimVoucher b "
					+ "where b.sysEmployeeByNextDealSn.sn = :sn and b.status != '新创建' ");
			if(condition.getStatus()!=null&&condition.getStatus()!=""&&!condition.getStatus().equals("全部")){
				sb.append("and b.status = :status ");
			}
			if(condition.getBeginTime()!=null){
				sb.append("and b.createTime > :beginTime ");
			}
			if(condition.getEndTime()!=null){
				sb.append("and b.createTime < :endTime ");
			}
			sb.append("order by b.status asc,b.createTime desc ");
			line = employeeDao.totalCountZManage(condition, sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return line;
	}
	@Override
	public List<BizCheckResult> findResultByClaimId(long id) {
		return employeeDao.findResultByClaimId(id);
	}
	@Override
	public PageSupport<BizClaimVoucher> pageListCManage(ConditionEmployee condition, Integer pageNo, Integer pageSize) {
		PageSupport<BizClaimVoucher> pageSupport = null;
		try {
			StringBuilder sb = new StringBuilder("from BizClaimVoucher b "
					+ "where b.sysEmployeeByNextDealSn.sn = :sn and b.status = '已审批' ");
			if(condition.getStatus()!=null&&!condition.getStatus().equals("")&&!condition.getStatus().equals("全部")){
				sb.append("and b.status = :status ");
			}
			if(condition.getBeginTime()!=null){
				sb.append("and b.createTime > :beginTime ");
			}
			if(condition.getEndTime()!=null){
				sb.append("and b.createTime < :endTime ");
			}
			sb.append("order by b.status asc,b.createTime desc ");
			List<BizClaimVoucher> infoList = employeeDao.pageInfoCManage(condition,sb.toString(), pageNo, pageSize);
			pageSupport = new PageSupport<BizClaimVoucher>();
			pageSupport.setItems(infoList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageSupport;
	}
	@Override
	public Integer findtotalCountCManage(ConditionEmployee condition) {
		Integer line = null;
		try {
			StringBuilder sb = new StringBuilder("select count(b.id) "
					+ "from BizClaimVoucher b "
					+ "where b.sysEmployeeByNextDealSn.sn = :sn and b.status = '已审批' ");
			if(condition.getStatus()!=null&&condition.getStatus()!=""&&!condition.getStatus().equals("全部")){
				sb.append("and b.status = :status ");
			}
			if(condition.getBeginTime()!=null){
				sb.append("and b.createTime > :beginTime ");
			}
			if(condition.getEndTime()!=null){
				sb.append("and b.createTime < :endTime ");
			}
			sb.append("order by b.status asc,b.createTime desc ");
			line = employeeDao.totalCountCManage(condition, sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return line;
	}
	@Override
	public SysEmployee findEmpBySn(String sn) {
		return employeeDao.findEmpById(sn);
	}
	
}
