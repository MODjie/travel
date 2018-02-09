$(function() {
	// 修改信息保存按钮点击事件
	$(".update-info-btn").click(function() {
		var age = $(".age").find("input").val();
		var sex = $('.sex input[name="sexOprions"]:checked').val();
		var province = $("#province").find("select").eq(0).val();
		var city = $("#province").find("select").eq(1).val();
		var county = $("#province").find("select").eq(2).val();
		var email = $(".Email").find("input").val();
		// 信息未填写完全，则不提交修改请求
		if (checkInfo() == false) {
			return;
		}

		$.ajax({
			type : "post",
			url : "updateUserInfo",
			data : {
				_method : "put",
				AGE : age,
				SEX : sex,
				PROVINCE : province,
				CITY : city,
				COUNTY : county,
				EMAIL : email
			},
			dataType : "json",
			async : false, // 不加这句话，则默认是true，则程序不会等待ajax请求返回就执行了return，所以返回不了ajax的值
			success : function(data) {
				// alert(JSON.stringify(data))
				layer.msg("修改成功");
			},
			error : function() {
				layer.msg("修改失败，请刷新页面重试");
			}
		});
	})
	
	//修改密码按钮点击事件
	$(".update-password-info").click(function() {
		//旧密码验证
		if (checkOldPassword()==false) {
			return;
		}
		//新密码不能为空
		if ($("#new-password-content").val()=="") {
			layer.msg("请输入新密码");
			$("#new-password-content").focus();
			return;
		}
		//新密码长度验证
		if ($("#new-password-content").val().length<6) {
			layer.msg("密码长度为6——16");
			$("#new-password-content").focus();
			return;
		}
		
		//确认密码不能为空
		if ($("#confirm-password-content").val()=="") {
			layer.msg("请输入确认密码");
			$("#confirm-password-content").focus();
			return;
		}
		
		//两次密码是否输入一致
		if ($("#confirm-password-content").val()!=$("#new-password-content").val()) {
			layer.msg("两次密码输入不一致");
			$("#new-password-content").val("");
			$("#confirm-password-content").val("");
			return;
		}
		var PASSWORD = $("#confirm-password-content").val();
		$.ajax({
			type : "post",
			url : "updatePassword",
			data : {
				_method : "put",
				PASSWORD : PASSWORD
			},
			dataType : "json",
			async : false, // 不加这句话，则默认是true，则程序不会等待ajax请求返回就执行了return，所以返回不了ajax的值
			success : function(data) {
				// alert(JSON.stringify(data))
				layer.msg("修改成功,请重新登录");
				location.href="logout";
			},
			error : function() {
				layer.msg("修改失败，请刷新页面重试");
			}
		});		
	});
	
})
// 检查信息填写
function checkInfo() {
	var age = $(".age").find("input").val();
	var province = $("#province").find("select").eq(0).val();
	var email = $(".Email").find("input").val();
	// 年龄不能为空
	if (age == "") {
		layer.msg("年龄未填写");
		$(".age").find("input").focus();
		return false;
	}
	// 家乡未选择
	if (province == "请选择") {
		layer.msg("请选择家乡");
		return false;
	}
	// 邮箱未填写
	if (email == "") {
		layer.msg("邮箱未填写");
		$(".Email").find("input").focus();
		return false;
	} else {// 邮箱格式不正确
		var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
		if (!reg.test(email)) {
			layer.msg('邮箱格式不正确，请重新填写!');
			return false;
		}
	}

	return true;
}