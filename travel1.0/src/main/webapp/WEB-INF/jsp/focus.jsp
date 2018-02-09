<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="no-js" lang="en">
<!--<![endif]-->

<head>

<!--- basic page needs
   ================================================== -->
<meta charset="utf-8">
<title>关注</title>
<meta name="description" content="">
<meta name="author" content="">

<!-- mobile specific metas
   ================================================== -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">

<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css" />
<!-- Custom styles for this template -->
<link href="css/jquery.bxslider.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">

<!-- Style -->
<link href="plugins/owl-carousel/owl.carousel.css" rel="stylesheet">
<link href="plugins/owl-carousel/owl.theme.css" rel="stylesheet">
<link href="plugins/owl-carousel/owl.transitions.css" rel="stylesheet">
<link href="css/main.css" rel="stylesheet">

<!-- 个人中心CSS================================================== -->
<link rel="stylesheet" href="css/personal/base.css">
<link rel="stylesheet" href="css/personal/personal_main.css">
<link rel="stylesheet" href="css/personal/vendor.css">
<!--上传头像CSS-->
<link rel="stylesheet" type="text/css"
	href="css/uploadHead/font-awesome.4.6.0.css">
<link rel="stylesheet" href="css/uploadHead/amazeui.min.css">
<link rel="stylesheet" href="css/uploadHead/amazeui.cropper.css">
<link rel="stylesheet" href="css/uploadHead/custom_up_img.css">
<!--hui字体图标-->
<link rel="stylesheet" type="text/css"
	href="Hui-iconfont/1.0.8/iconfont.min.css" />
</head>

<body id="top">
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
				<li><a href="index.html">主页</a></li>
				<li class="active"><a href="personal.html">个人中心</a></li>
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
				<li><a href="write_ex.html" title="发布见闻"><i
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
		<!--/.nav-collapse -->
	</div>
	</nav>
	<!-- intro section
   ================================================== -->
	<section id="intro"
		style="background-image: url(images/testimonials/Testimonials.jpg);">

	<div class="intro-overlay"></div>

	<div class="intro-content">
		<div class="row">

			<div class="col-twelve">

				<input type="hidden" id="authorName" value="${author.NICKNAME }">
				<!-- 如果用户自己访问 -->
				<c:if test="${author==null }">
					<div class="col-twelve">

						<a href="#" id="up-img-touch"><img alt="140x140"
							src="${currentUser.HEADADDRESS }" class="img-circle head"
							height="200px" width="200px" /></a>

						<div id="testimonials" class="clearfix">
							<div id="owl-testi" class="owl-carousel owl-theme">
								<div class="item">
									<div class="quote">
										<div class="personal_nickName">
											<h5 id="nickName">${currentUser.NICKNAME }</h5>
											<div class="intro-position">
												<span class="mood">${currentUser.MOOD }</span> <a
													class="glyphicon glyphicon-edit mood-edit"></a>
											</div>
										</div>
									</div>
								</div>
								<div class="item">
									<div class="quote">
										<h5 style="margin-top: 20px;">
											<span>${currentUser.NORMALLEVEL }</span>级
										</h5>
										<div class="progress progress-striped active level">
											<div class="progress-bar progress-bar-success"
												role="progressbar" aria-valuenow="60" aria-valuemin="0"
												aria-valuemax="100" style="width: 40%;"></div>
										</div>
										<input type="hidden" id="dayLimit"
											value="${currentUser.DAYVALLIMIT  }"> <input
											type="hidden" id="grouthValue"
											value="${currentUser.GROWTHVALUE }"> <input
											type="hidden" id="todayValue"
											value="${currentUser.TODAYVALUE }"> <input
											type="hidden" id="normalLevel"
											value="${currentUser.NORMALLEVEL  }">
									</div>
								</div>
							</div>
						</div>
					</div>
				</c:if>
				<!-- 如果访客访问 -->
				<c:if test="${author!=null }">
					<div class="col-twelve">
						<a><img alt="140x140" src="${author.HEADADDRESS }"
							class="img-circle head" height="200px" width="200px" /></a>

						<div id="testimonials" class="clearfix">
							<div id="owl-testi" class="owl-carousel owl-theme">
								<div class="item">
									<div class="quote">
										<div class="personal_nickName">
											<h5 id="nickName">${author.NICKNAME }</h5>
											<div class="intro-position">
												<span class="mood">${author.MOOD }</span>
											</div>
										</div>
									</div>
								</div>
								<div class="item">
									<div class="quote">
										<h5 style="margin-top: 20px;">
											<span>${author.NORMALLEVEL }</span>级
										</h5>
										<div class="progress progress-striped active level">
											<div class="progress-bar progress-bar-success"
												role="progressbar" aria-valuenow="60" aria-valuemin="0"
												aria-valuemax="100" style="width: 40%;"></div>
										</div>
										<input type="hidden" id="level" value="${author.NORMALLEVEL }">
										<input type="hidden" id="dayLimit"
											value="${author.DAYVALLIMIT  }"> <input type="hidden"
											id="grouthValue" value="${author.GROWTHVALUE }"> <input
											type="hidden" id="todayValue" value="${author.TODAYVALUE }">
										<input type="hidden" id="normalLevel"
											value="${author.NORMALLEVEL  }">
									</div>
								</div>
							</div>
						</div>
					</div>
				</c:if>
			</div>
		</div>
		<!-- /intro-content -->

		<ul class="intro-social">
			<li><a href="personal.html" title="我的主页"><i
					class="fa icon-home"></i></a></li>
			<li><a href="userinfo.html" title="个人信息"><i
					class="fa icon-user-md"></i></a></li>
			<li><a href="#" title="关注" style="color: #cc005f;"><i
					class="fa icon-heart"></i></a></li>
			<li><a href="#" title="粉丝"><i class="fa icon-eye-open"></i></a>
			</li>
			<li><a href="exprienceList.html" title="文章管理"><i
					class="fa icon-book"></i></a></li>
			<li><a href="#" title="好友圈"><i
					class="fa Hui-iconfont Hui-iconfont-share-pengyouquan"></i></a></li>

		</ul>
		<!-- /intro-social -->
	</section>
	<!-- /intro -->

	<!-- Portfolio Section
   ================================================== -->
	<section id="portfolio">
	<div class="row section-intro">
		<h1 style="margin-top: -70px; margin-bottom: 70px;">我的关注</h1>
		<div class="focus-body row">
			<div class="col-md-3 focus-users" style="height: 300px;">
				<img src="images/head/head1.jpg" width="150px" height="150px"
					class="img-circle" style="margin-top: 18px;" />
				<h5 style="font-size: 18px;">有梦想的码农</h5>
				<a class="glyphicon glyphicon-plus"
					style="color: #cc005f; font-size: 18px;">已关注</a>
			</div>
		</div>
	</div>
	<!-- /section-intro-->

	<div class="row portfolio-content">

		<div class="col-twelve"></div>
		<!-- /twelve -->

	</div>
	<!-- /portfolio-content --> </section>
	<!-- /portfolio -->

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

	<!--上传头像开始-->
	<!--图片上传框-->
	<div class="am-modal am-modal-no-btn up-frame-bj " tabindex="-1"
		id="doc-modal-1">
		<div class="am-modal-dialog up-frame-parent up-frame-radius">
			<div class="am-modal-hd up-frame-header">
				<label>修改头像</label> <a href="javascript: void(0)"
					class="am-close am-close-spin" data-am-modal-close>&times;</a>
			</div>
			<div class="am-modal-bd  up-frame-body">
				<div class="am-g am-fl">
					<div class="am-form-group am-form-file">
						<div class="am-fl">
							<button type="button" class="am-btn am-btn-default am-btn-sm">
								<i class="am-icon-cloud-upload"></i> 选择要上传的文件
							</button>
						</div>
						<input type="file" id="inputImage">
					</div>
				</div>
				<div class="am-g am-fl">
					<div class="up-pre-before up-frame-radius">
						<img alt="" src="" id="image">
					</div>
					<div class="up-pre-after up-frame-radius"
						style="border-radius: 50%; margin-top: 70px; width: 200px;">
					</div>
				</div>
				<div class="am-g am-fl">
					<div class="up-control-btns">
						<span class="am-icon-rotate-left" onclick="rotateimgleft()"></span>
						<span class="am-icon-rotate-right" onclick="rotateimgright()"></span>
						<span class="am-icon-check" id="up-btn-ok"
							url="admin/user/upload.action"></span>
					</div>
				</div>

			</div>
		</div>
	</div>

	<!--加载框-->
	<div class="am-modal am-modal-loading am-modal-no-btn" tabindex="-1"
		id="my-modal-loading">
		<div class="am-modal-dialog">
			<div class="am-modal-hd">正在上传...</div>
			<div class="am-modal-bd">
				<span class="am-icon-spinner am-icon-spin"></span>
			</div>
		</div>
	</div>

	<!--警告框-->
	<div class="am-modal am-modal-alert" tabindex="-1" id="my-alert">
		<div class="am-modal-dialog">
			<div class="am-modal-hd">信息</div>
			<div class="am-modal-bd" id="alert_content">成功了</div>
			<div class="am-modal-footer">
				<span class="am-modal-btn">确定</span>
			</div>
		</div>
	</div>
	<!--上传头像结束-->

	<!-- Java Script
   ================================================== -->
	<script src="js/personal/jquery-2.1.3.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>
	<script src="js/personal/plugins.js"></script>
	<script src="js/personal/main.js"></script>
	<script src="js/custom.js"></script>
	<!-- JS PLUGINS -->
	<script src="plugins/owl-carousel/owl.carousel.min.js"></script>
	<!--layer-->
	<script type="text/javascript" src="layer/2.4/layer.js"></script>
	<!--个人中心JS-->
	<script src="js/personal/personal.js"></script>

	<!--上传头像JS-->
	<script src="js/uploadHead/amazeui.min.js" charset="utf-8"></script>
	<script src="js/uploadHead/cropper.min.js" charset="utf-8"></script>
	<script src="js/uploadHead/custom_up_img.js" charset="utf-8"></script>

</body>

</html>