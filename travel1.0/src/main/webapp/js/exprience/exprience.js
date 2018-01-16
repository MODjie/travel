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

	// 保存草稿点击事件
	$(".saveDraft").click(
			function() {
				var exTitle = $("#exTitle").val();
				var exContent = um.getContent();
				//将内容放到隐藏控件中		
				$("#exContent").val(exContent);
				$("#exType").val(exType);
				// var exCover = ;
				if (exTitle == "") {
					layer.msg("请输入标题");
				} else if (exType == "") {
					layer.msg("请选择类型");
				} else {
//					location.href = "exprienceEdit?exTitle=" + exTitle
//							+ "&exType=" + exType + "&exContent=" + exContent
//							+ "&exIsPublish=no"
				}

			});

});

// fileinput初始化
function initFileInput(ctrlName, uploadUrl) {
	var control = $('#' + ctrlName);

	control.fileinput({
		language : 'zh', // 设置语言
		uploadUrl : uploadUrl, // 上传的地址
		allowedFileExtensions : [ 'jpg', 'png', 'gif' ], // 接收的文件后缀
		showUpload : true, // 是否显示上传按钮
		showCaption : false, // 是否显示标题
		browseClass : "btn btn-primary", // 按钮样式
		previewFileIcon : "<i class='glyphicon glyphicon-king'></i>",
	});
};

