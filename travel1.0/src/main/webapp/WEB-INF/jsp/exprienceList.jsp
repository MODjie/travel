<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--[if IE 8 ]><html class="no-js oldie ie8" lang="en"> <![endif]-->
<!--[if IE 9 ]><html class="no-js oldie ie9" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!-->
<html class="no-js" lang="en">

<head>
<!-- META DATA -->
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta name="description"
	content="Free Bootstrap Themes by HTML5XCSS3 dot com - Free Responsive Html5 Templates">
<meta name="author" content="#">

<title>我的见闻</title>

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

<!-- Custom CSS -->
<link rel="stylesheet" href="css/personal/ex_list_style.css">
<!--hui字体图标-->
<link rel="stylesheet" type="text/css"
	href="Hui-iconfont/1.0.8/iconfont.min.css" />
</head>

<body style="overflow-x: hidden;">
	<!--我的见闻右侧导航-->
	<nav class="myex-nav navbar navbar-inverse navbar-fixed-bottom">
	<!--<div>--> <input type="hidden" value="${currentType }"
		id="currentType">
	<ul>
		<li style="background-color: rgb(8, 8, 8); cursor: pointer;"><a
			class="select-type">全部</a></li>
		<li style="cursor: pointer;"><a class="select-type">见闻</a></li>
		<li style="cursor: pointer;"><a class="select-type">游记</a></li>
		<li style="cursor: pointer;"><a class="select-type">动态</a></li>
		<li style="cursor: pointer;"><a class="select-type">攻略</a></li>
		<li style="cursor: pointer;"><a class="select-type">风景</a></li>
		<li style="cursor: pointer;"><a class="select-type">美食</a></li>
		<li style="cursor: pointer;"><a class="select-type">草稿箱</a></li>
	</ul>
	<!--</div>--> </nav>

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
				<li class="active"><a href="personal">个人中心</a></li>
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
				<li><a href="writeEx" title="发布见闻"><i class="icon-edit"></i></a></li>
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
		<!-- /intro-content -->
		<!-- 如果用户自己访问 -->
		<c:if test="${author==null }">
			<ul class="intro-social">
				<li><a href="personal" title="我的主页"><i class="fa icon-home"></i></a></li>
				<li><a href="toUserInfo" title="个人信息"><i
						class="fa icon-user-md"></i></a></li>
				<li><a href="#" title="关注"><i class="fa icon-heart"></i></a></li>
				<li><a href="#" title="粉丝"><i class="fa icon-eye-open"></i></a>
				</li>
				<li><a href="exprienceList?currentType=全部" title="见闻管理"
					style="color: #cc005f;"><i class="fa icon-book"></i></a></li>
				<li><a href="exprienceList.html" title="好友圈"><i
						class="fa Hui-iconfont Hui-iconfont-share-pengyouquan"></i></a></li>
			</ul>
		</c:if>
		<!-- 如果访客访问 -->
		<c:if test="${author!=null }">
			<ul class="intro-social">
				<li><a href="toUserInfo?authorName=${author.NICKNAME }"
					title="他的个人信息"><i class="fa icon-user-md"></i></a></li>
				<li><a href="#" title="他的关注"><i class="fa icon-heart"></i></a></li>
				<li><a href="#" title="他的粉丝"><i class="fa icon-eye-open"></i></a>
				</li>
				<li><a
					href="exprienceList?currentType=全部&nickName=${author.NICKNAME }"
					title="他的见闻" style="color: #cc005f;"><i class="fa icon-book"></i></a></li>
			</ul>
		</c:if>
		<!-- /intro-social -->
	</section>
	<div class="sub-page">
		<div class="exlist-title">
			<c:if test="${author==null }">
				<h1>我的全部</h1>
			</c:if>
			<c:if test="${author!=null }">
				<h1>他的全部</h1>
			</c:if>
		</div>
		<section class="box-content box-1">
		<div class="container ">
			<div class="row myExprience">
				<c:if test="${pageInfo.list!=null }">
					<c:forEach items="${pageInfo.list }" var="exprience">
						<div class="col-md-4">
							<div class="box-item">
								<img src="${exprience.EXCOVER }" class="img-responsive" />
								<div class="content">
									<h3>${exprience.EXTITLE }</h3>
									<div class="first-p">${exprience.EXCONTENT }</div>
									<br> <a
										href="toPost?exprienceId=${exprience.EXPRIENCEID }">更多...</a>
									<br> <br> <span>${exprience.EXPUBLISHTIME }</span>
									<c:if test="${author==null }">
										<a class="glyphicon glyphicon-trash pull-right delete-ex"
											style="cursor: pointer;" title="删除"> </a>
									</c:if>
									<input type="hidden" value="${exprience.EXPRIENCEID }">
									<br>
								</div>
							</div>
						</div>
					</c:forEach>
				</c:if>

				<c:if test="${pageInfo.list==null }">
					<div
						style="height: 500px; margin-bottom: 60px; text-align: center;">
						<h1 style="padding-top: 200px; color: rgb(49, 49, 49);">空空如也！您还没发表过此类见闻哦</h1>
					</div>
				</c:if>
			</div>
		</div>
		</section>
	</div>
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
					<div class="up-pre-after up-frame-radius"></div>
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
	<!-- 见闻管理js -->
	<script src="js/personal/exprienceList.js"></script>
</body>

</html>