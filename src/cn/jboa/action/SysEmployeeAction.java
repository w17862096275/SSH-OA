package cn.jboa.action;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.jboa.entity.BizCheckResult;
import cn.jboa.entity.BizClaimVoucher;
import cn.jboa.entity.BizClaimVoucherDetail;
import cn.jboa.entity.ConditionEmployee;
import cn.jboa.entity.PageBcvInfo;
import cn.jboa.entity.SysEmployee;
import cn.jboa.service.SysEmployeeService;
import cn.jboa.utils.PageSupport;

public class SysEmployeeAction extends ActionSupport{
	private Date dateNow;
	private BizClaimVoucher claimVoucher;
	private BizClaimVoucherDetail claimVoucherDetail;
	private List<BizClaimVoucherDetail> detailList;
	private Map<String,String> statusMap;
	private PageSupport<BizClaimVoucher> pageSupport;
	private ConditionEmployee condition;
	private Integer pageNo;
	private Integer pageSize;
	private List<BizClaimVoucherDetail> sets;
	private Integer rowNumber;
	private BizCheckResult checkResult;
	@Resource
	private SysEmployeeService employeeService;
	/**
	 * ��ʾ���ҳ��
	 * @return
	 */
	public String toadd(){
		dateNow = new Date();
		return "success";
	}
	/**
	 * ��ӱ������Լ���ϸ
	 * @return
	 */
	public String add(){
		Map map = ActionContext.getContext().getSession();
		SysEmployee emp = (SysEmployee)map.get("employee");
		//��ȡ�´������
		String next = employeeService.findIdByCondition(2, emp.getSysDepartment().getId());
		if(claimVoucher.getStatus().equals("�´���")){
			next = emp.getSn();
		}
		SysEmployee sysEmployeeByNextDealSn = new SysEmployee();
		sysEmployeeByNextDealSn.setSn(next);
		SysEmployee sysEmployeeByCreateSn = new SysEmployee();
		sysEmployeeByCreateSn.setSn(emp.getSn());
		claimVoucher.setSysEmployeeByNextDealSn(sysEmployeeByNextDealSn); //���´�XX�˸�ֵ
		claimVoucher.setSysEmployeeByCreateSn(sysEmployeeByCreateSn);  //�������߸�ֵ
		claimVoucher.setCreateTime(new Date());  //����ʱ��
		claimVoucher.setModifyTime(new Date());  //����޸�ʱ��
		int line = employeeService.saveBxd(claimVoucher, detailList);
		System.out.println(line);
		return "success";
	}
	/**
	 * ��ʾ��ѯҳ��
	 * @return
	 */
	public String searchClaimVoucher(){
		Map map = ActionContext.getContext().getSession();
		SysEmployee emp = (SysEmployee)map.get("employee");
		statusMap = new HashMap<String,String>();
		if(emp.getSysPosition().getNameCn().equals("Ա��")){
			statusMap.put("����ֹ", "����ֹ");
			statusMap.put("�´���", "�´���");
			statusMap.put("�Ѹ���", "�Ѹ���");
			statusMap.put("������", "������");
			statusMap.put("������", "������");
			statusMap.put("�Ѵ��", "�Ѵ��");
			statusMap.put("���ύ", "���ύ");
			condition = new ConditionEmployee();
			condition.setSn(emp.getSn());
			int totalCount = employeeService.findtotalCount(condition);
			int totalPageCount = totalCount%5==0?totalCount/5:totalCount/5+1;
			pageSupport = employeeService.pageList(condition, 1, 5);
			pageSupport.setCurrPageNo(1);
			pageSupport.setPageSize(5);
			pageSupport.setTotalCount(totalCount);
			pageSupport.setTotalPageCount(totalPageCount);
			return "success";
		}else if(emp.getSysPosition().getNameCn().equals("���ž���")){
			statusMap.put("����ֹ", "����ֹ");
			statusMap.put("�Ѹ���", "�Ѹ���");
			statusMap.put("������", "������");
			statusMap.put("������", "������");
			statusMap.put("�Ѵ��", "�Ѵ��");
			statusMap.put("���ύ", "���ύ");
			condition = new ConditionEmployee();
			condition.setDepartmentId(emp.getSysDepartment().getId());
			condition.setSn(emp.getSn());
			int totalCount = employeeService.findtotalCountManage(condition);
			int totalPageCount = totalCount%5==0?totalCount/5:totalCount/5+1;
			pageSupport = employeeService.pageListManage(condition, 1, 5);
			pageSupport.setCurrPageNo(1);
			pageSupport.setPageSize(5);
			pageSupport.setTotalCount(totalCount);
			pageSupport.setTotalPageCount(totalPageCount);
			return "success";
		}else if(emp.getSysPosition().getNameCn().equals("�ܾ���")){
			statusMap.put("����ֹ", "����ֹ");
			statusMap.put("�Ѹ���", "�Ѹ���");
			statusMap.put("������", "������");
			statusMap.put("������", "������");
			statusMap.put("�Ѵ��", "�Ѵ��");
			statusMap.put("���ύ", "���ύ");
			condition = new ConditionEmployee();
			condition.setDepartmentId(emp.getSysDepartment().getId());
			condition.setSn(emp.getSn());
			int totalCount = employeeService.findtotalCountZManage(condition);
			int totalPageCount = totalCount%5==0?totalCount/5:totalCount/5+1;
			pageSupport = employeeService.pageListZManage(condition, 1, 5);
			pageSupport.setCurrPageNo(1);
			pageSupport.setPageSize(5);
			pageSupport.setTotalCount(totalCount);
			pageSupport.setTotalPageCount(totalPageCount);
			return "success";
		}else if(emp.getSysPosition().getNameCn().equals("����")){
			statusMap.put("������", "������");
			condition = new ConditionEmployee();
			condition.setDepartmentId(emp.getSysDepartment().getId());
			condition.setSn(emp.getSn());
			int totalCount = employeeService.findtotalCountCManage(condition);
			int totalPageCount = totalCount%5==0?totalCount/5:totalCount/5+1;
			pageSupport = employeeService.pageListCManage(condition, 1, 5);
			pageSupport.setCurrPageNo(1);
			pageSupport.setPageSize(5);
			pageSupport.setTotalCount(totalCount);
			pageSupport.setTotalPageCount(totalPageCount);
			return "success";
		}else{
			return "input";
		}
		
	}
	/**
	 * �����ҳ
	 * @return
	 */
	public String pageSearchClaimVoucher(){
		Map map = ActionContext.getContext().getSession();
		SysEmployee emp = (SysEmployee)map.get("employee");
		statusMap = new HashMap<String,String>();
		if(emp.getSysPosition().getNameCn().equals("Ա��")){
			statusMap.put("����ֹ", "����ֹ");
			statusMap.put("�´���", "�´���");
			statusMap.put("�Ѹ���", "�Ѹ���");
			statusMap.put("������", "������");
			statusMap.put("������", "������");
			statusMap.put("�Ѵ��", "�Ѵ��");
			statusMap.put("���ύ", "���ύ");
			if(pageNo==null){
				pageNo = 1;
			}
			if(pageSize==null){
				pageSize = 5;
			}
			condition.setSn(emp.getSn());
			if(condition.getStatus().equals("ȫ��")){
				condition.setStatus("");
			}
			int totalCount = employeeService.findtotalCount(condition);
			int totalPageCount = totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
			if(pageNo<=0){
				pageNo = 1;
			}
			if(pageNo>=totalPageCount){
				pageNo = totalPageCount;
			}
			pageSupport = employeeService.pageList(condition, pageNo, pageSize);
			pageSupport.setCurrPageNo(pageNo);
			pageSupport.setPageSize(pageSize);
			pageSupport.setTotalCount(totalCount);
			pageSupport.setTotalPageCount(totalPageCount);
			return "success";
		}else if(emp.getSysPosition().getNameCn().equals("���ž���")){
			statusMap.put("����ֹ", "����ֹ");
			statusMap.put("�Ѹ���", "�Ѹ���");
			statusMap.put("������", "������");
			statusMap.put("������", "������");
			statusMap.put("�Ѵ��", "�Ѵ��");
			statusMap.put("���ύ", "���ύ");
			if(pageNo==null){
				pageNo = 1;
			}
			if(pageSize==null){
				pageSize = 5;
			}
			condition.setDepartmentId(emp.getSysDepartment().getId());
			condition.setSn(emp.getSn());
			if(condition.getStatus().equals("ȫ��")){
				condition.setStatus("");
			}
			int totalCount = employeeService.findtotalCountManage(condition);
			int totalPageCount = totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
			if(pageNo<=0){
				pageNo = 1;
			}
			if(pageNo>=totalPageCount){
				pageNo = totalPageCount;
			}
			pageSupport = employeeService.pageListManage(condition, pageNo, pageSize);
			pageSupport.setCurrPageNo(pageNo);
			pageSupport.setPageSize(pageSize);
			pageSupport.setTotalCount(totalCount);
			pageSupport.setTotalPageCount(totalPageCount);
			return "success";
		}else if(emp.getSysPosition().getNameCn().equals("�ܾ���")){
			statusMap.put("����ֹ", "����ֹ");
			statusMap.put("�Ѹ���", "�Ѹ���");
			statusMap.put("������", "������");
			statusMap.put("������", "������");
			statusMap.put("�Ѵ��", "�Ѵ��");
			statusMap.put("���ύ", "���ύ");
			if(pageNo==null){
				pageNo = 1;
			}
			if(pageSize==null){
				pageSize = 5;
			}
			condition.setDepartmentId(emp.getSysDepartment().getId());
			condition.setSn(emp.getSn());
			if(condition.getStatus().equals("ȫ��")){
				condition.setStatus("");
			}
			int totalCount = employeeService.findtotalCountZManage(condition);
			int totalPageCount = totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
			if(pageNo<=0){
				pageNo = 1;
			}
			if(pageNo>=totalPageCount){
				pageNo = totalPageCount;
			}
			pageSupport = employeeService.pageListZManage(condition, pageNo, pageSize);
			pageSupport.setCurrPageNo(pageNo);
			pageSupport.setPageSize(pageSize);
			pageSupport.setTotalCount(totalCount);
			pageSupport.setTotalPageCount(totalPageCount);
			return "success";
		}else if(emp.getSysPosition().getNameCn().equals("����")){
			statusMap.put("������", "������");
			if(pageNo==null){
				pageNo = 1;
			}
			if(pageSize==null){
				pageSize = 5;
			}
			condition.setDepartmentId(emp.getSysDepartment().getId());
			condition.setSn(emp.getSn());
			if(condition.getStatus().equals("ȫ��")){
				condition.setStatus("");
			}
			int totalCount = employeeService.findtotalCountCManage(condition);
			int totalPageCount = totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
			if(pageNo<=0){
				pageNo = 1;
			}
			if(pageNo>=totalPageCount){
				pageNo = totalPageCount;
			}
			pageSupport = employeeService.pageListCManage(condition, pageNo, pageSize);
			pageSupport.setCurrPageNo(pageNo);
			pageSupport.setPageSize(pageSize);
			pageSupport.setTotalCount(totalCount);
			pageSupport.setTotalPageCount(totalPageCount);
			return "success";
		}else{
			return "input";
		}
	}
	/**
	 * ��ʾ�鿴������ҳ��
	 * @return
	 */
	public String getViewById(){
		List<BizClaimVoucher> list = employeeService.findViewInfo(claimVoucher.getId());
		claimVoucher = list.get(0);
		return "success";
	}
	/**
	 * ��ʾ�޸�ҳ��
	 * @return
	 */
	public String updateById(){
		List<BizClaimVoucher> list = employeeService.findViewInfo(claimVoucher.getId());
		claimVoucher = list.get(0);
		rowNumber = claimVoucher.getBizClaimVoucherDetails().size();
		System.out.println(rowNumber);
		return "success";
	}
	/**
	 * �ύ�޸�
	 * @return
	 */
	public String update(){
		Map map = ActionContext.getContext().getSession();
		SysEmployee emp = (SysEmployee)map.get("employee");
		BizClaimVoucher newclaim = employeeService.load(claimVoucher.getId());
		for(BizClaimVoucherDetail detail : sets){
			detail.setBizClaimVoucher(newclaim);
		}
		Set<BizClaimVoucherDetail> s = new HashSet<BizClaimVoucherDetail>(sets);
		newclaim.setSysEmployeeByCreateSn(emp);  //1
		//��ȡ�´������
		String next = employeeService.findIdByCondition(2, emp.getSysDepartment().getId());
		if(claimVoucher.getStatus().equals("�´���")){
			next = emp.getSn();
		}
		SysEmployee sysEmployeeByNextDealSn = new SysEmployee();
		sysEmployeeByNextDealSn.setSn(next);
		newclaim.setSysEmployeeByNextDealSn(sysEmployeeByNextDealSn);
		newclaim.setEvent(claimVoucher.getEvent());
		newclaim.setStatus(claimVoucher.getStatus());
		newclaim.setTotalAccount(claimVoucher.getTotalAccount());
		newclaim.setModifyTime(new Date());
		newclaim.setBizClaimVoucherDetails(s);
		employeeService.update(newclaim);
		return "success";
	}
	/**
	 * ��ʾ����ҳ��
	 * @return
	 */
	public String tocheck(){
		Map map = ActionContext.getContext().getSession();  //��ʾ�������-----------------------------------------
		SysEmployee emp = (SysEmployee)map.get("employee");
		if(emp.getSysPosition().getNameCn().equals("���ž���")){
			claimVoucher = employeeService.findInfoById(claimVoucher.getId());
			return "success";
		}else if(emp.getSysPosition().getNameCn().equals("�ܾ���")){
			//List<BizCheckResult> results = new ArrayList<BizCheckResult>(claimVoucher.getBizCheckResults());
			claimVoucher = employeeService.findInfoById(claimVoucher.getId());			
			return "success";
		}else if(emp.getSysPosition().getNameCn().equals("����")){
			claimVoucher = employeeService.findInfoById(claimVoucher.getId());
			return "success";
		}else{
			return "success";
		}
	}
	/**
	 * ����
	 * @return
	 */
	public String check(){
		Map map = ActionContext.getContext().getSession();
		SysEmployee emp = (SysEmployee)map.get("employee");
		if(checkResult.getResult().equals("���")){
			BizClaimVoucher bcv = employeeService.findInfoById(checkResult.getBizClaimVoucher().getId());
			bcv.setModifyTime(new Date());
			bcv.setStatus("�Ѵ��");
			bcv.setSysEmployeeByNextDealSn(bcv.getSysEmployeeByCreateSn());
			employeeService.update(bcv);
			return "success";
		}else if(checkResult.getResult().equals("�ܾ�")){
			BizClaimVoucher bcv = employeeService.findInfoById(checkResult.getBizClaimVoucher().getId());
			bcv.setModifyTime(new Date());
			bcv.setStatus("����ֹ");
			bcv.setSysEmployeeByNextDealSn(null);
			employeeService.update(bcv);
			checkResult.setCheckTime(new Date());
			checkResult.setSysEmployee(emp);
			employeeService.saveResult(checkResult);
			return "success";
		}else if(checkResult.getResult().equals("ͨ��")){
			BizClaimVoucher bcv = employeeService.findInfoById(checkResult.getBizClaimVoucher().getId());
			if(emp.getSysPosition().getId()==2l){  //���ž�������
				if(bcv.getTotalAccount()>=5000){
					bcv.setModifyTime(new Date());
					bcv.setStatus("������");
					String manageSn = employeeService.findIdByCondition(3, bcv.getSysEmployeeByCreateSn().getSysDepartment().getId());
					SysEmployee manage = new SysEmployee();
					manage.setSn(manageSn);
					bcv.setSysEmployeeByNextDealSn(manage);  //�ܾ���
					employeeService.update(bcv);
				}else{
					bcv.setModifyTime(new Date());
					bcv.setStatus("������");
					String manageSn = employeeService.findIdByCondition(4, bcv.getSysEmployeeByCreateSn().getSysDepartment().getId());
					SysEmployee manage = new SysEmployee();
					manage.setSn(manageSn);
					bcv.setSysEmployeeByNextDealSn(manage);
					employeeService.update(bcv);
					checkResult.setCheckTime(new Date());
					checkResult.setSysEmployee(emp);
					employeeService.saveResult(checkResult);
				}
			}else if(emp.getSysPosition().getId()==3l){  //�ܾ�������
				bcv.setModifyTime(new Date());
				bcv.setStatus("������");
				String manageSn = employeeService.findIdByCondition(4, bcv.getSysEmployeeByCreateSn().getSysDepartment().getId());
				SysEmployee manage = new SysEmployee();
				manage.setSn(manageSn);
				bcv.setSysEmployeeByNextDealSn(manage);
				employeeService.update(bcv);
				checkResult.setCheckTime(new Date());
				checkResult.setSysEmployee(emp);
				employeeService.saveResult(checkResult);
			}else if(emp.getSysPosition().getId()==4l){  //��������
				bcv.setModifyTime(new Date());
				bcv.setStatus("�Ѹ���");
				bcv.setSysEmployeeByNextDealSn(null);
				employeeService.update(bcv);
				checkResult.setCheckTime(new Date());
				checkResult.setSysEmployee(emp);
				employeeService.saveResult(checkResult);
			}else{
				return "input";
			}
			return "success";
		}else{
			return "success";
		}
	}
	public Date getDateNow() {
		return dateNow;
	}
	public void setDateNow(Date dateNow) {
		this.dateNow = dateNow;
	}
	public BizClaimVoucher getClaimVoucher() {
		return claimVoucher;
	}
	public void setClaimVoucher(BizClaimVoucher claimVoucher) {
		this.claimVoucher = claimVoucher;
	}
	public SysEmployeeService getEmployeeService() {
		return employeeService;
	}
	public void setEmployeeService(SysEmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	public Map<String, String> getStatusMap() {
		return statusMap;
	}
	public void setStatusMap(Map<String, String> statusMap) {
		this.statusMap = statusMap;
	}
	public PageSupport<BizClaimVoucher> getPageSupport() {
		return pageSupport;
	}
	public void setPageSupport(PageSupport<BizClaimVoucher> pageSupport) {
		this.pageSupport = pageSupport;
	}
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public BizClaimVoucherDetail getClaimVoucherDetail() {
		return claimVoucherDetail;
	}
	public void setClaimVoucherDetail(BizClaimVoucherDetail claimVoucherDetail) {
		this.claimVoucherDetail = claimVoucherDetail;
	}
	public List<BizClaimVoucherDetail> getDetailList() {
		return detailList;
	}
	public void setDetailList(List<BizClaimVoucherDetail> detailList) {
		this.detailList = detailList;
	}
	public List<BizClaimVoucherDetail> getSets() {
		return sets;
	}
	public void setSets(List<BizClaimVoucherDetail> sets) {
		this.sets = sets;
	}
	public Integer getRowNumber() {
		return rowNumber;
	}
	public void setRowNumber(Integer rowNumber) {
		this.rowNumber = rowNumber;
	}
	public ConditionEmployee getCondition() {
		return condition;
	}
	public void setCondition(ConditionEmployee condition) {
		this.condition = condition;
	}
	public BizCheckResult getCheckResult() {
		return checkResult;
	}
	public void setCheckResult(BizCheckResult checkResult) {
		this.checkResult = checkResult;
	}
}
