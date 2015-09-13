<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<!-- 引入公共的jspf文件 -->
<%@ include file="/public/head.jspf"%>
</head>
<body>
	<p>视频教学</p>

	<table width="100%" border="1">
	<c:forEach items="${requestScope.movies}" var="movie">
		<tr>
			<td width="34%"><table width="100%" border="1">
					<tr>
						<td>${movie.moviePicturepath}</td>
					</tr>
					<tr>
						<td><a href="">${movie.movieTitle}</a>
						</td>
					</tr>
				</table></td>
		</tr>
		</c:forEach>
	</table>
    <a href="${pearl}/movie_showMovie?pageNum=<%=(pageNum - 1)>0?(pageNum-1):1 %>">上一页</a>&nbsp;&nbsp;&nbsp;
	<a href="${pearl}/movie_showMovie?pageNum=<%=((pageNum + 1)<=pageCount)?(pageNum+1):pageNum %>">下一页</a>
	<p>&nbsp;</p>

	<p>文档教学</p>

	<table width="100%" border="1">
		<tr>
			<td><a href="">珍珠养殖</a></td>
		</tr>
	</table>
	<a href="">上一页</a>
	&nbsp;&nbsp;&nbsp;
	<a href="">下一页</a>
	<p>&nbsp;</p>
</body>
</html>
