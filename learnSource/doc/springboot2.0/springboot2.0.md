#说明： 这是springboot 2.0的文档
***
###三大件
* 依赖
* 配置
* 注解

### 外部化配置：Environment抽象，生命周期，破坏性变更 
### 组件自动装配:模式注解，@Enable模块，条件装配，加载机制 （核心特性）
### 嵌入式容器：Servlet Web容器，Reactive Web容器 native （核心特性）
### springboot Starter : 依赖管理 装配条件，装配顺序 
### production-Ready : 健康检查、数据指标、@Endpoint管控 （核心特性） 包括外部化配置问题

#### 组件自动装配
   * 激活： @EnableAutoConfiguration 开启自动化
   * 配置： /META-INF/spring.factories --配置了包括启动className 配置的启动类（相对于ClassPath目录）
   * 实现： XXXAutoConfiguration  规约形式
### 为生产准备的特性：
    指标：/actuator/metrics
    健康检查：/actuator/health
    外部化配置：/actuator/configprops
##与Web的联系
###传统的Servlet应用
 > Servlet组件(三大组件)：Servlet/Filter/Listener  
    >> 实现，URL映射，注册  
 > Servlet注册：Servlet注解(3.0)/Spring Bean/RegistrationBean  
 > 异步非阻塞：异步Servlet /非阻塞Servlet
 

###WebMvc
> WEB MVC视图：模板引擎，内容协商，异常处理等
  -- ViewResolver @ExceptionHandler HandlerExceptionResolver BasicErrorController (Spring boot)      
> WEB REST: 资源服务、资源跨域、服务发现等   
  -- 资源服务：@RequestMapping @ResponseBody @RequestBody ， 资源跨域：@CrossOrigin/WebMvcConfigurer#addCorsMapping ,  IFrame Jsonp
> WEB 核心： 核心架构，处理流程，核心组件 
 -- DispatcherServlet HandlerMapping  HandleAdapter ViewResolver ModelAndView

##springboot启动
###spring-boot-autoconfigure/spring.factories 
 > 这里配置了springboot的启动文件，包括Initializers 初始化入口 key为接口