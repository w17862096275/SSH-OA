package cn.jboa.action;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.jboa.entity.BizLeave;
import cn.jboa.entity.SysEmployee;
import cn.jboa.service.BizLeaveService;
import cn.jboa.service.SysEmployeeService;
import cn.jboa.utils.PageSupport;

public class BizLeaveAction extends ActionSupport{
	private BizLeave leave;
	private Map<String,String> leaveTypeMap;  //请假类型
	private PageSupport<BizLeave> pageSupport;
	private Date startDate;
	private Date endDate;
	private Integer pageNo;
	@Resource
	private SysEmployeeService employeeService;
	@Resource
	private BizLeaveService bizLeaveService;
	
	public String toEdit(){
		Map map = ActionContext.getContext().getSession();
		leaveTypeMap = new HashMap<String,String>();
		leaveTypeMap.put("年假", "年假");
		leaveTypeMap.put("事假", "事假");
		leaveTypeMap.put("病假", "病假");
		leaveTypeMap.put("婚假", "婚假");
		return "success";
	}
	public String Edit(){
		Map map = ActionContext.getContext().getSession();
		SysEmployee emp = (SysEmployee)map.get("employee");
		SysEmployee nextEmp = (SysEmployee)map.get("manager");
		leave.setCreateEmp(emp);
		leave.setNextEmp(nextEmp);
		leave.setStatus("待审批");
		leave.setCreatetime(new Date());
		bizLeaveService.saveLeave(leave);//--------------添加成功后跳转到action显示请假list
		return "success";
	}
	public String searchLeave(){
		Map map = ActionContext.getContext().getSession();
		SysEmployee emp = (SysEmployee)map.get("employee");
		if(emp.getSysPosition().getNameCn().equals("员工")){
			BizLeave bizLeave = new BizLeave();
			bizLeave.setCreateSn(emp.getSn());
			pageSupport = bizLeaveService.pageInfo(bizLeave, 1, 5);
			pageSupport.setCurrPageNo(1);
			pageSupport.setPageSize(5);
			int totalCount = bizLeaveService.totalCount(bizLeave);
			pageSupport.setTotalCount(totalCount);
			int totalPageCount = totalCount%5==0?totalCount/5:totalCount/5+1;
			pageSupport.setTotalPageCount(totalPageCount);
			return "success";
		}else if(emp.getSysPosition().getNameCn().equals("部门经理")){
			BizLeave bizLeave = new BizLeave();
			bizLeave.setDepartmentId(emp.getSysDepartment().getId());
			pageSupport = bizLeaveService.pageBInfo(bizLeave, 1, 5);
			pageSupport.setCurrPageNo(1);
			pageSupport.setPageSize(5);
			int totalCount = bizLeaveService.totalBCount(bizLeave);
			pageSupport.setTotalCount(totalCount);
			int totalPageCount = totalCount%5==0?totalCount/5:totalCount/5+1;
			pageSupport.setTotalPageCount(totalPageCount);
			return "success";
		}else{
			return "input";
		}
	}
	public String pageSearchLeave(){
		Map map = ActionContext.getContext().getSession();
		SysEmployee emp = (SysEmployee)map.get("employee");
		if(emp.getSysPosition().getNameCn().equals("员工")){
			BizLeave bizLeave = new BizLeave();
			bizLeave.setCreateSn(emp.getSn());
			bizLeave.setStarttime(startDate);
			bizLeave.setEndtime(endDate);
			int totalCount = bizLeaveService.totalCount(bizLeave);
			int totalPageCount = totalCount%5==0?totalCount/5:totalCount/5+1;
			if(pageNo<=0){
				pageNo = 1;
			}
			if(pageNo>=totalPageCount){
				pageNo = totalPageCount;
			}
			pageSupport = bizLeaveService.pageInfo(bizLeave, pageNo, 5);
			pageSupport.setCurrPageNo(pageNo);
			pageSupport.setPageSize(5);
			pageSupport.setTotalCount(totalCount);
			pageSupport.setTotalPageCount(totalPageCount);
			return "success";
		}else if(emp.getSysPosition().getNameCn().equals("部门经理")){
			BizLeave bizLeave = new BizLeave();
			bizLeave.setDepartmentId(emp.getSysDepartment().getId());
			bizLeave.setStarttime(startDate);
			bizLeave.setEndtime(endDate);
			int totalCount = bizLeaveService.totalBCount(bizLeave);
			int totalPageCount = totalCount%5==0?totalCount/5:totalCount/5+1;
			if(pageNo<=0){
				pageNo = 1;
			}
			if(pageNo>=totalPageCount){
				pageNo = totalPageCount;
			}
			pageSupport = bizLeaveService.pageBInfo(bizLeave, pageNo, 5);
			pageSupport.setCurrPageNo(pageNo);
			pageSupport.setPageSize(5);
			pageSupport.setTotalCount(totalCount);
			pageSupport.setTotalPageCount(totalPageCount);
			return "success";
		}else{
			return "input";
		}
	}
	public String getLeaveById(){
		leave = bizLeaveService.findInfoById(leave.getId());
		return "success";
	}
	public String toCheck(){
		leave = bizLeaveService.findInfoById(leave.getId());
		return "success";
	}
	public String checkLeave(){
		bizLeaveService.updateLeave(leave);
		return "success";
	}
	public Map<String, String> getLeaveTypeMap() {
		return leaveTypeMap;
	}
	public void setLeaveTypeMap(Map<String, String> leaveTypeMap) {
		this.leaveTypeMap = leaveTypeMap;
	}
	public SysEmployeeService getEmployeeService() {
		return employeeService;
	}
	public void setEmployeeService(SysEmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	public BizLeave getLeave() {
		return leave;
	}
	public void setLeave(BizLeave leave) {
		this.leave = leave;
	}
	public PageSupport<BizLeave> getPageSupport() {
		return pageSupport;
	}
	public void setPageSupport(PageSupport<BizLeave> pageSupport) {
		this.pageSupport = pageSupport;
	}
	public BizLeaveService getBizLeaveService() {
		return bizLeaveService;
	}
	public void setBizLeaveService(BizLeaveService bizLeaveService) {
		this.bizLeaveService = bizLeaveService;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	
}
