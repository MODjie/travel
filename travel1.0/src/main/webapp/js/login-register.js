function showRegisterForm() {
	$('.loginBox,.codeLoginBox,.forgotPasswordBox').fadeOut(
			'fast',
			function() {
				$('.registerBox').fadeIn('fast');
				$('.login-footer,.code-login-footer,.forgot-password-footer')
						.fadeOut('fast', function() {
							$('.register-footer').fadeIn('fast');
						});
				$('.modal-title').html('合作账号登录');
			});
	$('.error').removeClass('alert alert-danger').html('');

}
function showLoginForm() {
	$('#loginModal .registerBox,.codeLoginBox,.forgotPasswordBox')
			.fadeOut(
					'fast',
					function() {
						$('.loginBox').fadeIn('fast');
						$(
								'.register-footer,.code-login-footer,.forgot-password-footer')
								.fadeOut('fast', function() {
									$('.login-footer').fadeIn('fast');
								});

						$('.modal-title').html('合作账号登录');
					});
	$('.error').removeClass('alert alert-danger').html('');
}

function showCodeLoginForm() {
	$('#loginModal .registerBox,.loginBox,.forgotPasswordBox').fadeOut(
			'fast',
			function() {
				$('.codeLoginBox').fadeIn('fast');
				$('.register-footer,.login-footer,.forgot-password-footer')
						.fadeOut('fast', function() {
							$('.code-login-footer').fadeIn('fast');
						});

				$('.modal-title').html('合作账号登录');
			});
	$('.error').removeClass('alert alert-danger').html('');
}

function showForgotPasswordForm() {
	$('#loginModal .registerBox,.loginBox,.codeLoginBox').fadeOut(
			'fast',
			function() {
				$('.forgotPasswordBox').fadeIn('fast');
				$('.register-footer,.login-footer,.code-login-footer').fadeOut(
						'fast', function() {
							$('.forgot-password-footer').fadeIn('fast');
						});

				$('.modal-title').html('合作账号登录');
			});
	$('.error').removeClass('alert alert-danger').html('');
}

function openLoginModal() {
	showLoginForm();
	setTimeout(function() {
		$('#loginModal').modal('show');
	}, 230);

}
function openRegisterModal() {
	showRegisterForm();
	setTimeout(function() {
		$('#loginModal').modal('show');
	}, 230);

}

// 登录ajax请求
function loginAjax() {
	var nickName = $(".account").val();
	var password = $(".password").val();
	if (nickName == "") {
		shakeModal("账号不能为空");
	} else if (password == "") {
		shakeModal("密码不能为空");
	} else {
		$.ajax({
			type : "get",
			url : "login",
			data : {
				nickName : nickName,
				password : password
			},
			dataType : "json",
			success : function(data) {
				if (data == 1) {
					alert("登录成功");
				} else if (data == -1) {
					shakeModal("账号不存在");
				} else if (data == -2) {
					shakeModal("密码错误");
				} else {
					shakeModal("未知错误，请刷新页面重新登录");
				}
			}
		});
	}

}

// 注册ajax请求
function registerAjax() {
	var telphone = $(".telphone").val();
	var nickName = $(".registerNickName").val();
	var password = $(".registerPassword").val();
	$.ajax({
		type : "post",
		url : "register",
		data : {
			TEL : telphone,
			NICKNAME : nickName,
			PASSWORD : password
		},
		dataType : "json",
		// async: false,
		// contentType: "application/json; charset=utf-8",//此处不能省略
		success : function(data) {
			// alert(JSON.stringify(data));//用来查看返回的json数据，一目了然
			$(".account").val(data.nickname);
			$(".password").val(data.password);
			openLoginModal();
			$(".telphone").val("");
			$(".identifyCode").val("");
			$(".registerNickName").val("");
			$(".registerPassword").val("");
			$(".password_confirmation").val("");
		}
	});
}

// 获取验证码Ajax请求
function identifyCodeAjax(tel) {
	var identifyCode = -1;
	$.ajax({
		type : "get",
		url : "getIdentifyCode",
		data : {
			tel : tel
		},
		dataType : "json",
		async : false, //不加这句话，则默认是true，则程序不会等待ajax请求返回就执行了return，所以返回不了ajax的值
		success : function(data) {
			identifyCode = data;
		}		
	});
	return identifyCode;
	 
}

// 出错窗口震动警告
function shakeModal(warm) {
	$('#loginModal .modal-dialog').addClass('shake');
	$('.error').removeClass("alert-success");
	$('.error').addClass('alert alert-danger').html(warm);
	$('input[type="password"]').val('');
	setTimeout(function() {
		$('#loginModal .modal-dialog').removeClass('shake');
	}, 1000);
}
// 输入合法提示
function inputRight(warm) {
	$('.error').html(warm);
	$('.error').removeClass("alert-danger");
	$('.error').addClass('alert alert-success');
}
// 验证手机号码
function checkMobile() {
	var sMobile = $(".telphone").val();
	if (!(/^1[3|4|5|7|8][0-9]\d{8}$/.test(sMobile))) {
		shakeModal("手机号码格式不正确");
		// $(".telphone").focus();
		return false;
	} else {
		inputRight("手机号码格式正确");
		return true;
	}
}
// 验证昵称
function checkNickName() {
	var nickName = $(".registerNickName").val();
	var successFlag = -1;
	if (nickName == "") {
		shakeModal("昵称不能为空");
		// $(".registerNickName").focus();
		return false;
	} else {
		$.ajax({
			type : "GET",
			url : "hasUser",
			data : {
				nickName : nickName
			},
			dataType : "json",
			success : function(data) {
				if (data == -1) {
					shakeModal("该用户已存在");
					successFlag = -1;
					// $(".registerNickName").focus();
				} else {
					inputRight("该昵称可用");
					successFlag = 1;
				}
			}
		});
	}
	// 在ajax方法中return无效，所以返回出来一个标志变量
	if (successFlag == -1) {
		return true;
	} else {
		return false;
	}
}

// 验证密码
function checkPassword() {
	var password = $(".registerPassword").val();
	if (password.length < 6) {
		shakeModal("密码不能小于6位");
		return false;
		// $(".registerPassword").focus();
	} else {
		inputRight("密码长度合法");
		return true;
	}
}

// 确认密码验证
function checkPasswordConfim() {
	var password = $(".registerPassword").val();
	var passwordConfirm = $(".password_confirmation").val();
	// 判断两次密码是否一致
	if (password == passwordConfirm && password != "") {
		inputRight("两次密码一致");
		return true;
	} else if (password != "" && passwordConfirm != "") {
		shakeModal("两次密码不一致，请重新输入");
		$(".registerPassword").val("");
		$(".password_confirmation").val("");
		return false;
	}
}

// 验证码验证
function checkIdentifyCode(realCode) {
	var inputCode = $(".identifyCode").val();
	if (inputCode == realCode) {
		inputRight("验证码正确");
		return true;
	} else if (inputCode == "") {
		shakeModal("请输入验证码");
		return false;
	} else {
		shakeModal("验证码错误");
		return false;
	}
}
//重新获取验证码倒计时
function countDown(getCodeBtn) {
	var countTime = 119;
	$(getCodeBtn).attr('disabled',"true");
	var myVar  = setInterval(function(){ 		 
		   getCodeBtn.val("重新获取："+countTime);
		   countTime=countTime-1;		   
		   if (countTime<-1) {
				clearInterval(myVar);
				$(getCodeBtn).removeAttr("disabled");
				getCodeBtn.val("获取验证码");
			} 
	}, 1000);		
}


$(function() {
	// 正确的验证码
	var realCode;
	// 加载主页时判断是否有用户，如果没有就提示登录注册模态框
	$.ajax({
		type : "GET",
		url : "isLogin",
		dataType : "json",
		success : function(data) {
			if (data == "未登录") {
				openLoginModal();
			}
		}
	/*
	 * , error:function(xhr){ alert("失败了") }
	 */
	});

	// 验证码输入框失去焦点验证
	$(".identifyCode").blur(function() {
		checkIdentifyCode(realCode);
	});
	// 注册窗口中的获取验证码按钮点击事件
	$(".btn-getCode").click(function() {
		var identifyCode = 0;
		var tel = $(".telphone").val();
		if (checkMobile() == true) {
			realCode = identifyCodeAjax(tel);
			countDown($(this));
		}
	});
	// 昵称input失去焦点发送ajax请求验证昵称是否可用
	$(".registerNickName").blur(function() {
		checkNickName();
	});
	// 密码失去焦点验证
	$(".registerPassword").blur(function() {
		checkPassword();
	});
	// 确认密码失去焦点验证
	$(".password_confirmation").blur(function() {
		checkPasswordConfim();
	});

	// 注册按钮点击事件,发送ajax请求
	$(".btn-register").click(
			function() {
				if (checkMobile() == true && checkNickName() == true
						&& checkPassword() == true
						&& checkPasswordConfim() == true
						&& checkIdentifyCode(realCode) == true) {
					registerAjax();
				}
			});

	// 登录按钮点击事件，发送ajax请求
	$(".btn-login").click(function() {
		loginAjax();
	})
});
