package com.green.mapper;

import java.util.List;

import com.green.domain.BoardVO;
import com.green.domain.CriteriaVO;

public interface BoardMapper {
	//@Select("select * from tbl_board where bno > 0")
	public List<BoardVO> getList();
	public List<BoardVO> getListWithPaging(CriteriaVO cri); //추가
	public void insert(BoardVO board);
	public void insertSelectKey(BoardVO board);
	public BoardVO read(Long bno);
	public int delete(Long bno);
	public int update(BoardVO board);
}
