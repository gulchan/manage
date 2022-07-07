# manage
管理项目
# springboot 项目，集成了redis、activeMQ、spring Mail、quartz、swagger、mybatis-plus、jpa
# 本项目主要用于学习springboot集成各个组件，学习各个组件的用法
# redis 作为缓存数据库，反正就是key-value形式的高速缓存，看着用在哪可以提高一点效率
# activeMQ 作为JMS的消息队列，了解消息队列基本的用法，业务代码分两块，一个作为生产者往指定名称的消息队列中添加消息；一个作为消费者监听在指定名称的消息队列，当有消息来时进行消费；用于异步业务处理
# spring mail 集成邮件发送功能，配置邮件发送的客户端，然后通过spring mail提供的邮件发送工具类，实现邮件发送
# quartz 定时任务，用于实现定时任务的执行，主要配置任务主体、任务执行的时机 
# swagger 实现接口文档以及接口调试功能；添加swagger配置，在实体类、controller中添加注解
# mybatis-plus 可以根据配置自动生成整套的代码，可生成实体类、controller、service、mapper、xml；基于BaseMapper 实现了单表的基础增删查改
# jpa 也是dao层，用于访问数据库，根据dao层接口的命名就可以解析相应业务
额外：
# springboot中导入spring的xml进行配置
# springboot中使用原生web组件，servlet、filter、listener
