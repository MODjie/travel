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
		<!--<link rel="icon" href="favicon.ico">-->
		<title>主页</title>
		<!-- Bootstrap core CSS -->
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
		<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css" />
		<!-- Custom styles for this template -->
		<link href="css/jquery.bxslider.css" rel="stylesheet">
		<link href="css/style.css" rel="stylesheet">
		<!--登录注册CSS-->
		<link href="css/login-register.css" rel="stylesheet" />
		<link rel="stylesheet" type="text/css" href="Hui-iconfont/1.0.8/iconfont.css" />
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
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					</button>
				</div>
				<div id="navbar" class="collapse navbar-collapse">
					<ul class="nav navbar-nav">
						<li class="active">
							<a href="index.html">主页</a>
						</li>
						<li>
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
							<a href="write_ex.html" title="发布见闻"><i class="icon-edit"></i></a>
						</li>
						<li>
							<a href="#" title="私信"><i class="icon-envelope"></i><span class="badge badge-danger msg-warm">1</span></a>
						</li>
						<li>
							<a href="#" title="通知"><i class="icon-bell-alt"></i><span class="badge badge-danger msg-warm">1</span></a>
						</li>
						<li>
							<a class="btn " data-toggle="modal" href="javascript:void(0)" onclick="openLoginModal();">登录</a>
						</li>
						<li>
							<a class="btn" data-toggle="modal" href="javascript:void(0)" onclick="openRegisterModal();">注册</a>
						</li>
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
				<div class="item" style="background-image: url(images/sliders/Slide.jpg);-webkit-filter: brightness(0.8);filter: brightness(0.8);">
					<div class="caption">
						<h1 style="-webkit-filter: brightness(1.5);filter: brightness(1.5);">与你相约，是一种禅意</h1>
					</div>
				</div>
				<div class="item" style="background-image: url(images/sliders/Slide2.jpg)">
					<div class="caption">
						<h1>Creative <span>Design</span></h1>
					</div>
				</div>
				<div class="item" style="background-image: url(images/sliders/Slide3.jpg)">
					<div class="caption">
						<h1>Clean <span>Code</span></h1>
					</div>
				</div>
			</div>
		</section>
		<div class="container">
			<section>
				<div class="row">
					<div class="col-md-8">
						<article class="blog-post">
							<div class="blog-post-image">
								<a href="post.html"><img src="images/750x500-1.jpg" alt=""></a>
							</div>
							<div class="blog-post-body">
								<h2><a href="post.html">世界那么大 你又能走多远</a></h2>
								<div class="post-meta">
									<a href="#">有梦想的码农</a>
									</span>/<span><i class="fa fa-clock-o"></i>2017年12月24日/<span><i class="fa fa-comment-o"></i> <a href="#">343</a></span></div>
								<p>但仍然有不少执迷不悟的文青频频表示说，自己的心灵深处被它击中，于是决定辞职去世界冒险。他们辞职后很可能会悲伤地发现自己的存款甚至撑不过半个月的生活开销。在阻碍人们践行“世界那么大，我想去看看”这一伟大精神的诸多因素中，金钱还不是最主要的因素，更重要的因素在于责任，作为一个社会人的责任。</p>
								<div class="read-more">
									<a href="#">继续阅读</a>
								</div>
							</div>
						</article>
						<!-- article -->
						<article class="blog-post">
							<div class="blog-post-image">
								<a href="post.html"><img src="images/750x500-2.jpg" alt=""></a>
							</div>
							<div class="blog-post-body">
								<h2><a href="post.html">你想要的远方，根本没有宁静 </a></h2>
								<div class="post-meta">
									<a href="#">有梦想的码农</a>
									</span>/<span><i class="fa fa-clock-o"></i>2017年12月24日/<span><i class="fa fa-comment-o"></i> <a href="#">343</a></span></div>
								<p>新年第二天，跟朋友在清迈尼曼的路周边找短期公寓，结果步行10公里，问了20多家，只有两家表示有空房，一家要价8000铢（约合人民币1500元），另一家要价8000元人民币，是商场旁边的正宗酒店。房间不错，但是在清迈花8000元租个房间，怎么都不像话。</p>
								<div class="read-more">
									<a href="#">继续阅读</a>
								</div>
							</div>
						</article>
						<!-- article -->
						<article class="blog-post">
							<div class="blog-post-image">
								<a href="post.html"><img src="images/750x500-3.jpg" alt=""></a>
							</div>
							<div class="blog-post-body">
								<h2><a href="post.html">别用生命的代价换取穷游的廉价</a></h2>
								<div class="post-meta">
									<a href="#">有梦想的码农</a>
									</span>/<span><i class="fa fa-clock-o"></i>2017年12月24日/<span><i class="fa fa-comment-o"></i> <a href="#">343</a></span></div>
								<p>近年来，“穷游”的风潮席卷了全国。“穷游”甚至已经成为了一种时尚、一种“文艺青年”的标签。可伴随着这股热潮而来的，是层出不穷的旅行事故。驴友因准备不充分而死于高原反应，因意图逃票而失去下落的事故屡见报端。旅行带给人的应该是风光和享受，而不是跋涉的痛苦和斤斤计较。要去旅行，那就做好充足的安全准备和资金准备，如果“穷”，请先去赚钱。</p>
								<div class="read-more">
									<a href="#">继续阅读</a>
								</div>
							</div>
						</article>
					</div>
					<div class="copyrights">Collect from
						<a href="http://www.cssmoban.com/">手机网站模板</a>
					</div>
					<div class="col-md-4 sidebar-gutter">
						<aside>
							<!-- sidebar-widget -->
							<div class="sidebar-widget">
								<h3 class="sidebar-title">关于我</h3>
								<div class="widget-container widget-about">
									<a href="personal.html"><img src="images/head/head2.jpg" alt="140x140" class="img-circle img-responsive center-block"></a>
									<h4>有梦想的码农</h4>
									<!--<div class="author-title">Designer</div>-->
									<p>一句话介绍下自己吧，让别人更了解你。。</p>
								</div>
							</div>
							<!-- sidebar-widget -->
							<div class="sidebar-widget">
								<h3 class="sidebar-title">码游周排行</h3>
								<div class="widget-container">
									<article class="widget-post">
										<div class="post-image">
											<a href="post.html"><img src="images/90x60-1.jpg" alt=""></a>
										</div>
										<div class="post-body">
											<h2><a href="post.html">旅行路上的人生</a></h2>
											<div class="post-meta">
												<span><i class="fa fa-clock-o"></i> 2018年1月5日</span> <span><a href="post.html"><i class="fa fa-comment-o"></i> 23</a></span>
											</div>
										</div>
									</article>
									<article class="widget-post">
										<div class="post-image">
											<a href="post.html"><img src="images/90x60-2.jpg" alt=""></a>
										</div>
										<div class="post-body">
											<h2><a href="post.html">欠自己的旅行，要还给自己</a></h2>
											<div class="post-meta">
												<span><i class="fa fa-clock-o"></i> 2018年1月1日</span> <span><a href="post.html"><i class="fa fa-comment-o"></i> 23</a></span>
											</div>
										</div>
									</article>
									<article class="widget-post">
										<div class="post-image">
											<a href="post.html"><img src="images/90x60-3.jpg" alt=""></a>
										</div>
										<div class="post-body">
											<h2><a href="post.html">得不到的永远在怀念</a></h2>
											<div class="post-meta">
												<span><i class="fa fa-clock-o"></i> 2018年1月2日</span> <span><a href="post.html"><i class="fa fa-comment-o"></i> 23</a></span>
											</div>
										</div>
									</article>
									<article class="widget-post">
										<div class="post-image">
											<a href="post.html"><img src="images/90x60-4.jpg" alt=""></a>
										</div>
										<div class="post-body">
											<h2><a href="post.html">生命不留遗憾</a></h2>
											<div class="post-meta">
												<span><i class="fa fa-clock-o"></i> 2018年1月2日</span> <span><a href="post.html"><i class="fa fa-comment-o"></i> 23</a></span>
											</div>
										</div>
									</article>
									<article class="widget-post">
										<div class="post-image">
											<a href="post.html"><img src="images/90x60-5.jpg" alt=""></a>
										</div>
										<div class="post-body">
											<h2><a href="post.html">你需要的是信仰， 不是西藏</a></h2>
											<div class="post-meta">
												<span><i class="fa fa-clock-o"></i> 2018年1月2日</span> <span><a href="post.html"><i class="fa fa-comment-o"></i> 23</a></span>
											</div>
										</div>
									</article>
								</div>
							</div>
							<div class="sidebar-widget">
								<h3 class="sidebar-title">分类</h3>
								<div class="widget-container">
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

		<!--登录注册模态窗开始-->
		<div class="container">
			<div class="modal fade login" id="loginModal">
				<div class="modal-dialog login animated">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
							<h4 class="modal-title">合作账号登录</h4>
						</div>
						<div class="modal-body">
							<div class="box">
								<div class="content">
									<div class="social-icons ">
										<ul>
											<li class="qq">
												<a href="#">
													<span class="icons w3layouts agileits"></span>
													<span class="text w3layouts agileits">QQ</span></a>
											</li>
											<li class="weixin w3ls">
												<a href="#">
													<span class="icons w3layouts"></span>
													<span class="text w3layouts agileits">微信</span></a>
											</li>
											<li class="weibo aits">
												<a href="#">
													<span class="icons agileits"></span>
													<span class="text w3layouts agileits">微博</span></a>
											</li>
											<div class="clear"> </div>
										</ul>
									</div>
									<div class="division">
										<div class="line l"></div>
										<span>或</span>
										<div class="line r"></div>
									</div>
									<div class="error"></div>
									<div class="form loginBox">
										<form method="post" action="/login" accept-charset="UTF-8">
											<input id="email" class="form-control" type="text" placeholder="邮箱/手机号/昵称" name="email">
											<input id="password" class="form-control" type="password" placeholder="密码" name="password">
											<input class="btn btn-default btn-login" type="button" value="登录" onclick="loginAjax()">
										</form>
									</div>
								</div>
							</div>
							<div class="box">
								<div class="content registerBox" style="display:none;">
									<div class="form">
										<form method="post" html="{:multipart=>true}" data-remote="true" action="/register" accept-charset="UTF-8">
											<input id="email" class="form-control" type="text" placeholder="邮箱/手机号" name="email">
											<input id="password" class="form-control" type="password" placeholder="密码" name="password">
											<input id="password_confirmation" class="form-control" type="password" placeholder="确认密码" name="password_confirmation">
											<input class="btn btn-default btn-register" type="submit" value="创建账户" name="commit">
										</form>
									</div>
								</div>
							</div>
						</div>
						<div class="modal-footer">
							<div class="forgot login-footer">
								<span>前往
                                 <a href="javascript: showRegisterForm();">注册一个账号</a>
                                 /<a href="#">忘记密码</a>
                            	</span>
							</div>
							<div class="forgot register-footer" style="display:none">
								<span>已经拥有账号？</span>
								<a href="javascript: showLoginForm();">登录</a>
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
	</body>

</html>