package com.funstill.customer.base.model;

public class PageModel {
    //每页多少条数据  
    private int pageSize=20;  
      
    //第几页  
    private int pageIndex=1; 
    
    private boolean isPage=true;
  
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
	public int getStartRow() {
		return pageSize * (pageIndex - 1);
	}

	public boolean isPage() {
		return isPage;
	}

	public void setPage(boolean isPage) {
		this.isPage = isPage;
	}
}
