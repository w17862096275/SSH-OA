package cn.jboa.entity;

import java.util.Date;

public class PageBcvInfo {
	private Integer id;
	private Date createTime;
	private String name;
	private String totalAccount;
	private String status;
	private String nextName;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTotalAccount() {
		return totalAccount;
	}
	public void setTotalAccount(String totalAccount) {
		this.totalAccount = totalAccount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getNextName() {
		return nextName;
	}
	public void setNextName(String nextName) {
		this.nextName = nextName;
	}
	
}
