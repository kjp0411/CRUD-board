package com.koreait.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreait.domain.BoardDTO;
import com.koreait.domain.Criteria;
import com.koreait.mapper.BoardMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class BoardServiceImpl implements BoardService{
	
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
	@Override
	public List<BoardDTO> getList(Criteria cri) {
		log.info("BoardService - getList");
		List<BoardDTO> list = mapper.getList(cri);
		log.info(list);
		return list;
	}
	
	@Override
	public int getTotal(Criteria cri) {
		return mapper.getTotal(cri);
	}
	
	@Override
	public void regist(BoardDTO board) {
		mapper.insert_with_bno(board);
	}
}






