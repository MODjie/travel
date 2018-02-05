<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta charset="UTF-8">
		<title>个性签名</title>
		<link href="css/bootstrap.min.css" rel="stylesheet">

		<style>
			.share_weibo_wp {
				width: 480px;
				padding: 20px;
				background-color: #fff;
				margin-left: auto;
				margin-right: auto;
				margin-top: 20px;
				-khtml-border-radius: 10px;
				-ms-border-radius: 10px;
				-o-border-radius: 10px;
				-moz-border-radius: 10px;
				-webkit-border-radius: 10px;
				border-radius: 10px;
				behavior: url(ie-css3.htc)
			}
			
			.count_txt {
				color: #B5B5B5;
				text-align: right
			}
			
			.count_txt strong {
				font-family: georgia;
				font-size: 24px;
				padding: 0 2px
			}
			
			.inputstyle {
				height: 85px;
				line-height: 18px;
				overflow-x: hidden;
				overflow-y: auto;
				width: 472px
			}
		</style>
	</head>

	<body>
		<div class="cl share_weibo_wp" style="">
			<div class="cl">
				<span class="r count_txt">还能输入<strong id="currentLength">50</strong>字</span>
			</div>
			<textarea onkeyup="checkLength(this);" class="mood-text textarea radius inputstyle"></textarea>
			<div class="modal-footer">
				<button type="button" class="btn btn-default btn-close" data-dismiss="modal">关闭</button>
				<button type="button" class="btn btn-primary save">保存</button>
			</div>
		</div>
	</body>

	<script src="js/personal/jquery-2.1.3.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
	<script type="text/javascript">
		function checkLength(which) {
			var maxChars = 50;
			if(which.value.length > maxChars)
				which.value = which.value.substring(0, maxChars);
			var curr = maxChars - which.value.length;
			document.getElementById("currentLength").innerHTML = curr.toString()
		}

		$(function() {
			var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
			//保存按钮点击事件
			$(".save").click(function() {
				var moodText = $(".mood-text").val();
				if(moodText == "") {
					parent.layer.msg('内容不能为空哦');
				} else {					
					$.ajax({
						type : "put",
						url : "updataMood",
						data : {
							moodText : moodText
						},
						dataType : "json",
						async : false, // 不加这句话，则默认是true，则程序不会等待ajax请求返回就执行了return，所以返回不了ajax的值
						success : function(data) {
							// alert(JSON.stringify(data))
							if (data==1) {
								parent.layer.msg("修改成功");	
								parent.$(".mood").text(moodText);
								parent.layer.close(index);							
							}else if (condition) {
								parent.layer.msg("修改失败，请刷新页面");
							}
										
						},
						error : function() {
							parent.layer.msg("当前未登录");
						}
					});
					
					
				}

			});
			//关闭按钮点击事件
			$(".btn-close").click(function() {
				parent.layer.close(index);
			});
		})
	</script>
	<script src="js/bootstrap.min.js"></script>

</html>