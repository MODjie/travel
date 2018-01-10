2018年1月10日
设计完发布见闻界面，将所有的静态页面整合到工程中。

碰到的问题：
1、工程目录webapp/umeditor/jsp/imageUp.jsp这个文件报错，报错原因：在此jsp文件中使用了
Uploader这个上传文件的辅助类，导入的包的地址为com.baidu.umeditor.um，在本工程中并不存在。
解决方法：
在java/main/src目录下新建包：com.java.travel.util，将Uploader类放入此包中，修改
imgeUp.jsp文件中的导包路径为com.java.travel.util.Uploader。
