<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form id="testImageForm">
		<input type="file" id="testImage" name="myHead">
		<span type="button" id="testBtn">上传</span>
	</form>
</body>

<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#testBtn").click(function () {
			var formData = new FormData($("#testImageForm")[0]);  // 要求使用的html对象
   	     $.ajax({  
   	          url: "uploadHead" ,  
   	          type: "post",  
   	          data: formData,  
   	          async: true,
   	          contentType: false,  // 下面三个参数要指定，如果不指定，会报一个JQuery的错误
   	          cache: false,
   	          processData: false,
   	          success: function (data) {  
   	              alert(data);  
   	          },  
   	          error: function (data) {  
   	        	alert("失败");  
   	          }  
   	     });
		});
	});
</script>
</html>