package com.funstill.customer.base.model;

import java.util.List;

public class PageModel<T> {
	 //结果集  
    private List<T> list;  
      
    //记录数  
    private int totalRecords;  
      
    //每页多少条数据  
    private int pageSize;  
      
    //第几页  
    private int pageIndex;  
  
    /**  
     * 返回总页数  
     * @return  
     */  
    public int getTotalPages() {  
        return (totalRecords + pageSize - 1) / pageSize;  
    }  
      
      
    public List<T> getList() {  
        return list;  
    }  
  
    public void setList(List<T> list) {  
        this.list = list;  
    }  
  
    public int getTotalRecords() {  
        return totalRecords;  
    }  
  
    public void setTotalRecords(int totalRecords) {  
        this.totalRecords = totalRecords;  
    }  
  
    public int getPageSize() {  
        return pageSize;  
    }  
  
    public void setPageSize(int pageSize) {  
        this.pageSize = pageSize;  
    }


	public int getPageIndex() {
		return pageIndex;
	}


	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}  
  
}
