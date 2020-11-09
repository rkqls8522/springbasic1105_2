package com.green.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml",
      "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"

})
@Log4j
public class BoardControllerTests {
   @Setter(onMethod_ = { @Autowired })
   private WebApplicationContext ctx; // 교재 214~215페이지

   private MockMvc mockMvc;// 가짜로 만듬

   @Before
   public void setup() {
      this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
   }// 빌드패턴으로 mockMvc가 채워짐

   @Test
   public void testList() throws Exception {
      log.info(
            mockMvc.perform(MockMvcRequestBuilders.get("/board/list")).andReturn().getModelAndView().getModelMap());
   }

   @Test
   public void testRegister() throws Exception {

      String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
            // 교재216페이지,post()를 이용하면 POST방식으로 전달가능하고 param()을 이용해서 전달할 파라미터들을 지정할수 있다.
            .param("title", "컨트롤러 테스트 새글 제목").param("content", "컨트롤러 테스트 새글 내용").param("writer", "컨트롤러 테스트 저자"))
            .andReturn().getModelAndView().getViewName();
      log.info(resultPage);
   }

   @Test
   // 조회에 대한 테스트 코드
   // 특정 게시물을 조회할때 반드시 'bno'라는 파라미터가 필요하므로 param()을 통해서 추가하고 실행한다.
   public void testGet() throws Exception {
      log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/get").param("bno", "2")).andReturn()
            .getModelAndView().getModelMap());
   }

   @Test // 교재 220
   public void testModify() throws Exception {
      String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/modify")
            // 교재216페이지,post()를 이용하면 POST방식으로 전달가능하고 param()을 이용해서 전달할 파라미터들을 지정할수 있다.
            .param("bno", "3").param("title", "컨트롤러 테스트 수정된 제목").param("content", "컨트롤러 테스트 수정된 내용")
            .param("writer", "컨트롤러 테스트 수정된 저자")).andReturn().getModelAndView().getViewName();
      log.info(resultPage);
   }

   @Test // 교재 221
   public void testRemove() throws Exception {
      String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/remove").param("bno", "7")).andReturn()
            .getModelAndView().getViewName();
      log.info(resultPage);

   }

   @Test
   public void testListPaging() throws Exception {
      log.info(
            mockMvc.perform(MockMvcRequestBuilders
                  .get("/board/list")
                  .param("pageNum", "2")
                  .param("amount", "50")));
   }

}