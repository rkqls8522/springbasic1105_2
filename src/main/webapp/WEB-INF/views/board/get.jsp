<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="../include/header.jsp"%>
<div class="row">
   <div class="col-lg-12">
      <h1 class="page-header">게시글 조회</h1>
   </div>
</div>

<div class="row">
   <div class="col-lg-12">
      <div class="panel panel-default">
         <div class="panel-heading">게시글 조회 페이지</div>
         <div class="panel-body">

            <div class="form-group">
               <label>번호</label><input class="form-control" name='bno'
                  value='<c:out value="${board.bno}"/>' readonly="readonly">
            </div>

            <div class="form-group">
               <label>제목</label><input class="form-control" name='title'
                  value='<c:out value="${board.title}"/>' readonly="readonly">
            </div>

            <div class="form-group">
               <label>내용</label>
               <textarea class="form-control" rows="3" name='content'
                  readonly="readonly">
               <c:out value="${board.content}" />
               </textarea>
            </div>

            <div class="form-group">
               <label>저자</label><input class="form-control" name='writer'
                  value='<c:out value="${board.writer}"/>' readonly="readonly">
            </div>

            <button data-oper='modify' class="btn btn-info"
               onclick="location.href='/board/modify?bno=<c:out value="${board.bno}"/>'">수정</button>
            <button data-oper='list' class="btn btn-primary"
               onclick="location.href='/board/list'">목록</button>
            <form action="/board/modify" id="operForm" method="get">
            	<input type="hidden" id="bno" name="bno" value='<c:out value="${board.bno}"/>'>
            </form>
         </div>

      </div>

   </div>

</div>



</body>
</html>