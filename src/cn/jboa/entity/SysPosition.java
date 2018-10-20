package cn.jboa.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * SysPosition entity. @author MyEclipse Persistence Tools
 */

public class SysPosition implements java.io.Serializable {

	// Fields

	private Long id;
	private String nameCn;
	private String nameEn;
	private Set emps = new HashSet(0);

	// Constructors

	/** default constructor */
	public SysPosition() {
	}

	/** full constructor */
	public SysPosition(String nameCn, String nameEn) {
		this.nameCn = nameCn;
		this.nameEn = nameEn;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameCn() {
		return this.nameCn;
	}

	public void setNameCn(String nameCn) {
		this.nameCn = nameCn;
	}

	public String getNameEn() {
		return this.nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	public Set getEmps() {
		return emps;
	}

	public void setEmps(Set emps) {
		this.emps = emps;
	}
	
}