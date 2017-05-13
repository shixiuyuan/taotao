#  淘淘商城(SSM)-----day01
   
-----
 1. 
 2. ## 后台管理系统工程搭建
      ---
        ### **1.1 父工程的搭建 :   - 父工程应该是一个pom工程 , 在父工程中定义依赖的jar包信息.**
<br> ![](https://leanote.com/api/file/getImage?fileId=5915de88ab64416a6200fe73) <br>
        
         - ![](https://leanote.com/api/file/getImage?fileId=591659dbab64416a62010450)
         <br><br>
        
        ### **1.2 创建一个common工程 :   需要继承taotao-parent工程**
        
        pom文件 :依赖里是项目需要的公共组件
<br>
![](https://leanote.com/api/file/getImage?fileId=5916608eab64416a620104e6)
<br>
 ![](https://leanote.com/api/file/getImage?fileId=5915de88ab64416a6200fe74)
       
 
   <br>
    
 ### **1.3 taotao-manager工程**
      pom文件  
``` 
<!-- 依赖管理 -->
            <dependencies>
                <dependency>
                    <groupId>com.taotao</groupId>
                    <artifactId>taotao-common</artifactId>
                    <version>1.0-SNAPSHOT</version>
                </dependency>
            </dependencies>
```

<br>  
### **1.4 taotao-manager-pojo模块**
 
>  这模块的pom不需要修改，taotao-manager-pojo模块不依赖任何jar包。
   
 ![](https://leanote.com/api/file/getImage?fileId=59164ff8ab64416a620103d5)
 <br>
### **1.5 taotao-manager-mapper模块**
>pom : 
```
<!-- 依赖管理 -->
    <dependencies>
        <dependency>
            <groupId>com.taotao</groupId>
            <artifactId>taotao-manager-pojo</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
        <!-- Mybatis -->
        
        <!-- MySql -->
        <
        <!-- 连接池 -->
        
    </dependencies>
```
<br>
### **1.6 taotao-manager-service模块**
> pom : 
```
<!-- 依赖管理 -->
        <dependencies>
            <dependency>
                <groupId>com.taotao</groupId>
                <artifactId>taotao-manager-mapper</artifactId>
                <version>1.0-SNAPSHOT</version>
            </dependency>

            <!-- Spring -->
           

        </dependencies>
```
<br>
### **1.6 taotao-manager-web模块**
<br>
![](https://leanote.com/api/file/getImage?fileId=5916a5d1ab64416a62010c85)
<br>
> pom
```
<packaging>war</packaging>

 <dependencies>

        <dependency>
            <groupId>com.taotao</groupId>
            <artifactId>taotao-manager-service</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>

        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>3.8.1</version>
            <scope>test</scope>
        </dependency>
        <!-- JSP相关 -->
        jstl,servlet,jsp
           
        <!-- 文件上传组件 -->
        <dependency>
            <groupId>commons-fileupload</groupId>
            <artifactId>commons-fileupload</artifactId>
        </dependency>
        
    </dependencies>
```

> 更改web.xml
```
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xmlns="http://java.sun.com/xml/ns/javaee" xmlns:web="http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd"
         xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd"
         id="taotao" version="2.5">
  <display-name>taotao-manager</display-name>
  <welcome-file-list>
    <welcome-file>index.html</welcome-file>
    <welcome-file>index.htm</welcome-file>
    <welcome-file>index.jsp</welcome-file>
    <welcome-file>default.html</welcome-file>
    <welcome-file>default.htm</welcome-file>
    <welcome-file>default.jsp</welcome-file>
  </welcome-file-list>
</web-app>
```

### **1.7在taotao-manager的pom下配置tomacat**
```
<build>
		<!-- 配置插件 -->
		<plugins>
			<plugin>
				<groupId>org.apache.tomcat.maven</groupId>
				<artifactId>tomcat7-maven-plugin</artifactId>
				<configuration>
					<port>8080</port>
					<path>/</path>
				</configuration>
			</plugin>
		</plugins>
	</build>
```
![](https://leanote.com/api/file/getImage?fileId=5916a5d2ab64416a62010c89)
<br>
> **先把taotao-common和taotao-parent安装到本地仓库中**
![](https://leanote.com/api/file/getImage?fileId=5916a5d1ab64416a62010c87)

<br>

> 启动tocamt
![](https://leanote.com/api/file/getImage?fileId=5916a5d1ab64416a62010c84)
<br>
成功运行:
![](https://leanote.com/api/file/getImage?fileId=5916a5d2ab64416a62010c88)


<br><br>
### SVN可视化工具:  (我用的github)
VisualSVN:http://www.visualsvn.com/server/download
> 安装时遇到端口443被占用时 : 
![](https://leanote.com/api/file/getImage?fileId=5916a5d1ab64416a62010c86)



























