<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<meta name="description" content="Free Bootstrap Themes by HTML5XCSS3 dot com - Free Responsive Html5 Templates">
		<meta name="author" content="#">

		<title>我的见闻</title>

		<!-- Bootstrap core CSS -->
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
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
		<link rel="stylesheet" type="text/css" href="css/uploadHead/font-awesome.4.6.0.css">
		<link rel="stylesheet" href="css/uploadHead/amazeui.min.css">
		<link rel="stylesheet" href="css/uploadHead/amazeui.cropper.css">
		<link rel="stylesheet" href="css/uploadHead/custom_up_img.css">

		<!-- Custom CSS -->
		<link rel="stylesheet" href="css/personal/ex_list_style.css">
		<!--hui字体图标-->
		<link rel="stylesheet" type="text/css" href="Hui-iconfont/1.0.8/iconfont.min.css"/>
	</head>

	<body>
		<!--我的见闻右侧导航-->
		<nav class="myex-nav navbar navbar-inverse navbar-fixed-bottom">
			<!--<div>-->
				<ul>
					<li>
						<a href="#">见闻</a>
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
			<!--</div>-->
		</nav>

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
						<li class="active">
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
						<li>
							<a href="#" title="发布见闻"><i class="icon-edit"></i></a>
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
				<!--/.nav-collapse -->
			</div>
		</nav>
		<!-- intro section
   ================================================== -->
		<section id="intro" style="background-image: url(images/testimonials/Testimonials.jpg);">

			<div class="intro-overlay"></div>

			<div class="intro-content">
				<div class="row">

					<div class="col-twelve">

						<a href="#" id="up-img-touch"><img alt="140x140" src="images/head/head2.jpg" class="img-circle head" height="200px" width="200px" /></a>

						<div id="testimonials" class="clearfix">
							<div id="owl-testi" class="owl-carousel owl-theme">
								<div class="item">
									<div class="quote">
										<div class="personal_nickName">
											<h5 id="nickName">有梦想的码农</h5>
											<div class="intro-position">
												<span class="mood">一句话介绍下自己吧，让别人更了解你。。</span>
												<a class="glyphicon glyphicon-edit mood-edit"></a>
											</div>
										</div>
									</div>
								</div>
								<div class="item">
									<div class="quote">
										<h5>3级</h5>
										<h5 style="color: mediumvioletred;margin-top: 10px;">vip<span>6</span></h5>
										<div class="progress progress-striped active level">
											<div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 40%;">
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- /intro-content -->

				<ul class="intro-social">
					<li>
						<a href="personal.html" title="我的主页"><i class="fa icon-home"></i></a>
					</li>
					<li>
						<a href="#" title="个人信息"><i class="fa icon-user-md"></i></a>
					</li>
					<li>
						<a href="#" title="关注"><i class="fa icon-heart"></i></a>
					</li>
					<li>
						<a href="#" title="粉丝"><i class="fa icon-eye-open"></i></a>
					</li>
					<li>
						<a href="exprienceList.html" title="好友圈" style="color: #cc005f;"><i class="fa Hui-iconfont Hui-iconfont-share-pengyouquan"></i></a>
					</li>
				</ul>
				<!-- /intro-social -->

		</section>
		<div class="sub-page">
			<div class="exlist-title">
				<h1>我的见闻</h1>
			</div>
			<section class="box-content box-1">
				<div class="container">
					<div class="row">
						<div class="col-md-4">
							<div class="box-item">
								<img src="images/ex_list/13.jpg" class="img-responsive" />
								<div class="content">
									<h3>She Said Yes!</h3>
									<p>Nunc eu velit metus. Donec in massa libero. Donec bibendum orci a lorem scelerisque luctus. Aliquam et ante quis erat semper pretium. Pellentesque vehicula.</p>
									<a href="single.html">Read More...</a>
									<br><br>
									<span>MAY 21, 2014 BY VAFPRESS</span><br>
								</div>
							</div>
							<div class="box-item">
								<img src="images/ex_list/1.jpg" class="img-responsive" />
								<div class="content">
									<h3>Planning Our Honeymoon</h3>
									<p>Suspendisse porttitor sapien ac lectus euismod imperdiet. Curabitur nec nibh at massa pellentesque accumsan eu id nibh. Donec accumsan ut mi et tincidunt. Aliquam eget metus nec leo tempor bibendum. Phasellus tincidunt lobortis metus. Duis euismod lorem turpis at diam.</p>
									<a href="single.html">Read More...</a>
									<br><br>
									<span>MAY 21, 2014 BY VAFPRESS</span><br>
								</div>
							</div>
							<div class="box-item">
								<img src="images/ex_list/2.jpg" class="img-responsive" />
								<div class="content">
									<h3>Brainstorming Wedding Ideas</h3>
									<p>Suspendisse porttitor. Aliquam eget metus nec leo tempor bibendum. Phasellus tincidunt lobortis metus. Duis euismod lorem turpis, viverra feugiat ipsum volutpat vitae. Fusce justo turpis, sodales sed placerat non, suscipit at diam.</p>
									<a href="single.html">Read More...</a>
									<br><br>
									<span>MAY 21, 2014 BY VAFPRESS</span><br>
								</div>
							</div>
							<div class="box-item">
								<img src="images/ex_list/10.jpg" class="img-responsive" />
								<div class="content">
									<h3>Choosing The Bridesmaids and Groomsmen</h3>
									<p>Suspendisse porttitor sapien ac lectus euismod imperdiet. Curabitur nec nibh at massa pellentesque accumsan eu id nibh. Donec accumsan ut mi.</p>
									<a href="single.html">Read More...</a>
									<br><br>
									<span>MAY 21, 2014 BY VAFPRESS</span><br>
								</div>
							</div>
						</div>
						<div class="col-md-4">
							<div class="box-item">
								<img src="images/ex_list/3.jpg" class="img-responsive" />
								<div class="content">
									<h3>She Said Yes!</h3>
									<p>Nunc eu velit metus. Donec in massa libero. Donec bibendum orci a lorem scelerisque luctus. Aliquam et ante quis erat semper pretium. Pellentesque vehicula.</p>
									<a href="single.html">Read More...</a>
									<br><br>
									<span>MAY 21, 2014 BY VAFPRESS</span><br>
								</div>
							</div>
							<div class="box-item">
								<img src="images/ex_list/4.jpg" class="img-responsive" />
								<div class="content">
									<h3>Met Dovey’s Parents in Chicago</h3>
									<p>Class aptent taciti urna bibendum id. Duis a commodo lectus. Morbi id purus nec purus feugiat vestibulum. Suspendisse sapien ante, bibendum ac quam quis, imperdiet bibendum sem. Curabitur nibh magna, tristique et convallis…</p>
									<a href="single.html">Read More...</a>
									<br><br>
									<span>MAY 21, 2014 BY VAFPRESS</span><br>
								</div>
							</div>
							<div class="box-item">
								<img src="images/ex_list/8.jpg" class="img-responsive" />
								<div class="content">
									<h3>Choosing The Bridesmaids and Groomsmen</h3>
									<p>Suspendisse porttitor sapien ac lectus euismod imperdiet. Curabitur nec nibh at massa pellentesque accumsan eu id nibh. Donec accumsan ut mi.</p>
									<a href="single.html">Read More...</a>
									<br><br>
									<span>MAY 21, 2014 BY VAFPRESS</span><br>
								</div>
							</div>
							<div class="box-item">
								<img src="images/ex_list/11.jpg" class="img-responsive" />
								<div class="content">
									<h3>She Said Yes!</h3>
									<p>Nunc eu velit metus. Donec in massa libero. Donec bibendum orci a lorem scelerisque luctus. Aliquam et ante quis erat semper pretium. Pellentesque vehicula.</p>
									<a href="single.html">Read More...</a>
									<br><br>
									<span>MAY 21, 2014 BY VAFPRESS</span><br>
								</div>
							</div>
						</div>
						<div class="col-md-4">
							<div class="box-item">
								<img src="images/ex_list/5.jpg" class="img-responsive" />
								<div class="content">
									<h3>Choosing The Bridesmaids and Groomsmen</h3>
									<p>Suspendisse porttitor sapien ac lectus euismod imperdiet. Curabitur nec nibh at massa pellentesque accumsan eu id nibh. Donec accumsan ut mi.</p>
									<a href="single.html">Read More...</a>
									<br><br>
									<span>MAY 21, 2014 BY VAFPRESS</span><br>
								</div>
							</div>
							<div class="box-item">
								<img src="images/ex_list/12.jpg" class="img-responsive" />
								<div class="content">
									<h3>She Said Yes!</h3>
									<p>Nunc eu velit metus. Donec in massa libero. Donec bibendum orci a lorem scelerisque luctus. Aliquam et ante quis erat semper pretium. Pellentesque vehicula.</p>
									<a href="single.html">Read More...</a>
									<br><br>
									<span>MAY 21, 2014 BY VAFPRESS</span><br>
								</div>
							</div>
							<div class="box-item">
								<img src="images/ex_list/6.jpg" class="img-responsive" />
								<div class="content">
									<h3>A Sweet Escape to Paris</h3>
									<p>Proin lobortis mattis odio non ornare. Sed tempor nisi eu hendrerit luctus. Class aptent taciti sociosqu ad litora torquent per conubia nostravelit id sem tincidunt convallis ac eget quam. Vestibulum posuere porttitor sapien .</p>
									<a href="single.html">Read More...</a>
									<br><br>
									<span>MAY 21, 2014 BY VAFPRESS</span><br>
								</div>
							</div>
							<div class="box-item">
								<img src="images/ex_list/7.jpg" class="img-responsive" />
								<div class="content">
									<h3 title="Met Dovey’s Parents in Chicago">Met Dovey’s Parents in Chicago</h3>
									<p>Class aptent taciti urna bibendum id. Duis a commodo lectus. Morbi id purus nec purus feugiat vestibulum. Suspendisse sapien ante, bibendum ac quam quis, imperdiet bibendum sem. Curabitur nibh magna, tristique et convallis…</p>
									<a href="single.html">Read More...</a>
									<br><br>
									<span>MAY 21, 2014 BY VAFPRESS</span><br>
								</div>
							</div>
						</div>
					</div>
				</div>
			</section>
		</div>
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

		<!--上传头像开始-->
		<!--图片上传框-->
		<div class="am-modal am-modal-no-btn up-frame-bj " tabindex="-1" id="doc-modal-1">
			<div class="am-modal-dialog up-frame-parent up-frame-radius">
				<div class="am-modal-hd up-frame-header">
					<label>修改头像</label>
					<a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close>&times;</a>
				</div>
				<div class="am-modal-bd  up-frame-body">
					<div class="am-g am-fl">
						<div class="am-form-group am-form-file">
							<div class="am-fl">
								<button type="button" class="am-btn am-btn-default am-btn-sm">
			  <i class="am-icon-cloud-upload"></i> 选择要上传的文件</button>
							</div>
							<input type="file" id="inputImage">
						</div>
					</div>
					<div class="am-g am-fl">
						<div class="up-pre-before up-frame-radius">
							<img alt="" src="" id="image">
						</div>
						<div class="up-pre-after up-frame-radius">
						</div>
					</div>
					<div class="am-g am-fl">
						<div class="up-control-btns">
							<span class="am-icon-rotate-left" onclick="rotateimgleft()"></span>
							<span class="am-icon-rotate-right" onclick="rotateimgright()"></span>
							<span class="am-icon-check" id="up-btn-ok" url="admin/user/upload.action"></span>
						</div>
					</div>

				</div>
			</div>
		</div>

		<!--加载框-->
		<div class="am-modal am-modal-loading am-modal-no-btn" tabindex="-1" id="my-modal-loading">
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
				<div class="am-modal-bd" id="alert_content">
					成功了
				</div>
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