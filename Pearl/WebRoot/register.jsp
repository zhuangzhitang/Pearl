<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<!-- 引入公共的jspf文件 -->
	<%@ include file="/public/head.jspf"%>
	<script type="text/javascript" src="http://ajax.useso.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
	<script type="text/javascript" src="js/jquery.poshytip.js" ></script>
	<script type="text/javascript" src="js/jq.validate.js" ></script>
	<script type="text/javascript" src="js/index.js" ></script>
	<link rel="stylesheet" type="text/css" href="css/reset.css" />
	<!-- <link rel="stylesheet" href="css/style.css" /> -->
	<link rel="stylesheet" type="text/css" href="css/tip-yellowsimple.css" />
	<style>
	.center{
		width:913px;
		margin-top:2em;
		padding-bottom:1em;
		background:white;
		/*border-radius:0.5em;
		padding:1em 1em;*/
		}
	h3{
		width:900px;
		font-weight:bold;
		margin:0;
		font-size:1.3em;
		padding:0.5em;
		float:left;
		color:white;
		background:#383FD8;
		}
	.labels{
	 text-align:left;
	 width:25%;
	 }
	table{
	text-align:left;
	margin-top:3em;
	}
	 input[type=submit]{ 
	    width:3em;
		height:1.5em;
		background:#383FD8;
		font-size:1.7em;
		border-radius:0.4em;
	 }
	  input[type=reset]{ 
	    width:3em;
		height:1.5em;
		background:#ccc;
		font-size:1.7em;
		border-radius:0.4em;
	 }
	</style>
	<script type="text/javascript">
		function refresh(obj) {
			obj.src = "${pearl}/verifyhandler";
		}
		$(function(){
			$("#user_name").blur(function(){
			
				$.post("${pearl}/register_checkname",{
					userName :$("#user_name").val()
				},function(data,textStatus){
					var json = eval("("+data+")");
					$("#user").text(json.tip);
				});
				});
		
			$("#user_email").blur(function(){
				$.post("${pearl}/register_checkemail",{
					userEmail :$("#user_email").val()
				},function(data,textStatus){
					var json = eval("("+data+")");
					$("#email").text(json.tip);
				});
				});
		  
			});
	</script>

</head>
<body>
	<div class="center">
<h3>欢迎您注册会员</h3>
<form  type="validate" action="index.jsp" method="post" onsubmit="return returnb()" id="d" >
	<div align="center">
		
		<br />
		<table width="70%" border="0">
		<tr>
			<td class="labels">用户名:</td><td><input type="text" id="user_name" name="username" valType="required"  msg="<font color=red>*</font>用户名不能为空" /><span id="user"></span></td>
		</tr>
		 <tr>
			<td class="labels">密码:</td><td><input type="password" name="password" id="user_pwd" valType="required" msg="<font color=red>*</font>密码不能为空" /></td>
		</tr>
        <tr>
			<td class="labels">确认密码:</td><td><input type="password" name="user_repwd" id="user_repwd" valType="repwd" msg="<font color=red>*</font>两次输入密码不一致" /></td>
		</tr>
		<tr>
			<td class="labels">电子邮箱:</td><td><input type="text" name="email" id="user_email" valType="MAIL" msg="<font color=red>*</font>电子邮箱格式不正确" /><span id="email"></span></td>
		</tr>
		<tr>
			<td class="labels" >验证码:</td><td><input type="text" name="VerificationCode" id="user_identify" valType="required" msg="<font color=red>*</font>密码不能为空" />
			<span>
				<img src="${pearl}/verifyhandler" onclick="javascript:refresh(this);" alt="" width="75" height="24" />
			</span>
			</td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="注册" onclick="checkhaveuser()"/>
			&nbsp;&nbsp;
				<input type="reset" value="清空" />
			</td>
		</tr>
		</table>
	</div>
</form>
</div>
</body>
</html>
