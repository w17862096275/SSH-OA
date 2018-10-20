package cn.jboa.utils;

import java.util.LinkedList;
import java.util.List;

public class PageSupport<T> {
	
	// ҳ���С,��ÿҳ��ʾ��¼��
	private int pageSize = 5;
	// ��ǰҳ��
	private int currPageNo = 1;
	
	// ��ҳ��
	private int totalPageCount = 1;

	// ��¼����
	private int totalCount = 0;
	
	// ���ؽ����
	private List<T> items = new LinkedList<T>();
	public PageSupport(){
		
	}
	
	public PageSupport(int currPageNo, int pageSize){
    	setPageSize(pageSize);
    	setCurrPageNo(currPageNo);
    	
    }
//	public PaginationSupport(List<T> items ,int currPageNo, int totalCount){
//		setTotalCount(totalCount);
//		refreshPageNo(currPageNo);
//		setItems(items);
//		
//	}
//	
//	private int refreshPageNo(int currPageNo){
//    	int tempCurrPage = currPageNo;
//    	if(currPageNo < 1){
//    		tempCurrPage = 1;
//    	}
//    	if(currPageNo > this.totalPageCount){
//    		tempCurrPage = this.totalPageCount;
//    	}
//    	return tempCurrPage;
//    }
	/**
	 * �õ���ʼ��¼��
	 * 
	 * @return
	 */
	public int getStartRow() {
		return (currPageNo - 1) * pageSize;
	}

	/**
	 * �õ�������¼��
	 * 
	 * @return
	 */
	public int getEndRow() {
		return currPageNo * pageSize;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrPageNo() {
		return currPageNo;
	}

	public void setCurrPageNo(int currPageNo) {
		this.currPageNo = currPageNo;
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		if (totalCount >= 0) {
			int count = totalCount / pageSize;
			if (totalCount % pageSize > 0) {
				count++;
			}
			this.totalPageCount = count;
			
		}
	}

	public List<T> getItems() {
		return items;
	}
	public void setItems(List<T> items) {
		this.items = items;
	}
}
