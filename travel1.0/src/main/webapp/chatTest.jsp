<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>聊天TEST</title>
</head>
<body>
	<input type="text" id="sendContent1">
	<input type="button" id="sendBtn1" value="发送1">
	<input type="text" id="sendContent2">
	<input type="button" id="sendBtn2" value="发送2">
	<div id="showContent"></div>
</body>
<script src="js/personal/jquery-2.1.3.min.js"></script>
<script type="text/javascript">	
	function onMessage(event) {
		$("#showContent").append("<br />"+ event.data+"");
	}

	function onOpen(event) {
		$("#showContent").text() = "已上线";
	}

	function onError(event) {
		alert(event.data);
	}
	
	$(function () {
		var nickName = ""; 
		var host = "ws://localhost:8080/travel1.0/chattest"+nickName;
		var webSocket = new WebSocket(host);
		$("#sendBtn1").click(function () {
			
			webSocket.onerror = function(event) {
				onError(event)
			};

			webSocket.onopen = function(event) {
				onOpen(event)
			};

			webSocket.onmessage = function(event) {
				onMessage(event)
			};			
			webSocket.send( "已上线");
		});
	});
</script>
</html>