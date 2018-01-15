$(function() {
	// 实例化编辑器
	var um = UM.getEditor('myEditor');

	// fileinput初始化
	initFileInput("cover", $("#cover").val());	
	
	var ex_type = "";
	//分类下拉菜单点击事件
	$(".type-btn").find("a").click(function() {
		ex_type = $(this).text();
		$(".type-content").text(ex_type);
	});
		
	//保存草稿点击事件
	$(".saveDraft").click(function() {
		var ex_title = $("#ex-title-content").val();
		var ex_content = um.getContent();
//		var ex_cover = ;
		if(ex_title == ""){
			layer.msg("请输入标题");
		}else if (ex_type == "") {
			layer.msg("请选择类型");
		}else if (ex_content == null) {
			layer.msg("请输入文章内容");
		}
		alert(ex_cover);
	});
	
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

