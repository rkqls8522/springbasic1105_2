package com.green.service;

import java.util.List;

import com.green.domain.BoardVO;
import com.green.domain.CriteriaVO;

public interface BoardService {
	public List<BoardVO> getList(CriteriaVO cri);
	public BoardVO printTitle(Long bno);
	public void register(BoardVO board);
	public BoardVO get(Long bno);
	public boolean modify(BoardVO board);
	public boolean remove(Long bno);
	
	
}
