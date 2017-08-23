package com.funstill.customer.base.model;

public class PageModel {
    /**
     *每页多少条数据 
     */ 
    private int limit=20;  
      
    /**
     * 第几页 
     */
    private int page=1; 
    
    /**
     * 是否分页
     */
    private boolean setPage=true;
  
    
    public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public boolean isSetPage() {
		return setPage;
	}

	public void setSetPage(boolean setPage) {
		this.setPage = setPage;
	}

	public int getStartRow() {
		return limit * (page - 1);
	}

}
