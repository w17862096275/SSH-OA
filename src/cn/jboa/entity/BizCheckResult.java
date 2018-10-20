package cn.jboa.entity;

import java.util.Date;

/**
 * BizCheckResult entity. @author MyEclipse Persistence Tools
 */

public class BizCheckResult implements java.io.Serializable {

	// Fields

	private Long id;
	private BizClaimVoucher bizClaimVoucher;
	private SysEmployee sysEmployee;
	private Date checkTime;
	private String checkerSn;
	private String result;
	private String comm;

	// Constructors

	/** default constructor */
	public BizCheckResult() {
	}

	/** full constructor */
	public BizCheckResult(BizClaimVoucher bizClaimVoucher, Date checkTime, String checkerSn, String result,
			String comm) {
		this.bizClaimVoucher = bizClaimVoucher;
		this.checkTime = checkTime;
		this.checkerSn = checkerSn;
		this.result = result;
		this.comm = comm;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BizClaimVoucher getBizClaimVoucher() {
		return this.bizClaimVoucher;
	}

	public void setBizClaimVoucher(BizClaimVoucher bizClaimVoucher) {
		this.bizClaimVoucher = bizClaimVoucher;
	}

	public Date getCheckTime() {
		return this.checkTime;
	}

	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}

	public String getCheckerSn() {
		return this.checkerSn;
	}

	public void setCheckerSn(String checkerSn) {
		this.checkerSn = checkerSn;
	}

	public String getResult() {
		return this.result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getComm() {
		return this.comm;
	}

	public void setComm(String comm) {
		this.comm = comm;
	}

	public SysEmployee getSysEmployee() {
		return sysEmployee;
	}

	public void setSysEmployee(SysEmployee sysEmployee) {
		this.sysEmployee = sysEmployee;
	}
	
}