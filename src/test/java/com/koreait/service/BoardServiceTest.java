package com.koreait.service;

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
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTest {
	
	@Setter(onMethod_ = @Autowired)
	private BoardService service;
	
//	@Test
//	public void getListTest() {
//		log.info(service.getList());
//	}
//	@Test
//	public void getTotalTest() {
//		Criteria cri = new Criteria();
//		log.info(service.getTotal(cri));
//	}
//	@Test
//	public void registTest() {
//		BoardDTO board = new BoardDTO();
//		board.setBoardtitle("service 테스트로 만든 게시글");
//		board.setBoardcontents("의미없는 내용/ 집에 갑시다");
//		board.setBoardwriter("durian");
//		service.regist(board);
//	}
	@Test
	public void getTest() {
		
		BoardDTO board = service.get(1L);
		log.info(board);
	}
}









