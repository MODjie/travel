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
		<title>预览</title>
		<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css" />
		<!-- Bootstrap core CSS -->
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
		<!-- Custom styles for this template -->
		<!--<link href="css/jquery.bxslider.css" rel="stylesheet">-->
		<link href="css/style.css" rel="stylesheet">
		<link href="css/main.css" rel="stylesheet">

	</head>

	<div class="container">
			<div class="post-header"></div>
			<section>
				<div class="row clearfix">
					<div class="col-md-2"></div>
					<div class="col-md-8">
						<article class="blog-post">
							<%-- <div class="blog-post-image">
								<img src=${exprience.EXCOVER } alt="">
							</div> --%>
							<div class="blog-post-body">
								<h2>${exprience.EXTITLE }</h2>
								<div class="post-meta">
									${exprience.EXAUTHORNAME }
										</span>/<span><i class="fa fa-clock-o"></i>${exprience.EXPUBLISHTIME }/<span><i class="fa fa-comment-o"></i> 
									${exprience.COMMENTNUM }</span></div>
								<div class="blog-post-body">
									${exprience.EXCONTENT }
								</div>
							</div>							
						</article>						
					</div>
					<div class="col-md-2"></div>
				</div>
			</section>
		</div>	
		<!-- Bootstrap core JavaScript
			================================================== -->
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<script src="js/jquery.bxslider.js"></script>
		<script src="js/mooz.scripts.min.js"></script>
		<script src="js/post.js"></script>		
	</body>

</html>