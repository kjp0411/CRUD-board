package com.koreait.mapper;

import java.util.List;

import com.koreait.domain.BoardDTO;
import com.koreait.domain.Criteria;

//수정버튼클릭 -> Controller -> service -> mapper -> 쿼리 -> DB
public interface BoardMapper {
	List<BoardDTO> getList(Criteria cri);
	
	void insert(BoardDTO board);
	void insert_with_bno(BoardDTO board);
	
	BoardDTO read(Long boardnum);
	//게시글이 삭제되었다면 1 이상의 값이 리턴되고
	//없는 게시글이라면(삭제가 안됐다면) 0이 리턴된다.
	int delete(Long boardnum);
	int update(BoardDTO board);

	int getTotal(Criteria cri);
}
