$(function() {
	//回复弹窗
	$(".reply").click(function() {
		layer.open({
			type: 2,
			title: '编辑回复内容',
			skin: 'layui-layer-lan',
			shadeClose: true, //点击关闭遮罩层  
			area: ['40%', '46%'],
			content: 'mood.jsp'//弹框显示的url 
		});
	});
	
	//评论按钮点击事件
	$("#comment-btn").click(function() {	
		var contentArea = $(this).prev();
		var commentContent = contentArea.val();
		var exprienceId = $("#commentExId").val();	
		//评论不能为空
		if (commentContent=="") {
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
				contentArea.val("");
				alert(data);
			},
			error : function() {
				layer.msg("登录才能评论哦");
				openLoginModal();
			}
		});
	});
});