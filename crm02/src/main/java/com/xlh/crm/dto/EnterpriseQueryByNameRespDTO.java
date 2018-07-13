package com.xlh.crm.dto;
/** 
* @author: Jesse 
* @email: 
* @version: 0.1
* @create time: 2017/03/20 
* @description: 
*/
public class EnterpriseQueryByNameRespDTO {

    private Integer totalPage;
    private Integer pageIndex;
    private String name;
    
    public void setTotalPage(Integer totalPage) {
    	this.totalPage = totalPage;
    }
    
    public Integer getTotalPage() {
    	return totalPage;
    }
    
    public void setPageIndex(Integer pageIndex) {
    	this.pageIndex = pageIndex;
    }
    
    public Integer getPageIndex() {
    	return pageIndex;
    }
    
    public void setName(String name) {
    	this.name = name;
    }
    
    public String getName() {
    	return name;
    }
    
}
