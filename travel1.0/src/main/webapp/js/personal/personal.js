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
	//日成长值上限
	var dayLimit = $("#dayLimit").val();
	//当前成长值
	var grouthValue = $("#grouthValue").val();
//	var grouthValue = 200;
	//今日已获成长值
	var todayValue = $("#todayValue").val();
	//当前等级
	var normalLevel = $("#normalLevel").val();
	//当前等级全部成长值
	var levelValue = 400 * normalLevel;
	//当前成长值所占当前等级全部成长值的百分比
	var percent =(grouthValue/levelValue)*100+"%";
	/*alert("dayLimit:"+dayLimit+"grouthValue:"+grouthValue+"grouthValue:"+grouthValue+"todayValue:"+todayValue+"normalLevel:"+normalLevel+"levelValue:"+levelValue);
	alert(percent);*/
	//修改进度条的显示
	$(".level div").css("width",percent);
});