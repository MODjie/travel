$(function() {
	var selectType = "全部";
	var authorName = $("#authorName").val();	
	
	showFirstP();
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
			createListItems(exPageNum, selectType,authorName);
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
					setTimeout(function() {
						window.location.reload();
					}, 2000);

				},
				error : function() {
					layer.msg("删除失败,请刷新页面重试");
				}
			});
		});
	});

	// 分类显示我的见闻
	$(".select-type").click(function() {
		selectType = $(this).text();
		$(this).parent().css("background", "rgb(8, 8, 8)");
		$(this).parent().siblings("li").css("background", "rgb(34,34,34)");
		selectTypeRequest(selectType,authorName);
	})
		
	//从个人中心主页进入到见闻管理中心
	if ($("#currentType").val()!="全部") {		
		selectType = $("#currentType").val();
		$(".select-type").each(function() {
			if ($(this).text()==selectType) {
				$(this).parent().css("background", "rgb(8, 8, 8)");
				$(this).parent().siblings("li").css("background", "rgb(34,34,34)");
			}
		});
		selectTypeRequest(selectType,authorName);
		
	}
})

// 发送ajax请求，获得下一页数据
function createListItems(exPageNum, selectType,authorName) {
	$.ajax({
		type : "get",
		url : "getMyAfterLoadEx",
		data : {
			exPageNum : exPageNum,
			selectType : selectType,
			authorName : authorName
		},
		dataType : "json",
		async : false, // 不加这句话，则默认是true，则程序不会等待ajax请求返回就执行了return，所以返回不了ajax的值
		success : function(data) {
			// alert(JSON.stringify(data));
			showMore(data,authorName);
			showFirstP();
		},
		error : function() {
			layer.msg("加载失败,请刷新页面重试");
		}

	});
}

function showMore(data,authorName) {
	if (data.list != null) {
		$
				.each(
						data.list,
						function(index, exprience) {
							if (exprience.ispublish == "no") {
								$(".myExprience")
										.append(
												"<div class='col-md-4'> <div class='box-item'> <img src='"
														+ exprience.excover
														+ "' class='img-responsive' /> <div class='content'> <h3>"
														+ exprience.extitle
														+ "</h3> <div class='first-p'>"
														+ exprience.excontent
														+ "</div> <br> <br> <br> <span>"
														+ exprience.expublishtime
														+ "</span> <a href='editDraft?exprienceId="
														+ exprience.exprienceid
														+ "' class='glyphicon glyphicon-pencil draft-edit' style='margin-left: 50px;cursor: pointer;' title='编辑'></a><a class='glyphicon glyphicon-trash pull-right delete-ex' style=' cursor: pointer;' title='删除'></a> <input type='hidden' value='"
														+ exprience.exprienceid
														+ "'><br> </div> </div> </div>");
							} else if (exprience.ispublish == "yes") {
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
														+ "</span> <a class='glyphicon glyphicon-trash pull-right delete-ex' style=' cursor: pointer;' title='删除'></a> <input type='hidden' value='"
														+ exprience.exprienceid
														+ "'><br> </div> </div> </div>");
							}
							if (authorName!="") {
								$(".delete-ex").remove();
								$(".draft-edit").remove();
							}
						});

	} else {
		layer.msg("没有更多了");
	}
}

// 截取第一段
function showFirstP() {
	// 加载主页时，遍历所有文章内容，并且截取第一个<p>标签中的内容
	$(".first-p").each(function() {
		var exContent = $(this).html();
		var contentArray = exContent.split("</p>");
		var preContent = exContent.substring(0, contentArray[0].length + 4);
		$(this).html(preContent);
	})
}

// 分类请求
function selectTypeRequest(selectType,authorName) {
	// 页数重置
	exPageNum = 1;	
	// 改变页面的标题
	if (authorName!="") {
		$(".exlist-title h1").text("他的" + selectType);
	}else {
		$(".exlist-title h1").text("我的" + selectType);
	}
		
	$
			.ajax({
				type : "get",
				url : "selectMyExByType",
				data : {
					selectType : selectType,
					authorName : authorName					
				},
				dataType : "json",
				async : false, // 不加这句话，则默认是true，则程序不会等待ajax请求返回就执行了return，所以返回不了ajax的值
				success : function(data) {
					// alert(JSON.stringify(data));
					$(".myExprience").empty();
					if (data.list != null) {
						showMore(data,authorName);
						showFirstP();
					} else {
						$(".myExprience")
								.append(
										"<div style='height: 500px;margin-bottom: 60px;text-align: center;'> <h1 style='padding-top: 200px;color: rgb(49,49,49);'>空空如也！您还没发表过此类见闻哦</h1> </div>");
					}

				},
				error : function() {
					layer.msg("请刷新页面重试");
				}
			});
}