# Online_shopping_mall
1.网上商城使用springboot1.5.14+mybatis+bootstrap3.X+mysql5.X+logbcak
2.其中验证使用nice validator 和ajax验证。
3.富文本编辑器用的是ckeditor4
在config.js可以配置上传的路径。

4.其中nice validator 的js和jquery.form.js冲突，会导致，jquery.form.js中的ajaxSubmit失效。
5.使用了jersey来实现文件服务器和业务服务器的分离；（一般浏览器不支持put请求，Jersey支持）
在D:\apache-tomcat-9.0.8\conf\web.xml中
<servlet>
        <servlet-name>default</servlet-name>
        <servlet-class>org.apache.catalina.servlets.DefaultServlet</servlet-class>
        <init-param>
            <param-name>debug</param-name>
            <param-value>0</param-value>
        </init-param>
        <init-param>
        	<param-name>readonly</param-name>
        	<param-value>false</param-value>
        </init-param>
        <init-param>
            <param-name>listings</param-name>
            <param-value>false</param-value>
        </init-param>
        <load-on-startup>1</load-on-startup>
</servlet>
添加红色字体部分。以使得tomcat支持put请求。
上传格式支持jpg，gif,wmf.
