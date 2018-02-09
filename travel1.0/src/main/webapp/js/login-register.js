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
					layer.msg("登录成功");
					window.location.reload();
				} else if (data == -1) {
					shakeModal("账号不存在");
				} else if (data == -2) {
					shakeModal("密码错误");
				} else if (data == -4) {
					shakeModal("不能重复登录");
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
			layer.msg("注册成功");
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
		async : false, // 不加这句话，则默认是true，则程序不会等待ajax请求返回就执行了return，所以返回不了ajax的值
		success : function(data) {
			identifyCode = data;
		}
	});
	return identifyCode;

}

// 验证码登录Ajax请求
function identifyCodeLoginAjax() {
	var tel = $(".telphone2").val();
	$.ajax({
		type : "get",
		url : "login",
		data : {
			nickName : tel,
			password : "验证码"
		},
		dataType : "json",
		async : false, // 不加这句话，则默认是true，则程序不会等待ajax请求返回就执行了return，所以返回不了ajax的值
		success : function(data) {
			if (data == 1) {
				layer.msg('登录成功')
				window.location.reload();
			} else if (data == -4) {
				shakeModal("不能重复登录");
			} else {
				shakeModal("请检查手机号码");
			}

		}
	});
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
function checkMobile(sMobile) {
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
			url : "hasUserByNickName",
			data : {
				nickName : nickName
			},
			dataType : "json",
			async : false,
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
		return false;
	} else {
		return true;
	}
}

// 验证密码
function checkPassword(password) {
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
function checkIdentifyCode(realCode, inputCode) {
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
// 重新获取验证码倒计时
function countDown(getCodeBtn) {
	var countTime = 119;
	$(getCodeBtn).attr('disabled', "true");
	var myVar = setInterval(function() {
		getCodeBtn.val("重新获取：" + countTime);
		countTime = countTime - 1;
		if (countTime < -1) {
			clearInterval(myVar);
			$(getCodeBtn).removeAttr("disabled");
			getCodeBtn.val("获取验证码");
		}
	}, 1000);
}

$(function() {
	// 正确的验证码
	var realCode;
	// 各验证的标志
	var isTelRight = false;
	var isNicknameRight = false;

	// 验证码输入框失去焦点验证
	$(".identifyCode,.identifyCode2").blur(function() {
		checkIdentifyCode(realCode, $(this).val());
	});
	// 注册窗口中的获取验证码按钮点击事件
	$(".btn-getCode").click(function() {
		var identifyCode = 0;
		var tel = $(".telphone").val();
		isTelRight = checkMobile(tel);
		if (isTelRight == true) {
			realCode = identifyCodeAjax(tel);
			countDown($(this));
		}
	});
	// 验证码登录窗口中的获取验证码按钮点击事件
	$(".btn-getCode2").click(function() {
		var identifyCode = 0;
		var tel = $(".telphone2").val();
		if (checkMobile(tel) == true) {
			realCode = identifyCodeAjax(tel);
			countDown($(this));
		}
	});
	// 忘记密码获取验证码按钮点击事件
	$(".btn-getCode3").click(function() {
		var identifyCode = 0;
		var tel = $(".telphone3").val();
		if (checkMobile(tel) == true) {
			// 发送输入手机号是否已经注册过的
			$.ajax({
				type : "GET",
				url : "hasUserByTel",
				data : {
					telphoneNum : tel
				},
				async : false,
				dataType : "json",
				success : function(data) {
					if (data == -1) {
						successFlag = 1;
					} else {
						shakeModal("该号码未注册");
						successFlag = -1;
					}
				}
			});
			if (successFlag == 1) {
				realCode = identifyCodeAjax(tel);
				countDown($(this));
			}

		}
	});
	// 昵称input失去焦点发送ajax请求验证昵称是否可用
	$(".registerNickName").blur(function() {
		isNicknameRight = checkNickName();
	});
	// 密码失去焦点验证
	$(".registerPassword,.newPassword").blur(function() {
		checkPassword($(this).val());
	});
	// 确认密码失去焦点验证
	$(".password_confirmation").blur(function() {
		checkPasswordConfim();
	});

	// 注册按钮点击事件,发送ajax请求
	$(".btn-register")
			.click(
					function() {
						var tel = $(".telphone").val();
						var successFlag = 0;
						// 发送ajax请求判断手机号是否可用
						$.ajax({
							type : "GET",
							url : "hasUserByTel",
							data : {
								telphoneNum : tel
							},
							async : false,
							dataType : "json",
							success : function(data) {
								if (data == -1) {
									successFlag = -1;
								} else {
									inputRight("该号码可用");
									successFlag = 1;
								}
							}
						});
						if (isTelRight == true
								&& isNicknameRight == true
								&& checkPassword($(".registerPassword").val()) == true
								&& checkPasswordConfim() == true
								&& checkIdentifyCode(realCode, $(
										".identifyCode").val()) == true
								&& successFlag == 1) {
							registerAjax();
						} else if (successFlag == -1) {
							// 验证码重置
							realCode = 0;
							$("identifyCode").val("");
							shakeModal("该号码已被使用");
						}
					});

	// 登录按钮点击事件，发送ajax请求
	$(".btn-login").click(function() {
		loginAjax();
	});
	// 验证码登录按钮点击事件，发送ajax请求
	$(".btn-code-login").click(function() {
		if (checkIdentifyCode(realCode, $(".identifyCode2").val()) == true) {
			identifyCodeLoginAjax();
			$(".telphone2").val("");
			$(".identifyCode2").val("");
		}
	});

	// 忘记密码确认修改按钮点击事件
	$(".btn-update-password").click(function() {
		var tel = $(".telphone3").val();
		var password = $(".newPassword").val();
		$.ajax({
			type : "post",
			url : "forgetPassword",
			data : {
				_method : "put",
				telphoneNum : tel,
				password : password
			},
			dataType : "json",
			async : false,
			success : function(data) {
				if (data == 1) {
					layer.msg("修改成功");
					openLoginModal();
					$(".telphone3").val("");
					$(".identifyCode3").val("");
					$(".newPassword").val("");
				}
			},
			error :function(){
				layer.msg("修改失败");
			}
		});
	});	
});
