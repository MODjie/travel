$(function() {
	// 定义一个数组用来存放所有文章内容
	var exContents = new Array();
	// 加载主页时，遍历所有文章内容，并且截取第一个<p>标签中的内容，将完整内容存入数组exContents
	$(".read-more").each(function() {
		var exContent = $(this).prev().html();
		exContents.push(exContent);
		var contentArray = exContent.split("</p>");
		var preContent = exContent.substring(0, contentArray[0].length + 4);
		$(this).prev().html(preContent);
	})
	// 继续阅读按钮点击时，遍历所有read-more类，将当前div相同的index返回，用这个index去取数组的内容并显示
	// 通过判断read-more这个div中的隐藏域的值来判断是展开还是收起
	$(document).on(
			'click',
			'.read-more a',
			function() {
				var readMore = $(this).parent();
				var clickCount = $(this).prev().val();
				if (clickCount == "1") {
					$(this).text("收起");
					readMore.find("input").val("0");
					var length;
					$(".read-more").each(function(index) {
						if ($(this).is(readMore)) {
							length = index;
						}
					})
					readMore.prev().html(exContents[length]);
				} else {
					// 当前文章高度
					var currentExHeight = $(this).parent().prev().height();
					// 当前鼠标移动距离
					var currentScrollHeight = $(window).scrollTop();
					// alert("当前鼠标移动距离"+currentScrollHeight);
					// alert("当前文章的高度"+currentExHeight);
					$(window).scrollTop(currentScrollHeight - currentExHeight);

					$(this).text("继续阅读");
					readMore.find("input").val("1");
					var exContent = readMore.prev().html();
					var contentArray = exContent.split("</p>");
					var preContent = exContent.substring(0,
							contentArray[0].length + 4);
					readMore.prev().html(preContent);

				}

			});

	// 滚动条距底部的距离
	var BOTTOM_OFFSET = 0;
	// 请求数据的页码
	var exPageNum = 1;
	$(window).scroll(function() {
		var $currentWindow = $(window);
		// 当前窗口的高度
		var windowHeight = $currentWindow.height();
		// console.log("current widow height is " + windowHeight);
		// 当前滚动条从上往下滚动的距离
		var scrollTop = $currentWindow.scrollTop();
		// console.log("current scrollOffset is " + scrollTop);
		// 当前文档的高度
		var docHeight = $(document).height();
		// console.log("current docHeight is " + docHeight);

		// 当 滚动条距底部的距离 + 滚动条滚动的距离 >= 文档的高度 - 窗口的高度
		// 换句话说：（滚动条滚动的距离 + 窗口的高度 = 文档的高度） 这个是基本的公式
		if ((BOTTOM_OFFSET + scrollTop) >= docHeight - windowHeight) {
			exPageNum = exPageNum + 1;
			exContents = createListItems(exPageNum, exContents);
		}

	});

});
// 发送ajax请求，获得下一页数据
function createListItems(exPageNum, exContents) {
	$
			.ajax({
				type : "get",
				url : "getAfterLoadEx",
				data : {
					exPageNum : exPageNum
				},
				dataType : "json",
				async : false, // 不加这句话，则默认是true，则程序不会等待ajax请求返回就执行了return，所以返回不了ajax的值
				success : function(data) {
					if (data.list != null) {
						$
								.each(
										data.list,
										function(index, exList) {
											$(".ex-content-div")
													.append(
															"<article class='blog-post'> <div class='blog-post-image'> <input type='hidden' class='currentExprience' value="
																	+ exList.exprienceid
																	+ "> <a href='toPost?exprienceId="
																	+ exList.exprienceid
																	+ "'><img src='"
																	+ exList.excover
																	+ "'></a></div> <div class='blog-post-body'> <h2> <a href='toPost?exprienceId="
																	+ exList.exprienceid
																	+ "'>"
																	+ exList.extitle
																	+ "</a> </h2> <div class='post-meta'> <a href='#'>"
																	+ exList.exauthorname
																	+ "</a> </span>/<span><i class='fa fa-clock-o'></i>"
																	+ exList.expublishtime
																	+ "/<span><i class='fa fa-comment-o'></i> <a href='#'>"
																	+ exList.commentnum
																	+ "</a></span> </div> <div class='homeExContent'>"
																	+ exList.excontent
																	+ "</div> <div class='read-more'> <input type='hidden' value='1'> <a style='cursor: pointer;'>继续阅读</a> </div> </div> </article>");
										});

					} else {
						layer.msg("没有更多了");
					}
				}
			});
	// 遍历后面加载出来的文章，完整的加进exContents中，同时将文章多余内容收起
	$(".read-more").each(
			function(index) {
				if (exContents.length == index) {
					var exContent = $(this).prev().html();
					exContents.push(exContent);
					var contentArray = exContent.split("</p>");
					var preContent = exContent.substring(0,
							contentArray[0].length + 4);
					$(this).prev().html(preContent);
				}
			});
	return exContents
}