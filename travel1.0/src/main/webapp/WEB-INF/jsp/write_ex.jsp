<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
		<!-- Custom styles for this template -->
		<!--<link href="css/jquery.bxslider.css" rel="stylesheet">-->
		<link href="css/style.css" rel="stylesheet">
		<link href="css/main.css" rel="stylesheet">
		<!--UEditor编辑器CSS-->
		<link href="js/umeditor/themes/default/css/umeditor.css" type="text/css" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="css/write_ex.css" />
		<!--Bootstrap fileInput-->
		<link type="text/css" rel="stylesheet" href="fileinput/fileinput.min.css" />

	</head>

	<body>
		<!-- 导航 -->
		<nav class="navbar navbar-inverse navbar-fixed-top" style="font-size: ;">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					</button>
				</div>
				<div id="navbar" class="collapse navbar-collapse">
					<ul class="nav navbar-nav">
						<li>
							<a href="index.html">主页</a>
						</li>
						<li >
							<a href="personal.html">个人中心</a>
						</li>
						<li class="pick-type">
							<a href="#" class="dropdown-toggle" id="dropdownMenu1" data-toggle="dropdown">
								<span>旅游见闻</span>
							</a>
							<ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1" style="width: 50px;">
								<li role="presentation">
									<a role="menuitem" tabindex="-1" href="#">见闻</a>
								</li>
								<li role="presentation" class="divider"></li>
								<li role="presentation">
									<a role="menuitem" tabindex="-1" href="#">游记</a>
								</li>
								<li role="presentation" class="divider"></li>
								<li role="presentation">
									<a role="menuitem" tabindex="-1" href="#">动态</a>
								</li>
								<li role="presentation" class="divider"></li>
								<li role="presentation">
									<a role="menuitem" tabindex="-1" href="#">攻略</a>
								</li>
								<li role="presentation" class="divider"></li>
								<li role="presentation">
									<a role="menuitem" tabindex="-1" href="#">风景</a>
								</li>
								<li role="presentation" class="divider"></li>
								<li role="presentation">
									<a role="menuitem" tabindex="-1" href="#">美食</a>
								</li>
							</ul>
						</li>
						<li>
							<a href="about.html">关于</a>
						</li>
						<li>
							<a href="about.html">联系我们</a>
						</li>
					</ul>

					<ul class="nav navbar-nav navbar-right">
						<li class="active">
							<a href="write_ex.html" title="发布见闻"><i class="icon-edit"></i></a>
						</li>
						<li>
							<a href="#" title="私信"><i class="icon-envelope"></i><span class="badge badge-danger msg-warm">1</span></a>
						</li>
						<li>
							<a href="#" title="通知"><i class="icon-bell-alt"></i><span class="badge badge-danger msg-warm">1</span></a>
						</li>
						<li>
							<a href="#" title="有梦想的码农"><i class="icon-user"></i><span class="userName">有梦想的码农</span></a>
						</li>
					</ul>

				</div>
			</div>
		</nav>
		<!--/.nav-collapse -->
		</div>
		</nav>

		<div class="container edit-body">
			<div class="edit-wrap">
				<div class="ex-title">
					<h4>标题</h4>
					<input type="text" id="ex-title-content" placeholder="10字以内" />
				</div>
				<div class="ex-type">
					<h4>类型</h4>
					<div class="btn-group type-btn">
						<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
							<span class="pull-left type-content">请选择<span class="caret" style="margin-left: 10px;"></span></span> 							
						</button>
						<ul class="dropdown-menu " role="menu">
							<li>
								<a href="#" style="margin: 0 auto;">见闻</a>
							</li>
							<li>
								<a href="#">游记</a>
							</li>
							<li>
								<a href="#">动态</a>
							</li>
							<li>
								<a href="#">攻略</a>
							</li>
							<li>
								<a href="#">风景</a>
							</li>
							<li>
								<a href="#">美食</a>
							</li>
						</ul>
					</div>
				</div>
				<div class="ex-content">
					<h4>内容</h4>
					<!--style给定宽度可以影响编辑器的最终宽度-->
					<script type="text/plain" id="myEditor" style="width:100%;height:240px;"></script>

				</div>
				<div class="upload-cover">
					<h4>封面上传</h4>
					<input type="file" id="cover" class="projectfile" />
				</div>

				<div class="edit-footer">
					<button type="button" class="btn btn-primary btn-lg" data-toggle="button"> 预览</button>
					<button type="button" class="btn btn-primary btn-lg saveDraft" data-toggle="button" style="margin-left: 20px;"> 保存草稿</button>
					<button type="button" class="btn btn-primary btn-lg" data-toggle="button" style="margin-left: 20px;"> 发布</button>
				</div>
			</div>
		</div>
		<!-- /.container -->
		<footer class="footer">

			<div class="footer-socials">
				<a href="#"><i class="fa fa-facebook"></i></a>
				<a href="#"><i class="fa fa-twitter"></i></a>
				<a href="#"><i class="fa fa-instagram"></i></a>
				<a href="#"><i class="fa fa-google-plus"></i></a>
				<a href="#"><i class="fa fa-dribbble"></i></a>
				<a href="#"><i class="fa fa-reddit"></i></a>
			</div>

			<div class="footer-bottom">
				<i class="fa fa-copyright"></i> 做毕设，我是认真的——刘小杰<br> 旅游见闻发布及评论网站——小码游，成立于2017年12月24日
			</div>
		</footer>

		<!-- Bootstrap core JavaScript
			================================================== -->
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<!--ueditor编辑器js-->
		<script type="text/javascript" src="js/umeditor/third-party/jquery.min.js"></script>
		<script type="text/javascript" charset="utf-8" src="js/umeditor/umeditor.min.js"></script>
		<script type="text/javascript" charset="utf-8" src="js/umeditor/umeditor.config.js"></script>
		<script type="text/javascript" charset="utf-8" src="js/umeditor/lang/zh-cn/zh-cn.js"></script>
		<!--layer-->
		<script type="text/javascript" src="layer/2.4/layer.js"></script>
		<!--fileinput-->
		<script type="text/javascript" src="fileinput/fileinput.min.js"></script>
		<script type="text/javascript" src="fileinput/zh.js"></script>
		<!-- 编辑界面JS -->
		<script type="text/javascript" src="js/exprience/exprience.js"></script>
	</body>

</html>