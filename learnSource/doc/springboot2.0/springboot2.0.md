#说明： 这是springboot 2.0的文档
***
###三大件
* 依赖
* 配置
* 注解

###外部化配置
### 组件自动装配
### springboot Starter 
#### 组件自动装配
   * 激活： @EnableAutoConfiguration 开启自动化
   * 配置： /META-INF/spring.factories --配置了包括启动className 配置的启动类（相对于ClassPath目录）
   * 实现： XXXAutoConfiguration  规约形式

##与Web的联系


##springboot启动
###spring-boot-autoconfigure/spring.factories 
 > 这里配置了springboot的启动文件，包括Initializers 初始化入口 key为接口