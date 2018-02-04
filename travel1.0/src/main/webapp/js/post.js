$(function() {			
	// 回复弹窗
	$(".reply").click(function() {
		layer.open({
			type : 2,
			title : '编辑回复内容',
			skin : 'layui-layer-lan',
			shadeClose : true, // 点击关闭遮罩层
			area : [ '40%', '46%' ],
			content : 'mood.jsp'// 弹框显示的url
		});
	});

	// 评论按钮点击事件
	$("#comment-btn").click(function() {
		var contentArea = $(this).prev();
		var commentContent = contentArea.val();
		var exprienceId = $("#commentExId").val();
		// 评论不能为空
		if (commentContent == "") {
			layer.msg("请写下您的评论");
			return;
		}
		$.ajax({
			type : "post",
			url : "comment",
			data : {
				exprienceId : exprienceId,
				commentContent : commentContent

			},
			dataType : "json",
			async : false, // 不加这句话，则默认是true，则程序不会等待ajax请求返回就执行了return，所以返回不了ajax的值
			success : function(data) {
				// alert(JSON.stringify(data))
				contentArea.val("");
				$(".comment-div").remove();
				showCommentReply(data);
			},
			error : function() {
				layer.msg("登录才能评论哦");
				openLoginModal();
			}
		});
	});
	
	//鼠标滚动到底部加载更多评论
	// 滚动条距底部的距离
	var BOTTOM_OFFSET = 0;
	// 请求数据的页码
	var exPageNum = 1;
	$(window).scroll(function() {
		var $currentWindow = $(window);
		// 当前窗口的高度
		var windowHeight = $currentWindow.height();
//		console.log("current widow height is " + windowHeight);
		// 当前滚动条从上往下滚动的距离
		var scrollTop = $currentWindow.scrollTop();
//		console.log("current scrollOffset is " + scrollTop);
		// 当前文档的高度
		var docHeight = $(document).height();
//		console.log("current docHeight is " + docHeight);

		// 当 滚动条距底部的距离 + 滚动条滚动的距离 >= 文档的高度 - 窗口的高度
		// 换句话说：（滚动条滚动的距离 + 窗口的高度 = 文档的高度） 这个是基本的公式
		if ((BOTTOM_OFFSET + scrollTop) >= docHeight - windowHeight) {
			exPageNum = exPageNum + 1;
			var exprienceId = $("#commentExId").val();
			createListItems(exPageNum,exprienceId);
		}
		
	});
});

//显示评论回复
function showCommentReply(data) {
	$
			.each(
					data.list,
					function(index, comment) {
						$(".comment-wrapper")
								.append(
										"<div class='comment-div'> <ul class='commentList'> <li class='item cl'><a href='#'><i class='avatar size-L radius'><img alt='头像' class='img-circle' src='"
												+ comment.headaddress
												+ "' width='50px'></i></a> <div class='comment-main'> <header class='comment-header'> <div class='comment-meta'> <a class='comment-author' href='#'>@"
												+ comment.useraname
												+ "</a> 评论 于  <time title='"
												+ comment.commenttime
												+ "' datetime='"
												+ comment.commenttime
												+ "'>"
												+ comment.commenttime
												+ "</time> <a class='reply pull-right'>回复</a> </div> </header> <div class='comment-body'> <p>  "
												+ comment.commentcontenrt
												+ " </p> </div> </div></li> </ul> </div>");
					});
}

//发送ajax请求，获得下一页数据
function createListItems(exPageNum,exprienceId) {
	$
			.ajax({
				type : "get",
				url : "getAfterLoadCommentReply",
				data : {
					exPageNum : exPageNum,
					exprienceId:exprienceId
				},
				dataType : "json",
				async : false, // 不加这句话，则默认是true，则程序不会等待ajax请求返回就执行了return，所以返回不了ajax的值
				success : function(data) {
					if (data.list != null) {
						showCommentReply(data);															
					} else {						
						layer.msg("没有更多了");
					}
				}
			});
	//遍历后面加载出来的文章，完整的加进exContents中，同时将文章多余内容收起
	$(".read-more").each(function(index) {		
		if (exContents.length == index) {
			var exContent = $(this).prev().html();
			exContents.push(exContent);
			var contentArray = exContent.split("</p>");
			var preContent = exContent.substring(0, contentArray[0].length + 4);
			$(this).prev().html(preContent);
		}
	});	
}