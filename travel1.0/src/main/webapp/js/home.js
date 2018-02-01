$(function() {
	//定义一个数组用来存放所有文章内容
	var exContents = new Array();
	//加载主页时，遍历所有文章内容，并且截取第一个<p>标签中的内容，将完整内容存入数组exContents
	$(".read-more").each(function() {
		var exContent = $(this).prev().html();		
		exContents.push(exContent);
		var contentArray = exContent.split("</p>");
		var preContent = exContent.substring(0,contentArray[0].length+4);
		$(this).prev().html(preContent);
	})
	//继续阅读按钮点击时，遍历所有read-more类，将当前div相同的index返回，用这个index去取数组的内容并显示
	//判断次数实现展开与收起
	var clickCount = 0;
	$(".read-more").children("a").click(function() {
		clickCount = clickCount+1;
		var readMore = $(this).parent();
		if (clickCount%2!=0) {
			$(this).text("收起");		
			var length;
			$(".read-more").each(function(index) {
				if ($(this).is(readMore)) {
					length = index;
				}
			})
			readMore.prev().html(exContents[length]);
		}else {			
			$(this).text("继续阅读");	
			var exContent = readMore.prev().html();
			var contentArray = exContent.split("</p>");
			var preContent = exContent.substring(0,contentArray[0].length+4);
			readMore.prev().html(preContent);
		}
		
	});
});