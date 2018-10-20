package cn.jboa.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * SysEmployee entity. @author MyEclipse Persistence Tools
 */

public class SysEmployee implements java.io.Serializable {

	// Fields

	private String sn;
	private SysDepartment sysDepartment;
	private SysPosition sysPosition;
	private String name;
	private String password;
	private String status;
	private String mark;
	private Set bizClaimVouchersForCreateSn = new HashSet(0);
	private Set bizClaimVouchersForNextDealSn = new HashSet(0);
	private Set resultSet = new HashSet(0);
	private Set createLeave = new HashSet(0);
	private Set nextLeave = new HashSet(0);

	// Constructors

	/** default constructor */
	public SysEmployee() {
	}

	/** minimal constructor */
	public SysEmployee(SysDepartment sysDepartment, SysPosition sysPosition, String name, String password, String status) {
		this.sysDepartment = sysDepartment;
		this.sysPosition = sysPosition;
		this.name = name;
		this.password = password;
		this.status = status;
	}

	/** full constructor */
	public SysEmployee(SysDepartment sysDepartment, SysPosition sysPosition, String name, String password, String status,
			Set bizClaimVouchersForCreateSn, Set bizClaimVouchersForNextDealSn) {
		this.sysDepartment = sysDepartment;
		this.sysPosition = sysPosition;
		this.name = name;
		this.password = password;
		this.status = status;
		this.bizClaimVouchersForCreateSn = bizClaimVouchersForCreateSn;
		this.bizClaimVouchersForNextDealSn = bizClaimVouchersForNextDealSn;
	}

	// Property accessors

	public String getSn() {
		return this.sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public SysDepartment getSysDepartment() {
		return this.sysDepartment;
	}

	public void setSysDepartment(SysDepartment sysDepartment) {
		this.sysDepartment = sysDepartment;
	}
	
	public SysPosition getSysPosition() {
		return sysPosition;
	}

	public void setSysPosition(SysPosition sysPosition) {
		this.sysPosition = sysPosition;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set getBizClaimVouchersForCreateSn() {
		return this.bizClaimVouchersForCreateSn;
	}

	public void setBizClaimVouchersForCreateSn(Set bizClaimVouchersForCreateSn) {
		this.bizClaimVouchersForCreateSn = bizClaimVouchersForCreateSn;
	}

	public Set getBizClaimVouchersForNextDealSn() {
		return this.bizClaimVouchersForNextDealSn;
	}

	public void setBizClaimVouchersForNextDealSn(Set bizClaimVouchersForNextDealSn) {
		this.bizClaimVouchersForNextDealSn = bizClaimVouchersForNextDealSn;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public Set getResultSet() {
		return resultSet;
	}

	public void setResultSet(Set resultSet) {
		this.resultSet = resultSet;
	}

	public Set getCreateLeave() {
		return createLeave;
	}

	public void setCreateLeave(Set createLeave) {
		this.createLeave = createLeave;
	}

	public Set getNextLeave() {
		return nextLeave;
	}

	public void setNextLeave(Set nextLeave) {
		this.nextLeave = nextLeave;
	}
	
}