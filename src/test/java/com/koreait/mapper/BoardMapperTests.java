package com.koreait.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.koreait.domain.BoardDTO;
import com.koreait.domain.Criteria;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@Log4j
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardMapperTests {
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
//	@Test
//	public void getListTest() {
//		log.info(mapper.getList());
//	}
	
//	@Test
//	public void insertTest() {
//		BoardDTO board = new BoardDTO();
//		board.setBoardcontents("매퍼 테스트 내용");
//		board.setBoardtitle("매퍼 테스트 제목");
//		board.setBoardwriter("매퍼 테스트 작성자");
//		log.info("------insertTest------");
////		mapper.insert(board);
//		mapper.insert_with_bno(board);
//		log.info(board);
//	}
	
//	1900546
//	@Test
//	public void readTest() {
//		//long --> Long
//		//int --> Integer
//		//정수L, 정수l : long타입 값
//		BoardDTO board = mapper.read(1900546L);
//		log.info(board);
//	}
//	@Test
//	public void deleteTest() {
//		log.info("DELETE : "+mapper.delete(1900546L));
//	}
	
//	@Test
//	public void updateTest() {
//		BoardDTO board = new BoardDTO();
//		board.setBoardnum(1900546L);
//		board.setBoardtitle("수정 테스트1");
//		board.setBoardcontents("수정 테스트2");
//		board.setBoardwriter("admin");
//		log.info(mapper.update(board));
//	}
//	@Test
//	public void getTotalTest() {
//		Criteria cri = new Criteria(3, 10);
//		cri.setType("W");
//		cri.setKeyword("apple");
//		log.info(mapper.getTotal(cri));
//	}
	@Test
	public void getListWithKeyword() {
		Criteria cri = new Criteria(1,10);
		cri.setType("T");
		cri.setKeyword("목2");
		log.info(mapper.getList(cri));
	}
	
}



