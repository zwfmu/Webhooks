# Webhooks

java执行预设命令，通过http调用，兼容linux和windows。

简单而言之，就是在浏览器中输入预设的命令，服务器执行相应的脚本或命令

## 使用方法

## 前期准备

1. 准备数据库 mysql 5.x以上，创建一个数据库 `commond` 
2. 数据库配置文件位置`src/main/resources/application-prod.properties`
  根据情况修改
  ```
  spring.datasource.url=jdbc:mysql://localhost:3306/command?useUnicode=true&characterEncoding=utf-8
  spring.datasource.username=command
  spring.datasource.password=command
  ```
## 编译安装 

1. 服务器安装mvn3.x，java1.8 ，tomcat8.5以上
2. `mvn package`执行编译打包，将target目录下的war包放入tomcat启动，注意logs是否报错

## 使用

1. 在之前的数据库里，看到一张表，然后打开它，创建 指令 name 和 指令command,如name：“mvn” command：“mvn -v”
2. 远程调用：
 - linux下 post 访问：`http://ip:port/execLinux/{name}`会自动触发该指令。 见下面例子。
 - windows下 post 访问：`http://ip:port/execWin/{name}`会自动触发该指令。 见下面例子。


## 举例

远程调用：
```
http://ip:port/execLinux/mvn
```

且数据库里存了“mvn”命令对应的是“mvn -v”，则执行得到的结果是：

```
Apache Maven 3.3.9 (bb52d8502b132ec0a5a3f4c09453c07478323dc5; 2015-11-11T00:41:47+08:00)
Maven home: /home/ubuntu/apache-maven-3.3.9
Java version: 1.8.0_131, vendor: Oracle Corporation
Java home: /home/ubuntu/jdk1.8.0_131/jre
Default locale: en_US, platform encoding: ANSI_X3.4-1968
OS name: "linux", version: "4.4.0-53-generic", arch: "amd64", family: "unix"
```

