package com.koreait.service;

import java.util.List;

import com.koreait.domain.BoardDTO;
import com.koreait.domain.Criteria;

public interface BoardService {
	public List<BoardDTO> getList(Criteria cri);

	public int getTotal(Criteria cri);
	
	public void regist(BoardDTO board);
}
