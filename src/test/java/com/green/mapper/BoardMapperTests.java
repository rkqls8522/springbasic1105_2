package com.green.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.green.domain.BoardVO;
import com.green.domain.CriteriaVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
   @Setter(onMethod_ = @Autowired)
   private BoardMapper mapper;

   // @Test
   public void testGetList() {
      mapper.getList().forEach(i -> log.info(i.getWriter()));
   }

   // @Test
   public void testInsert() {
      BoardVO board = new BoardVO();
      board.setTitle("새로 작성하는 글 ");
      board.setContent("새로 작성하는 내용");
      board.setWriter("이재오 새로작성자");
      mapper.insert(board);
   }

   // @Test
   public void testRead() {
      BoardVO a = mapper.read(1L);
      System.out.println("하나를 읽은 데이터는 " + a);
   }

   // @Test
   public void testDelete() {
      int a = mapper.delete(1L); // bno가 있는 번호를 추가함
      System.out.println("잘 삭제되었습니다. " + a); // 삭제된 갯수 반환
   }

   @Test
   public void testUpdate() {
      BoardVO board = new BoardVO();
      board.setBno(2L);
      board.setTitle("수정된 제목");
      board.setContent("수정된 내용");
      board.setWriter("수정한 사람은 재오");
      int count = mapper.update(board);
      log.info("수정된 갯수는 " + count);
   }

   @Test
   public void testPaging() {
      CriteriaVO cri = new CriteriaVO();
      // 10개씩 3페이지
      cri.setAmount(10);
      cri.setPageNum(3);
      List<BoardVO> list = mapper.getListWithPaging(cri);
      list.forEach(i -> log.info(i));
   }
}