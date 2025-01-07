package com.koreait.domain;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//검색의 기준, 화면을 구성할 기준, pageMaker에게 게시글 목록을 띄우게 시킬 때 건네주는 정보들
@Getter
@Setter
@ToString
public class Criteria {
	private int pagenum;
	private int amount;
	private String type;
	private String keyword;
	
	public Criteria() {
//		this() : 이 클래스의 생성자
		this(1,10);
	}
	
	public Criteria(int pagenum, int amount) {
		this.pagenum = pagenum;
		this.amount = amount;
	}
	
	//현재 객체가 가지고 있는 pagenum, amount 로 쿼리스트링을 만들어서 리턴하는 메소드
	public String getListLink() {
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")//? 앞에 오는 uri 문자열
				.queryParam("pagenum", this.pagenum)	//파라미터 추가
				.queryParam("amount", this.amount)
				.queryParam("keyword", this.keyword)
				.queryParam("type", this.type);

		//?pagenum=3&amount=10		
		return builder.toUriString();		//빌더가 가지고 있는 설정대로 문자열 만들기
	}
	
	public String[] getTypeArr() {
		//type이 비어있다면(null이라면) return {};
		//type에 "TC"가 있다면 return {"T","C"};
		return type == null ? new String[] {} : type.split("");
	}
}









