<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/boot.jsp"></c:import>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>

	<div class="container">
		<div class="row">
			<form class="form-horizontal" action="./${board}Write" method="post">
				<div class="form-group">
					<label class="control-label col-sm-2" for="title">title: </label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="title"
							value="${vo.title}" name="title">
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-2" for="writer">writer:</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="writer" name="writer"
							value="${vo.writer}">
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-2" for="contents">contents:</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="contents"
							name="contents" value="${vo.contents}">
					</div>
				</div>


				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-default">Submit</button>
					</div>
				</div>
			</form>

		</div>
	</div>

</body>
</html>