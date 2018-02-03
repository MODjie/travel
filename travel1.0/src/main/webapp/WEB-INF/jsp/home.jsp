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
<!--<link rel="icon" href="favicon.ico">-->
<title>主页</title>
<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css" />
<!-- Custom styles for this template -->
<link href="css/jquery.bxslider.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<!--登录注册CSS-->
<link href="css/login-register.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="Hui-iconfont/1.0.8/iconfont.css" />
<!-- Style -->
<link href="plugins/owl-carousel/owl.carousel.css" rel="stylesheet">
<link href="plugins/owl-carousel/owl.theme.css" rel="stylesheet">
<link href="plugins/owl-carousel/owl.transitions.css" rel="stylesheet">
<link href="css/main.css" rel="stylesheet">
</head>

<body>
	<!-- Preloader
		============================================= -->
	<!--<div class="preloader"><i class="fa fa-circle-o-notch fa-spin fa-2x"></i></div>-->
	<!-- 导航 -->
	<nav class="navbar navbar-inverse navbar-fixed-top">
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
				<li class="active"><a href="showHome">主页</a></li>
				<li><a href="personal.jsp">个人中心</a></li>
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
				<li><a href="writeEx" title="发布见闻"><i class="icon-edit"></i></a>
				</li>
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
		<!--/.nav-collapse -->
	</div>
	</nav>
	<!--<header>
			<a href="index.html"><img src="images/logo.png"></a>
		</header>-->
	<!--轮播图-->
	<section class="main-header">
	<div id="owl-hero" class="owl-carousel owl-theme">
		<div class="item"
			style="background-image: url(images/sliders/Slide.jpg); -webkit-filter: brightness(0.8); filter: brightness(0.8);">
			<div class="caption">
				<h1
					style="-webkit-filter: brightness(1.5); filter: brightness(1.5);">与你相约，是一种禅意</h1>
			</div>
		</div>
		<div class="item"
			style="background-image: url(images/sliders/Slide2.jpg)">
			<div class="caption">
				<h1>
					Creative <span>Design</span>
				</h1>
			</div>
		</div>
		<div class="item"
			style="background-image: url(images/sliders/Slide3.jpg)">
			<div class="caption">
				<h1>
					Clean <span>Code</span>
				</h1>
			</div>
		</div>
	</div>
	</section>
	<div class="container">
		<section>
		<div class="row">
			<div class="col-md-8 ex-content-div">
				<c:if test="${pageInfo.list!=null}">
					<c:forEach items="${pageInfo.list }" var="exprience">
						<article class="blog-post">
						<div class="blog-post-image">
							<input type="hidden" class="currentExprience"
								value="${exprience.EXPRIENCEID}"> <a
								href="toPost?exprienceId=${exprience.EXPRIENCEID}"><img
								src="${exprience.EXCOVER}"></a>
						</div>
						<div class="blog-post-body">
							<h2>
								<a href="post.html">${exprience.EXTITLE}</a>
							</h2>
							<div class="post-meta">
								<a href="#">${exprience.EXAUTHORNAME}</a> </span>/<span><i
									class="fa fa-clock-o"></i>${exprience.EXPUBLISHTIME}/<span><i
										class="fa fa-comment-o"></i> <a href="#">${exprience.COMMENTNUM}</a></span>
							</div>
							<!-- 文章内容开始 -->
							<div class="homeExContent">${exprience.EXCONTENT}</div>

							<!-- 文章内容结束 -->
							<div class="read-more">
								<input type="hidden" value="1">
								<a style="cursor: pointer;">继续阅读</a>
							</div>
						</div>
						</article>
					</c:forEach>
				</c:if>
			</div>
			<div class="copyrights">
				Collect from <a href="http://www.cssmoban.com/">手机网站模板</a>
			</div>
			<div class="col-md-4 sidebar-gutter">
				<aside> <!-- sidebar-widget -->
				<div class="sidebar-widget">
					<h3 class="sidebar-title">关于我</h3>
					<shiro:guest>
						<div class="widget-container widget-about">
							<a href="personal.html"><img
								src="images/head/defaultHead.png" alt="140x140"
								class="img-circle img-responsive center-block"></a>
							<h4>亲爱的旅行者</h4>
							<p>
								当前是游客身份，请前往 <a data-toggle="modal" onclick="openLoginModal();" style="cursor: pointer; color: rgb(91,192,222);">登录</a>/<a
									data-toggle="modal" onclick="openRegisterModal();" style="cursor: pointer; color: rgb(91,192,222); ">注册</a>
							</p>
						</div>
					</shiro:guest>
					<shiro:user>
						<div class="widget-container widget-about">
							<a href="personal.html"><img
								src="${currentUser.HEADADDRESS }" alt="140x140"
								class="img-circle img-responsive center-block"></a>
							<h4>${currentUser.NICKNAME }</h4>
							<!--<div class="author-title">Designer</div>-->
							<p>${currentUser.MOOD }</p>
						</div>
					</shiro:user>

				</div>
				<!-- sidebar-widget -->
				<div class="sidebar-widget sidebar-weekrank">
					<h3 class="sidebar-title ">码游周排行</h3>
					<div class="widget-container">
						<article class="widget-post">
						<div class="post-image">
							<a href="post.html"><img src="images/90x60-1.jpg" alt=""></a>
						</div>
						<div class="post-body">
							<h2>
								<a href="post.html">旅行路上的人生</a>
							</h2>
							<div class="post-meta">
								<span><i class="fa fa-clock-o"></i> 2018年1月5日</span> <span><a
									href="post.html"><i class="fa fa-comment-o"></i> 23</a></span>
							</div>
						</div>
						</article>
						<article class="widget-post">
						<div class="post-image">
							<a href="post.html"><img src="images/90x60-2.jpg" alt=""></a>
						</div>
						<div class="post-body">
							<h2>
								<a href="post.html">欠自己的旅行，要还给自己</a>
							</h2>
							<div class="post-meta">
								<span><i class="fa fa-clock-o"></i> 2018年1月1日</span> <span><a
									href="post.html"><i class="fa fa-comment-o"></i> 23</a></span>
							</div>
						</div>
						</article>
						<article class="widget-post">
						<div class="post-image">
							<a href="post.html"><img src="images/90x60-3.jpg" alt=""></a>
						</div>
						<div class="post-body">
							<h2>
								<a href="post.html">得不到的永远在怀念</a>
							</h2>
							<div class="post-meta">
								<span><i class="fa fa-clock-o"></i> 2018年1月2日</span> <span><a
									href="post.html"><i class="fa fa-comment-o"></i> 23</a></span>
							</div>
						</div>
						</article>
						<article class="widget-post">
						<div class="post-image">
							<a href="post.html"><img src="images/90x60-4.jpg" alt=""></a>
						</div>
						<div class="post-body">
							<h2>
								<a href="post.html">生命不留遗憾</a>
							</h2>
							<div class="post-meta">
								<span><i class="fa fa-clock-o"></i> 2018年1月2日</span> <span><a
									href="post.html"><i class="fa fa-comment-o"></i> 23</a></span>
							</div>
						</div>
						</article>
						<article class="widget-post">
						<div class="post-image">
							<a href="post.html"><img src="images/90x60-5.jpg" alt=""></a>
						</div>
						<div class="post-body">
							<h2>
								<a href="post.html">你需要的是信仰， 不是西藏</a>
							</h2>
							<div class="post-meta">
								<span><i class="fa fa-clock-o"></i> 2018年1月2日</span> <span><a
									href="post.html"><i class="fa fa-comment-o"></i> 23</a></span>
							</div>
						</div>
						</article>
					</div>
				</div>
			</div>
			</aside>
		</div>
	</div>
	</section>
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

	<!--登录注册模态窗开始-->
	<div class="container">
		<div class="modal fade login" id="loginModal">
			<div class="modal-dialog login animated">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title">合作账号登录</h4>
					</div>
					<div class="modal-body">
						<div class="box">
							<div class="content">
								<div class="social-icons ">
									<ul>
										<li class="qq"><a href="#"> <span
												class="icons w3layouts agileits"></span> <span
												class="text w3layouts agileits">QQ</span></a></li>
										<li class="weixin w3ls"><a href="#"> <span
												class="icons w3layouts"></span> <span
												class="text w3layouts agileits">微信</span></a></li>
										<li class="weibo aits"><a href="#"> <span
												class="icons agileits"></span> <span
												class="text w3layouts agileits">微博</span></a></li>
										<div class="clear"></div>
									</ul>
								</div>
								<div class="division">
									<div class="line l"></div>
									<span>或</span>
									<div class="line r"></div>
								</div>
								<div class="error"></div>
								<!-- 普通登录模块 -->
								<div class="form loginBox">
									<form accept-charset="UTF-8">
										<input class="form-control account" type="text"
											placeholder="手机号/昵称" name="account"> <input
											class="form-control password" type="password"
											placeholder="密码" name="password"> <input
											class="btn btn-default btn-login" type="button" value="登录"">
									</form>
								</div>
							</div>
						</div>
						<!-- 注册模块 -->
						<div class="box">
							<div class="content registerBox" style="display: none;">
								<div class="form">
									<form data-remote="true" accept-charset="UTF-8">
										<input class="form-control telphone" type="text"
											placeholder="手机号" maxlength="11" name="telphone"
											onkeyup='this.value=this.value.replace(/\D/gi,"")'> <input
											class="form-control identifyCode" type="text"
											placeholder="验证码" maxlength="6" name="identifyCode"
											style="width: 50%; float: left;"> <input
											class="btn btn-default pull-right  btn-getCode "
											type="button" value="获取验证码" style="width: 47%; height: 46px;">
										<input class="form-control registerNickName" type="text"
											placeholder="昵称" maxlength="10" name="registerNickName">
										<input class="form-control registerPassword" type="password"
											placeholder="密码" maxlength="16" name="registerPassword">
										<input class="form-control password_confirmation"
											type="password" placeholder="确认密码" maxlength="16"
											name="password_confirmation"> <input
											class="btn btn-default btn-register" type="button"
											value="创建账户">
									</form>
								</div>
							</div>
						</div>
						<!--验证码登录模块-->
						<div class="box">
							<div class="content codeLoginBox">
								<div class="form">
									<form method="post" accept-charset="UTF-8">
										<input class="form-control telphone2" type="text"
											placeholder="手机号" maxlength="11" name="telphone2"
											onkeyup='this.value=this.value.replace(/\D/gi,"")'> <input
											class="form-control identifyCode2" type="text"
											placeholder="验证码" maxlength="6" name="identifyCode2"
											style="width: 50%; float: left;"> <input
											class="btn btn-default pull-right btn-getCode2" type="button"
											value="获取验证码" style="width: 47%; height: 46px;"> <input
											class="btn btn-default btn-code-login" type="button"
											value="登录"">
									</form>
								</div>
							</div>
						</div>
						<!--忘记密码模块-->
						<div class="box">
							<div class="content forgotPasswordBox">
								<div class="form">
									<form accept-charset="UTF-8">
										<input class="form-control telphone3" type="text"
											placeholder="手机号" maxlength="11" name="telphone3"
											onkeyup='this.value=this.value.replace(/\D/gi,"")'> <input
											class="form-control identifyCode3" type="text"
											placeholder="验证码" maxlength="6" name="identifyCode"
											style="width: 50%; float: left;"> <input
											class="btn btn-default pull-right btn-getCode3" type="button"
											value="获取验证码" style="width: 47%; height: 46px;"> <input
											class="form-control newPassword" type="password"
											placeholder="新密码" maxlength="16" name="newPassword">
										<input class="btn btn-default btn-update-password"
											type="button" value="确认修改">
									</form>
								</div>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<div class="forgot login-footer">
							<span>前往 <a href="javascript: showRegisterForm();">注册一个账号</a>
								/<a href="javascript: showCodeLoginForm();">验证码登录</a> /<a
								href="javascript: showForgotPasswordForm()">忘记密码</a>
							</span>
						</div>
						<div class="forgot code-login-footer">
							<span>前往 <a href="javascript: showRegisterForm();">注册一个账号</a>
								/<a href="javascript: showLoginForm();">普通登录</a> /<a
								href="javascript: showForgotPasswordForm()">忘记密码</a>
							</span>
						</div>
						<div class="forgot register-footer" style="display: none">
							<span>已经拥有账号？</span> <a href="javascript: showLoginForm();">普通登录</a>
							/<a href="javascript: showCodeLoginForm();">验证码登录</a>
						</div>
						<div class="forgot forgot-password-footer">
							<span>前往 <a href="javascript: showRegisterForm();">注册一个账号</a>
								/<a href="javascript: showLoginForm();">普通登录</a> /<a
								href="javascript: showCodeLoginForm();">验证码登录</a>
							</span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--登录注册模态窗结束-->

	<!-- Bootstrap core JavaScript
			================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<!--<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>-->
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.bxslider.js"></script>
	<script src="js/mooz.scripts.min.js"></script>
	<!--图片滑动要导入的js-->

	<script src="js/custom.js"></script>
	<script src="plugins/owl-carousel/owl.carousel.min.js"></script>
	<script src="js/login-register.js" type="text/javascript"></script>
	<script src="js/home.js" type="text/javascript"></script>
	<!--layer-->
	<script type="text/javascript" src="layer/2.4/layer.js"></script>
	<script type="text/javascript">
		var nickName = "${currentUser.NICKNAME}";
		//主页加载时，如果用户未登录，则弹出模态窗口
		if (nickName == "") {
			openLoginModal();
		}

		var bodyWidth = $(document.body).width();
		//search-box 随屏幕滚动 
		$(window).scroll(function() {
			if ($(window).scrollTop() > 1031) {
				$(".sidebar-weekrank").css("position", "fixed");
				$(".sidebar-weekrank").css("top", "70px");
				$(".sidebar-weekrank").css("width", bodyWidth * 0.2409);
			} else {
				$(".sidebar-weekrank").css("position", "");
			}

		});
	</script>
</body>

</html>