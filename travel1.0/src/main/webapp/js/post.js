$(function() {
	//回复弹窗
	$(".reply").click(function() {
		layer.open({
			type: 2,
			title: '编辑回复内容',
			skin: 'layui-layer-lan',
			shadeClose: true, //点击关闭遮罩层  
			area: ['40%', '46%'],
			content: 'mood.html'//弹框显示的url 
		});
	});
});