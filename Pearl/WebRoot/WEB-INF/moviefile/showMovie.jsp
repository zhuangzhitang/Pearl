<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<!-- 引入公共的jspf文件 -->
	<%@ include file="/public/head.jspf"%>
	<script src="js/jquery-1.3.1.js" type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#edit").click(function(){
			var value =$(this).val();
			var $resource=$(this).parent().prev();
			var $title=$(this).parent().prev().prev().prev();
			if(value=="编辑"){
				$(this).val("保存");	
				var text = $resource.text();
				var titlecontent = $title.text();
				$resource.html("<input type='text2' value='"+text+"'></input>");	
				$title.html("<input type='text2' value='"+titlecontent+"'></input>");	
			}else{
				$resource.html($resource.children().val());
				$title.html($title.children().val())
				$(this).val('编辑');
			}
			
		})
	})
</script>
</head>

<body>
<form action="" method="post" >
<table width="100%" border="1">
  <tr>
    <td>视频标题</td>
    <td>大小</td>
    <td>来源</td>
    <td>操作</td>
  </tr>
  <tr>
    <td>珍珠养殖</td>
    <td>******</td>
    <td>中国珍珠网</td>
    <td><input id="edit" type="button" value="编辑"/>  <input type="button" value="删除"/></td>
  </tr>
</table>
</form>
</body>
</html>
