<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="../include/header.jsp"%>
<!-- DataTales Example -->
<div class="card shadow mb-4">
   <div class="card-header py-3">
      <h6 class="m-0 font-weight-bold text-primary">DataTables 예제</h6>
   </div>
   <div class="card-body">
      <div class="table-responsive">
         <table class="table table-bordered" id="dataTable" width="100%"
            cellspacing="0">
            <thead>
               <tr>
                  <th>#번호</th>
                  <th>제목</th>
                  <th>작성자</th>
                  <th>작성일</th>
                  <th>수정일</th>
               </tr>
            </thead>
            <tfoot>
               <tr>
                  <th>#번호</th>
                  <th>제목</th>
                  <th>작성자</th>
                  <th>작성일</th>
                  <th>수정일</th>
               </tr>
            </tfoot>
            <tbody>
               <c:forEach items="${list}" var="board">
                  <tr>
                     <td><c:out value="${board.bno}" /></td>
                     <td><a href='/board/get?bno=<c:out value="${board.bno }"/>'>
                           <c:out value="${board.title }" />
                     </a></td>
                     <td><c:out value="${board.writer}"></c:out></td>
                     <td><fmt:formatDate pattern="yyyy-MM-dd"
                           value="${board.regDate}" />
                     <td><fmt:formatDate pattern="yyyy-MM-dd"
                           value="${board.updateDate}" />
               </c:forEach>
            </tbody>
         </table>
         <!-- End of DataTales Example -->
         <div class="modal" id="myModal" tabindex="-1" role="dialog">
            <div class="modal-dialog" role="document">
               <div class="modal-content">
                  <div class="modal-header">
                     <h5 class="modal-title">Modal title</h5>
                     <button type="button" class="close" data-dismiss="modal"
                        aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                     </button>
                  </div>
                  <div class="modal-body">
                     <p>작업이 완료되었습니다.</p>
                  </div>
                  <div class="modal-footer">
                     <button type="button" class="btn btn-primary"
                        data-dismiss="modal">Save changes</button>
                     <button type="button" class="btn btn-secondary"
                        data-dismiss="modal">Close</button>
                  </div>
               </div>
            </div>
         </div>

         <!-- Scroll to Top Button-->
         <a class="scroll-to-top rounded" href="#page-top"> <i
            class="fas fa-angle-up"></i>
         </a>

         <script>
            $(document).ready(
                  function() {
                     var result = '<c:out value="${result}"/>';
                     checkModal(result);
                     history.replaceState({}, null, null);
                     // history가 스택에 쌓이는 상태는 모달창을 보여주지 않기 위해 추가함
                     function checkModal(result) {

                        if (result === '' || history.state) { 
                           // 수정, result에 값이 없거나 history의 state 가 스택에 있으면
                           // true가 되므로 함수 종료
                           return;
                        }

                        if (parseInt(result) > 0) {
                           $(".modal-body").html(
                                 "게시글 " + parseInt(result)
                                       + " 번이 등록되었습니다.");
                        }

                        $("#myModal").modal("show");
                     }
                  });
         </script>

         <%@ include file="../include/footer.jsp"%>