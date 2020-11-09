<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="../include/header.jsp" %>
<div class="row">
   <div class="col-lg-12">
      <h class="page-header">게시글 수정</h>
   </div>
</div>
<div class="row">
   <div class="col-lg-12">
      <div class="panel panel-default">
         <div class="panel-heading">게시글 수정</div>
         <div class="panel-body">
            <form role="form" action="/board/modify" method="post">
               <div class="form-group">
                  <label>번호</label>
                  <input class="form-control" name="bno" value="<c:out value='${board.bno}'/>" readonly="readonly">
               </div>
               <div class="form-group">
                  <label>제목</label>
                  <input class="form-control" name="title" value="<c:out value='${board.title}'/>" readonly="readonly">
               </div>
               <div class="form-group">
                  <label>내용</label>
                  <textarea class="form-control" rows="3" name="content"><c:out value="${board.content }"/></textarea>
               </div>
               <div class="form-group">
                  <label>저자</label>
                  <input class="form-control" name="writer" value="<c:out value='${board.writer}'/>" readonly="readonly">
               </div>
               <div class="form-group">
                  <label>등록일</label>
                  <input class="form-control" name="regDate" readonly="readonly" value='<fmt:formatDate pattern="yyyy/MM/dd" 
                            value="${board.regDate}"/>'>
               </div>
               <div class="form-group">
                  <label>수정일</label>
                  <input class="form-control" name="updateDate" readonly="readonly" value='<fmt:formatDate pattern="yyyy/MM/dd" 
                            value="${board.updateDate}"/>'>
               </div>
               <button type="submit" data-oper="modify" class="btn btn-info">수정</button>
               <button type="submit" data-oper="remove" class="btn btn-danger">삭제</button>
               <button type="submit" data-oper="list" class="btn btn-primary">목록</button>
               <!-- 여기 data-oper의 oper는 다른곳에서 제이쿼리로 value(modify/remove/list)를 얻음 -->
            </form>
         </div> 
      </div>
   </div>
</div>

<script>
   $(document).ready(function() {
      var formObj = $("form"); //폼태그를 찾아서 제이쿼리 객체화
      $("button").on("click", function (e) {
         e.preventDefault(); //버튼이 눌리면 이벤트 중지시키고
         var operation = $(this).data("oper"); //modify.jsp 에서 정보 얻어옴
         console.log(operation);
         if(operation === 'remove'){
            formObj.attr("action", "/board/remove"); //삭제버튼이 눌리면 폼태그의 action변경
         } else if(operation === 'list'){
            formObj.attr("action","/board/list").attr("method", "get");
            formObj.empty();
         }
         formObj.submit(); //버튼에 따라 action바꾸고 submit
      });
   });
</script>
</body>
</html>