<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<div class="container">
  <h2>${board} Update Form</h2>
  <form action="./${board}Update" method="post">
    <div class="form-group">
      <label for="num">Num:</label>
      <input type="text" class="form-control" value="${vo.num}" readonly="readonly" id="num" placeholder="Enter Num" name="num">
    </div>
    
    <div class="form-group">
      <label for="title">Title:</label>
      <input type="text" class="form-control" value="${vo.title}" id="title" placeholder="Enter Title" name="title">
    </div>
    
    <div class="form-group">
      <label for="writer">Writer:</label>
      <input type="text" class="form-control" value="${vo.writer}" readonly="readonly" id="writer" placeholder="Enter Writer" name="writer">
    </div>
    
   <div class="form-group">
  		<label for="contents">Contents:</label>
  		<textarea class="form-control" rows="5" id="contents" name="contents">${vo.contents}</textarea>
	</div>
    
    
    
    <button type="submit" class="btn btn-default">Update</button>
  </form>
</div>    