安装：
    run install
    
SpringBoot1.X ->2.X ：
    对于数据源：HikariCP(JDBC高性能快连接池) 默认数据源
    
创建了两种反向生成的工具工程：
    一个是mybatis-plus 一个是mybatis 对于mybatis的工程，users 会有误
    
    
集群部署存在的问题：
    用户会话，---- redis分布式会话
    定时任务 ----- 到点，每个服务节点都会执行,单独节点处理，mq 延时
    内网互通