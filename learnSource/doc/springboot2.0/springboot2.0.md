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

###WebFlux 
> Reactor基础：Java Lambda 、 Mono、 Flux   
> web Flux核心： 
 --  Web MVC注解，
 -- 函数式声明: RouterFunction
 --  异步非阻塞 Netty Reactor  
> 优势和劣势： 


##springboot启动
###spring-boot-autoconfigure/spring.factories 
 > 这里配置了springboot的启动文件，包括Initializers 初始化入口 key为接口    

## SpringFramework手动装配
Spring 模式注解装配
定义： 一种用于声明在应用中扮演 组件的注解
举例：@Component/@Service/@Configuration
装配：<context:component-scan> 2.5或者是@ComponentScan Spring3.0


@Enable 模块匹配注解
举例@EnableWebMvc/@EnableAutoConfiguration

// 装配者会 如果没有实现ImportSelector 就装配本身，如果实现了，就装配返回值的类对象。
@Import(HelloWorldImportSelector.class)
```$xslt
public class HelloWorldImportSelector implements ImportSelector {

    public HelloWorldImportSelector() {
        System.out.println("HelloWorldImportSelector is start");
    }

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{TestBean.class.getName()};
    }
}
```  


Spring 条件装配
Bean装配的前置判断，
@Profile  3.1 , 
@Conditional
    -> ConditionalOnClass 类存在


springboot 自动装配
定义：基于约定大于配置的原则，实现Spring组件自动装配的目的。
装配：模式注解，@Enable模块、条件装配、工厂加载机制
                                -- 实现类 SpringFactoriesLoader
                                -- 配置资源: /META-INF/spring.factories
实现：激活自动装配。实现自动装配、配置自动装配的实现

实现方式：
1.激活自动装配:@EnableAutoConfiguration
2.实现自动装配:XXXAutoConfiguration
3.配置自动装配实现： /META-INF/spring.factories