package cn.jboa.entity;

import java.util.Date;

/**
 * BizLeave entity. @author MyEclipse Persistence Tools
 */

public class BizLeave implements java.io.Serializable {

	// Fields

	private Long id;
	private String createSn;
	private SysEmployee createEmp;
	private Date starttime;
	private Date endtime;
	private Double leaveday;
	private String reason;
	private String status;
	private String leavetype;
	private String nextSn;
	private String approveOpinion;
	private SysEmployee nextEmp;
	private Date createtime;
	private Date modifytime;
	private long departmentId;;

	// Constructors

	/** default constructor */
	public BizLeave() {
	}

	/** minimal constructor */
	public BizLeave(String createSn, Date starttime, Date endtime, Double leaveday, String reason) {
		this.createSn = createSn;
		this.starttime = starttime;
		this.endtime = endtime;
		this.leaveday = leaveday;
		this.reason = reason;
	}

	/** full constructor */
	public BizLeave(String createSn, Date starttime, Date endtime, Double leaveday, String reason, String status,
			String leavetype, String nextSn, String approveOpinion, Date createtime, Date modifytime) {
		this.createSn = createSn;
		this.starttime = starttime;
		this.endtime = endtime;
		this.leaveday = leaveday;
		this.reason = reason;
		this.status = status;
		this.leavetype = leavetype;
		this.nextSn = nextSn;
		this.approveOpinion = approveOpinion;
		this.createtime = createtime;
		this.modifytime = modifytime;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Date getStarttime() {
		return this.starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	public Date getEndtime() {
		return this.endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public Double getLeaveday() {
		return this.leaveday;
	}

	public void setLeaveday(Double leaveday) {
		this.leaveday = leaveday;
	}

	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLeavetype() {
		return this.leavetype;
	}

	public void setLeavetype(String leavetype) {
		this.leavetype = leavetype;
	}
	public String getApproveOpinion() {
		return this.approveOpinion;
	}

	public void setApproveOpinion(String approveOpinion) {
		this.approveOpinion = approveOpinion;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Date getModifytime() {
		return this.modifytime;
	}

	public void setModifytime(Date modifytime) {
		this.modifytime = modifytime;
	}

	public SysEmployee getCreateEmp() {
		return createEmp;
	}

	public void setCreateEmp(SysEmployee createEmp) {
		this.createEmp = createEmp;
	}

	public SysEmployee getNextEmp() {
		return nextEmp;
	}

	public void setNextEmp(SysEmployee nextEmp) {
		this.nextEmp = nextEmp;
	}

	public String getCreateSn() {
		return createSn;
	}

	public void setCreateSn(String createSn) {
		this.createSn = createSn;
	}

	public String getNextSn() {
		return nextSn;
	}

	public void setNextSn(String nextSn) {
		this.nextSn = nextSn;
	}

	public long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(long departmentId) {
		this.departmentId = departmentId;
	}
	
	
	
}