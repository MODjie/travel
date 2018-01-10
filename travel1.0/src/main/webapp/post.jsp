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
		<link rel="icon" href="favicon.ico">
		<title>Renda - clean blog theme based on Bootstrap</title>
		<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css" />
		<!-- Bootstrap core CSS -->
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
		<!-- Custom styles for this template -->
		<!--<link href="css/jquery.bxslider.css" rel="stylesheet">-->
		<link href="css/style.css" rel="stylesheet">
		<link href="css/main.css" rel="stylesheet">
		<!--评论区域的CSS-->
		<link rel="stylesheet" type="text/css" href="css/comment.css" />
		
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
				<!--/.nav-collapse -->
			</div>
		</nav>
		<!--/.nav-collapse -->
		</div>
		</nav>

		<div class="container">
			<div class="post-header"></div>
			<section>
				<div class="row clearfix">
					<div class="col-md-8">
						<article class="blog-post">
							<div class="blog-post-image">
								<img src="images/750x500-1.jpg" alt="">
							</div>
							<div class="blog-post-body">
								<h2>世界那么大 你又能走多远</h2>
								<div class="post-meta">
									<a href="#">有梦想的码农</a>
									</span>/<span><i class="fa fa-clock-o"></i>2017年12月24日/<span><i class="fa fa-comment-o"></i> <a href="#">343</a></span></div>
								<div class="blog-post-body">
									<p>但仍然有不少执迷不悟的文青频频表示说，自己的心灵深处被它击中，于是决定辞职去世界冒险。他们辞职后很可能会悲伤地发现自己的存款甚至撑不过半个月的生活开销。在阻碍人们践行“世界那么大，我想去看看”这一伟大精神的诸多因素中，金钱还不是最主要的因素，更重要的因素在于责任，作为一个社会人的责任。</p>
								</div>
							</div>
							<hr />
							<div class="comment-edit">
								<textarea ></textarea>
								<button type="button" class="btn btn-info pull-right ">评论</button>
							</div>
						</article>
						<div class="comment-div">
							<ul class="commentList">
								<li class="item cl">
									<a href="#"><i class="avatar size-L radius"><img alt="头像" class="img-circle" src="images/head/head2.jpg" width="50px"></i></a>
									<div class="comment-main">
										<header class="comment-header">
											<div class="comment-meta">
												<a class="comment-author" href="#">@辉哥</a> 评论于
												<time title="2014年8月31日 下午3:20" datetime="2014-08-31T03:54:20">2014-8-31 15:20</time>
												<a class="reply pull-right">回复</a>
											</div>
										</header>
										<div class="comment-body">
											<p>
												<a href="#">@某人</a> 你是猴子派来的救兵吗？</p>
											<div class="reply-content">
												<ul class="commentList">
													<li class="item cl">
														<a href="#"><i class="avatar size-L radius"><img alt="头像" class="img-circle" src="images/head/head2.jpg" width="50px"></i></a>
														<div class="comment-main">
															<header class="comment-header">
																<div class="comment-meta">
																	<a class="comment-author" href="#">@辉哥</a> 回复
																	<a class="comment-author" href="#">@有梦想的码农</a>于
																	<time title="2014年8月31日 下午3:20" datetime="2014-08-31T03:54:20">2014-8-31 15:20</time>
																	<a class="reply pull-right">回复</a>
																</div>
															</header>
															<div class="comment-body">
																<p>
																	<a href="#">@某人</a> 你是猴子派来的救兵吗？</p>
															</div>
														</div>
													</li>
												</ul>
											</div>
										</div>
									</div>
								</li>
							</ul>
						</div>
						<div class="comment-div">
							<ul class="commentList">
								<li class="item cl">
									<a href="#"><i class="avatar size-L radius"><img alt="头像" class="img-circle" src="images/head/head2.jpg" width="50px"></i></a>
									<div class="comment-main">
										<header class="comment-header">
											<div class="comment-meta">
												<a class="comment-author" href="#">@辉哥</a> 评论
												<time title="2014年8月31日 下午3:20" datetime="2014-08-31T03:54:20">2014-8-31 15:20</time>
												<a class="reply pull-right">回复</a>
											</div>
										</header>
										<div class="comment-body">
											<p>
												<a href="#">@某人</a> 你是猴子派来的救兵吗？</p>
										</div>
									</div>
								</li>
							</ul>
						</div>
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

		<!-- Bootstrap core JavaScript
			================================================== -->
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<script src="js/jquery.bxslider.js"></script>
		<script src="js/mooz.scripts.min.js"></script>
		<script src="js/post.js"></script>
		<!--layer-->
		<script type="text/javascript" src="layer/2.4/layer.js"></script>
	</body>

</html>