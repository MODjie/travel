function showRegisterForm() {
	$('.loginBox').fadeOut('fast', function() {
		$('.registerBox').fadeIn('fast');
		$('.login-footer').fadeOut('fast', function() {
			$('.register-footer').fadeIn('fast');
		});
		$('.modal-title').html('合作账号登录');
	});
	$('.error').removeClass('alert alert-danger').html('');

}
function showLoginForm() {
	$('#loginModal .registerBox').fadeOut('fast', function() {
		$('.loginBox').fadeIn('fast');
		$('.register-footer').fadeOut('fast', function() {
			$('.login-footer').fadeIn('fast');
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

function loginAjax() {
	/*
	 * Remove this comments when moving to server $.post( "/login", function(
	 * data ) { if(data == 1){ window.location.replace("/home"); } else {
	 * shakeModal(); } });
	 */

	/* Simulate error message from the server */
	shakeModal();
}

function shakeModal() {
	$('#loginModal .modal-dialog').addClass('shake');
	$('.error').addClass('alert alert-danger').html("账号或者密码错误");
	$('input[type="password"]').val('');
	setTimeout(function() {
		$('#loginModal .modal-dialog').removeClass('shake');
	}, 1000);
}

/**
 * 加载主页时判断是否有用户，如果没有就提示登录注册模态框
 * @returns
 */
$(function() {
	$.ajax({
		type : "GET",
		url : "isLogin",
		dataType : "json",
		success : function(data) {	
			if (data == "未登录") {
				openLoginModal();
			}
		}
	});
});
