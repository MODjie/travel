$(function() {
	//个性签名弹窗
	$(".mood-edit").click(function() {
		layer.open({
			type: 2,
			title: '编辑个性签名',
			skin: 'layui-layer-lan',
			shadeClose: true, //点击关闭遮罩层  
			area: ['40%', '46%'],
			content: 'mood.jsp'//弹框显示的url 
		});
	});
	
});