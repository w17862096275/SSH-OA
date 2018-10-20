package cn.jboa.entity;

import java.util.Date;

/**
 * BizClaimVoucherStatistics entity. @author MyEclipse Persistence Tools
 */

public class BizClaimVoucherStatistics implements java.io.Serializable {

	// Fields

	private Long id;
	private SysDepartment sysDepartment;
	private Double totalCount;
	private Short year;
	private Byte month;
	private Date modifyTime;

	// Constructors

	/** default constructor */
	public BizClaimVoucherStatistics() {
	}

	/** full constructor */
	public BizClaimVoucherStatistics(SysDepartment sysDepartment, Double totalCount, Short year, Byte month,
			Date modifyTime) {
		this.sysDepartment = sysDepartment;
		this.totalCount = totalCount;
		this.year = year;
		this.month = month;
		this.modifyTime = modifyTime;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SysDepartment getSysDepartment() {
		return this.sysDepartment;
	}

	public void setSysDepartment(SysDepartment sysDepartment) {
		this.sysDepartment = sysDepartment;
	}

	public Double getTotalCount() {
		return this.totalCount;
	}

	public void setTotalCount(Double totalCount) {
		this.totalCount = totalCount;
	}

	public Short getYear() {
		return this.year;
	}

	public void setYear(Short year) {
		this.year = year;
	}

	public Byte getMonth() {
		return this.month;
	}

	public void setMonth(Byte month) {
		this.month = month;
	}

	public Date getModifyTime() {
		return this.modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

}