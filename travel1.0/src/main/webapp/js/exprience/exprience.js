$(function() {
	// 实例化编辑器
	var um = UM.getEditor('myEditor');

	// fileinput初始化
	initFileInput("cover", $("#cover").val());

	var exType = "";
	// 分类下拉菜单点击事件
	$(".type-btn").find("a").click(function() {
		exType = $(this).text();
		$(".type-content").text(exType);
	});
	
	$(".publish").click(function() {
		var exTitle = $("#exTitle").val();
		var exContent = um.getContent();
		//将内容放到隐藏控件中		
		$("#exContent").val(exContent);
		$("#exType").val(exType);
		
	})

});

// fileinput初始化
function initFileInput(ctrlName, uploadUrl) {
	var control = $('#' + ctrlName);

	control.fileinput({
		language : 'zh', // 设置语言
		uploadUrl : uploadUrl, // 上传的地址
		allowedFileExtensions : [ 'jpg', 'png', 'gif' ], // 接收的文件后缀
		showUpload : false, // 是否显示上传按钮
		showCaption : false, // 是否显示标题
		browseClass : "btn btn-primary", // 按钮样式
		previewFileIcon : "<i class='glyphicon glyphicon-king'></i>",
	});
};

//表单验证
function checkNull() {
	if ($("#exTitle").val() == "") {
		layer.msg("请输入标题");
		return false;
	} else if ($("#exType").val() == "") {
		layer.msg("请选择类型");
		return false;
	}else if (UM.getEditor('myEditor').hasContents()==false) {
		layer.msg("请输入内容");
		return false;
	}else if ($("#cover").val() == "") {
		layer.msg("请上传封面");
		return false;
	}else {
		return true;
	}
}
