package com.green.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.green.domain.BoardVO;
import com.green.domain.CriteriaVO;
import com.green.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService{
	private BoardMapper mapper;
	
	@Override
	public List<BoardVO> getList(CriteriaVO cri) {
		//컨트롤러에서 바로 mybatis로 가는 것이 아니라
		//서비스레이어에서 복잡한 비지니스 로직을 구현하고
		//그결과를 DB와 연동하는 레이어로 독립적인 presentation 레이어 
		for(BoardVO i : mapper.getList()) {
			if(i.getWriter().equals("그린"))
				System.out.println(i.getTitle());
		}
		
		return mapper.getList();
	}
	

	@Override
	public BoardVO printTitle(Long bno) {
		// TODO Auto-generated method stub
		
		
		return mapper.read(bno);
	}


	@Override
	public void register(BoardVO board) {
		// TODO Auto-generated method stub
		Long max = 0L;
		for(int i =0; i< mapper.getList().size(); i++) {
			if(i<mapper.getList().get(i).getBno()) {
				max = mapper.getList().get(i).getBno();
				System.out.println("최대값 : " + max);
			}

		}
		mapper.insertSelectKey(board);
		
	}


	@Override
	public BoardVO get(Long bno) {
		// TODO Auto-generated method stub
		return mapper.read(bno);
	}


	@Override
	public boolean modify(BoardVO board) {
		// TODO Auto-generated method stub
		return mapper.update(board) == 1;
	}


	@Override
	public boolean remove(Long bno) {
		// TODO Auto-generated method stub
		return mapper.delete(bno) == 1;
	}

}
