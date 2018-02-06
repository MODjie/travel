$(function() {
	// 定义一个数组用来存放所有文章内容
	var exContents = new Array();
	// 加载主页时，遍历所有文章内容，并且截取第一个<p>标签中的内容，将完整内容存入数组exContents
	$(".first-p").each(function() {
		var exContent = $(this).html();
		var contentArray = exContent.split("</p>");
		var preContent = exContent.substring(0, contentArray[0].length + 4);
		$(this).html(preContent);
	})

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
			createListItems(exPageNum);
		}

	});

	// 删除见闻
	$(document).on('click', '.delete-ex', function() {
		var exprienceId = $(this).next().val();
		layer.confirm('确定要删除吗？', {
			btn : [ '确定', '取消' ]
		// 按钮
		}, function() {

			// 发送ajax请求去删除
			$.ajax({
				type : "post",
				url : "deleteMyExprience",
				data : {
					_method : "delete",
					exprienceId : exprienceId,
					exPageNum : exPageNum
				},
				dataType : "json",
				async : false, // 不加这句话，则默认是true，则程序不会等待ajax请求返回就执行了return，所以返回不了ajax的值
				success : function(data) {
					// alert(JSON.stringify(data));
					layer.msg('删除成功', {
						icon : 1
					});
					window.location.reload();
				},
				error : function() {
					layer.msg("删除,请刷新页面重试");
				}

			});

		});
	});
})

// 发送ajax请求，获得下一页数据
function createListItems(exPageNum) {
	$.ajax({
		type : "get",
		url : "getMyAfterLoadEx",
		data : {
			exPageNum : exPageNum
		},
		dataType : "json",
		async : false, // 不加这句话，则默认是true，则程序不会等待ajax请求返回就执行了return，所以返回不了ajax的值
		success : function(data) {
			// alert(JSON.stringify(data));
			showMore(data)
		},
		error : function() {
			layer.msg("加载失败,请刷新页面重试");
		}

	});
}

function showMore(data) {
	if (data.list != null) {
		$
				.each(
						data.list,
						function(index, exprience) {
							$(".myExprience")
									.append(
											"<div class='col-md-4'> <div class='box-item'> <img src='"
													+ exprience.excover
													+ "' class='img-responsive' /> <div class='content'> <h3>"
													+ exprience.extitle
													+ "</h3> <div class='first-p'>"
													+ exprience.excontent
													+ "</div> <br> <a href='toPost?exprienceId="
													+ exprience.exprienceid
													+ "'>更多...</a> <br> <br> <span>"
													+ exprience.expublishtime
													+ "</span> <a class='glyphicon glyphicon-trash pull-right delete-ex' style='color: rgb(211, 211, 211); cursor: pointer;' title='删除'></a> <input type='hidden' value='"+exprience.exprienceid+"'><br> </div> </div> </div>");
						});

	} else {
		layer.msg("没有更多了");
	}
}