<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<title>发布见闻</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="icon" href="favicon.ico">
<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css" />
<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<!-- Custom styles for this template -->
<!--<link href="css/jquery.bxslider.css" rel="stylesheet">-->
<link href="css/style.css" rel="stylesheet">
<link href="css/main.css" rel="stylesheet">
<!--UEditor编辑器CSS-->
<link href="js/umeditor/themes/default/css/umeditor.css" type="text/css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/write_ex.css" />
<!--Bootstrap fileInput-->
<link type="text/css" rel="stylesheet"
	href="fileinput/fileinput.min.css" />

</head>

<body>
	<!-- 导航 -->
	<nav class="navbar navbar-inverse navbar-fixed-top"
		style="font-size: ;">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
		</div>
		<div id="navbar" class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li><a href="showHome">主页</a></li>
				<li><a href="personal">个人中心</a></li>
				<li class="pick-type"><a href="#" class="dropdown-toggle"
					id="dropdownMenu1" data-toggle="dropdown"> <span>旅游见闻</span>
				</a>
					<ul class="dropdown-menu" role="menu"
						aria-labelledby="dropdownMenu1" style="width: 50px;">
						<li role="presentation"><a role="menuitem" tabindex="-1"
							href="#">见闻</a></li>
						<li role="presentation" class="divider"></li>
						<li role="presentation"><a role="menuitem" tabindex="-1"
							href="#">游记</a></li>
						<li role="presentation" class="divider"></li>
						<li role="presentation"><a role="menuitem" tabindex="-1"
							href="#">动态</a></li>
						<li role="presentation" class="divider"></li>
						<li role="presentation"><a role="menuitem" tabindex="-1"
							href="#">攻略</a></li>
						<li role="presentation" class="divider"></li>
						<li role="presentation"><a role="menuitem" tabindex="-1"
							href="#">风景</a></li>
						<li role="presentation" class="divider"></li>
						<li role="presentation"><a role="menuitem" tabindex="-1"
							href="#">美食</a></li>
					</ul></li>
				<li><a href="about.html">关于</a></li>
				<li><a href="about.html">联系我们</a></li>
			</ul>

			<ul class="nav navbar-nav navbar-right">
				<li class="active"><a href="writeEx" title="发布见闻"><i
						class="icon-edit"></i></a></li>
				<li><a href="#" title="私信"><i class="icon-envelope"></i><span
						class="badge badge-danger msg-warm">1</span></a></li>
				<li><a href="#" title="通知"><i class="icon-bell-alt"></i><span
						class="badge badge-danger msg-warm">1</span></a></li>
				<shiro:guest>
					<li><a class="btn " data-toggle="modal"
						onclick="openLoginModal();">登录</a></li>
					<li><a class="btn" data-toggle="modal"
						onclick="openRegisterModal();">注册</a></li>
				</shiro:guest>
				<shiro:user>
					<li class="pick-type"><a href="#" class="dropdown-toggle"
						id="dropdownMenu1" data-toggle="dropdown"
						title="${currentUser.NICKNAME}"><i class="icon-user"></i><span
							class="userName">${currentUser.NICKNAME}</span></a>
						<ul class="dropdown-menu" role="menu"
							aria-labelledby="dropdownMenu1" style="width: 50px;">
							<li role="presentation"><a role="menuitem" tabindex="-1"
								onclick="openRegisterModal();" style="cursor: pointer">注册</a></li>
							<li role="presentation" class="divider"></li>
							<li role="presentation"><a role="menuitem" tabindex="-1"
								href="logout">退出</a></li>
						</ul></li>
				</shiro:user>
			</ul>

		</div>
	</div>
	</nav>
	<!--/.nav-collapse -->
	</div>
	</nav>

	<div class="container edit-body">
		<div class="edit-wrap">
			<form role="form" class="form_form" method="POST"
				action="exprienceEdit" enctype="multipart/form-data"
				onsubmit="return checkNull()">
				<div class="ex-title">
					<h4>标题</h4>
					<input type="text" id="exTitle" placeholder="20字以内" maxlength="20"
						name="EXTITLE" />
				</div>
				<div class="ex-type">
					<h4>类型</h4>
					<div class="btn-group type-btn">
						<button type="button" class="btn btn-default dropdown-toggle"
							data-toggle="dropdown">
							<span class="pull-left type-content">请选择<span
								class="caret" style="margin-left: 10px;"></span></span>
						</button>
						<ul class="dropdown-menu " role="menu" style="z-index: 1999">
							<li><a style="margin: 0 auto;">见闻</a></li>
							<li><a>游记</a></li>
							<li><a>动态</a></li>
							<li><a>攻略</a></li>
							<li><a>风景</a></li>
							<li><a>美食</a></li>
						</ul>
					</div>
				</div>
				<div class="ex-content">
					<h4>内容</h4>
					<!--style给定宽度可以影响编辑器的最终宽度-->
					<script type="text/plain" id="myEditor"
						style="width:100%;height:240px;"></script>
				</div>
				<div class="upload-cover">
					<h4>封面上传</h4>
					<input type="file" id="cover" name="cover" class="projectfile" />
				</div>
				<div class="edit-footer">
					<button type="submit" class="btn btn-primary btn-lg preview">预览</button>
					<button type="submit" class="btn btn-primary btn-lg saveDraft"
						style="margin-left: 20px;">保存草稿</button>
					<button type="submit" class="btn btn-primary btn-lg publish"
						style="margin-left: 20px;">发布</button>
				</div>
				<!-- 隐藏控件，用来存放内容 -->
				<input type="hidden" name="EXTYPE" id="exType" value=""> <input
					type="hidden" name="EXCONTENT" id="exContent"> <input
					type="hidden" name="ISPUBLISH" id="ISPUBLISH" value="no">
				<input type="hidden" id="draftId" name="draftId" value="no">
			</form>
		</div>
	</div>
	<!-- /.container -->
	<footer class="footer">

	<div class="footer-socials">
		<a href="#"><i class="fa fa-facebook"></i></a> <a href="#"><i
			class="fa fa-twitter"></i></a> <a href="#"><i class="fa fa-instagram"></i></a>
		<a href="#"><i class="fa fa-google-plus"></i></a> <a href="#"><i
			class="fa fa-dribbble"></i></a> <a href="#"><i class="fa fa-reddit"></i></a>
	</div>

	<div class="footer-bottom">
		<i class="fa fa-copyright"></i> 做毕设，我是认真的——刘小杰<br>
		旅游见闻发布及评论网站——小码游，成立于2017年12月24日
	</div>
	</footer>

	<!-- Bootstrap core JavaScript
			================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<!--ueditor编辑器js-->
	<script type="text/javascript"
		src="js/umeditor/third-party/jquery.min.js"></script>
	<script type="text/javascript" charset="utf-8"
		src="js/umeditor/umeditor.min.js"></script>
	<script type="text/javascript" charset="utf-8"
		src="js/umeditor/umeditor.config.js"></script>
	<script type="text/javascript" charset="utf-8"
		src="js/umeditor/lang/zh-cn/zh-cn.js"></script>
	<!--layer-->
	<script type="text/javascript" src="layer/2.4/layer.js"></script>
	<!--fileinput-->
	<script type="text/javascript" src="fileinput/fileinput.min.js"></script>
	<script type="text/javascript" src="fileinput/zh.js"></script>
	<!-- 编辑界面JS -->	
	<script type="text/javascript">
		$(function () {
			var draftId = "${draft.EXPRIENCEID}";
			var typeName = "${typeName}";
			if (draftId!="") {
				$("#draftId").val(draftId);
				$("#exTitle").val("${draft.EXTITLE}");
				$(".type-content").text(typeName);
				$("#exType").val(typeName);
				UM.getEditor('myEditor').setContent('${draft.EXCONTENT}');
			}
		})
	</script>
	<script type="text/javascript" src="js/exprience/exprienceEdit.js"></script>
</body>

</html>