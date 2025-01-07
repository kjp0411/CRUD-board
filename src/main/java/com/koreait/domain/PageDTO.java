package com.koreait.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PageDTO {
	private int startPage;
	private int endPage;
	private int realEnd;
	private boolean prev,next;
	private int total;
	private Criteria cri;
	
	public PageDTO(int total,Criteria cri) {
		this.total = total;
		this.cri = cri;
		//				 2	(	 2.0	1.3		 )  20
		this.endPage = (int)Math.ceil(cri.getPagenum()/10.0)*10;
		this.startPage = endPage-9;
		//				18		18.0	173.0	17.3
		this.realEnd = (int)Math.ceil((total*1.0)/10);
		
		if(endPage>realEnd) {
			endPage = realEnd;
		}
		this.prev = this.startPage > 1;
		this.next = this.endPage < this.realEnd;
	}
}
