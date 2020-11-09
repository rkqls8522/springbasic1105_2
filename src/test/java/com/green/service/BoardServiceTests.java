package com.green.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.green.domain.BoardVO;
import com.green.domain.CriteriaVO;

import static org.junit.Assert.assertNotNull;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {
   @Setter(onMethod_ = { @Autowired })
   private BoardService service;

   @Test
   public void testExist() {
      log.info(service);
      assertNotNull(service);// null 이면 예외발생
   }

   @Test
   public void testRegister() {
      BoardVO board = new BoardVO();
      board.setTitle("서비스에서 새로 작성하는글 ");
      board.setContent("서비스에서 새로 작성하는 내용 ");
      board.setWriter("서비스에서 새로 작성한 이재오 ");
      service.register(board);
      log.info("생성된 게시글의 번호 " + board.getBno());
   }

   @Test
   public void testList() {
      log.info("서비스 잘들어오나 " + service);
      service.getList(new CriteriaVO(2, 10)).forEach(i -> log.info("여기는 서비스 " + i));
   }

   @Test
   public void testGet() {
      log.info(service.get(5L));
   }

   @Test
   public void testDelete() {
      log.info("삭제 결과 " + service.remove(5L));
   }

   @Test
   public void testUpdate() {
      BoardVO board = service.get(2L);// 수정
      if (board == null)
         return;
      board.setTitle("서비스에서 제목 수정합니다. ");
      log.info("수정 결과 " + service.modify(board));

   }
}