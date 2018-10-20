package cn.jboa.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * SysDepartment entity. @author MyEclipse Persistence Tools
 */

public class SysDepartment implements java.io.Serializable {

	// Fields

	private Long id;
	private String name;
	private Set sysEmployees = new HashSet(0);
	private Set bizClaimVoucherStatisticses = new HashSet(0);

	// Constructors

	/** default constructor */
	public SysDepartment() {
	}

	/** minimal constructor */
	public SysDepartment(String name) {
		this.name = name;
	}

	/** full constructor */
	public SysDepartment(String name, Set sysEmployees, Set bizClaimVoucherStatisticses) {
		this.name = name;
		this.sysEmployees = sysEmployees;
		this.bizClaimVoucherStatisticses = bizClaimVoucherStatisticses;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set getSysEmployees() {
		return this.sysEmployees;
	}

	public void setSysEmployees(Set sysEmployees) {
		this.sysEmployees = sysEmployees;
	}

	public Set getBizClaimVoucherStatisticses() {
		return this.bizClaimVoucherStatisticses;
	}

	public void setBizClaimVoucherStatisticses(Set bizClaimVoucherStatisticses) {
		this.bizClaimVoucherStatisticses = bizClaimVoucherStatisticses;
	}

}