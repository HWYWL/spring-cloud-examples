# spring-cloud-consul-client
使用consul用于实现分布式系统的服务发现与配置，用于代替zookeeper。

下载consul，使用consul agent -dev命令启动，访问http://127.0.0.1:8500/ui，就可以看见如下效果：
![](https://i.imgur.com/rVAipao.jpg)

在Spring Boot中使用@EnableDiscoveryClient 注解启动，就能自动识别，当然需要先引用如下配置：
```
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-consul-discovery</artifactId>
</dependency>
```

启动之后就能在consul的管理中心看见我们的服务了：
![](https://i.imgur.com/anQokJG.jpg)
具体详情请看代码。