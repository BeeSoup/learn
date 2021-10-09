
nginx core -> http 
           -> mail

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
 
gzip_min_length 1; #1个字节的文件不压缩

gzip_comp_level 3; #压缩比 压缩级别
#定义压缩文件的类型 不至这些配置
gzip_types text/plain application/javascript
 
main 全局配置
events 配置工作模式以及连接数
http http模块
    server 虚拟主机
    location 路由规则
    upstream 集群，内网（负载均衡）

include 加载文件，通过，加载文件分阶段配置 
  
错误级别：
    debug info notice warn error crit
    
Cross-Origin Resource Sharing
CORS
Nginx ： 跨域问题（）
# 允许跨域请求的域， * 代表所有
add_header 'Access-Control-Allow-Origin' *;
# 允许带上cookie请求
add_header 'Access-Control-Allow-Credentials' 'true';
# 允许请求的方法， 比如 GET/POST/PUT/DELETE
add_header 'Access-Control-Allow-Methods' *;
# 允许请求的header
add_header 'Access-Control-Allow-Headers' *;
    
# 对源站点验证
valid_referers *.zhangyu.com;
# 非法引入会进入下方判断

if ($invalid_referer) {
 return 404;
}
    
    
-- 负债均衡
四层 ip和端口 记录连接处理的IP
F5 硬件负载均衡
LVS 四层负载均衡
Haproxy 四层负载均衡
Nginx 四层负载均衡

和
七层负载均衡
Url ip http
Nginx 负载均衡
Haproxy 负载均衡
apache 
    
    
nginx 如何支持集群部署 Web 操作流程

# 配置上游服务器
upstream test {
# server
    server ip:port;
    server ip:port;
}
server {
    listen 80;
    server_name www.test.com;
    location / {
    # 放到代理块
        proxy_pass http://test;
    }
}    
    
JMeter   
    
nginx：一千零一问：
 1、为什么使用nginx？