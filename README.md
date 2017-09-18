magician是基于spring-cloud实现的微服务的框架，其中包括配置管理、服务发现、断路器、路由、微代理、事件总线、全局锁、决策竞选、分布式会话等。

项目启动步骤：

1、先install阿里云用到的jar
   cd ./script
   sh install-jar.sh

2、install magician

3、优先启动eureka，然后在启动其他服务

4、模块说明：
   ➀common-* ：公共代码
   ➁platform-*：架构平台服务
   ➂service-*：业务服务


PS:该框架仅仅是一个雏形，尚不完善，环境一起学习交流。
