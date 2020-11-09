package com.green.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageDTO {
	private int startPage;
	private int endPage;
	private boolean prev, next;
	
	private int total;
	private CriteriaVO cri;
	
	public PageDTO(CriteriaVO cri, int total) {
		this.cri = cri;
		this.total = total;
		
		this.endPage = (int) (Math.ceil(cri.getPageNum()/10.0))* 10;
		this.startPage = this.endPage -9;
		
		//page 305
		//
		int realEnd = (int) (Math.ceil((total*1.0)/cri.getAmount()));
		if(realEnd < this.endPage) {
			this.endPage = realEnd;
		}
		
	}
}
