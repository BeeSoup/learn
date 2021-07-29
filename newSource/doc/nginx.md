


# 
命令，包括测试加载文件是否正常。
热部署，重新加载文件
master worker 模型

多路复用
epoll模型 
events 但worker连接

nginx.conf 全局配合 
 /sbin/nginx -s reload
./nginx -h(-?) help
./nginx -t 测试配置文件是否正确，包括格式
./nginx -c  重新定义nginx.conf 文件 pid无效

./nginx -s stop 强制关闭
./nginx -s quit 优雅关闭 当前是否有用户连接着
./nginx -v 版本号
./nginx -V 参数 
 
main 全局配置
events 配置工作模式以及连接数
http http模块
    server 虚拟主机
    location 路由规则
    upstream 集群，内网（负载均衡）

include 加载文件，通过，加载文件分阶段配置 
  
错误级别：
    debug info notice warn error crit
    
    
    
nginx：一千零一问：
 1、为什么使用nginx？