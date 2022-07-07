//package com.gulchan.manage.generator;
//
//import com.baomidou.mybatisplus.generator.AutoGenerator;
//import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
//import com.baomidou.mybatisplus.generator.config.GlobalConfig;
//import com.baomidou.mybatisplus.generator.config.PackageConfig;
//import com.baomidou.mybatisplus.generator.config.StrategyConfig;
//import com.baomidou.mybatisplus.generator.config.rules.DateType;
//
//public class MyBatisPlusGeneratorCopy {
//    public static void main(String[] args) {
//        GlobalConfig.Builder builder = new GlobalConfig.Builder();
//        //1. 全局配置
//        GlobalConfig config = builder.build();
//        // 是否支持AR模式
//        builder.author("高骞")
//                // 生成路径，最好使用绝对路径
//                .outputDir("C:\\data\\IdeaProjects\\manage\\src")
//                // 文件覆盖
//                .fileOverride()
//                // 主键策略
////                .setIdType(IdType.AUTO)
//
//                .dateType(DateType.ONLY_DATE);
//                // 设置生成的service接口的名字的首字母是否为I，默认Service是以I开头的
////                .serviceName("%sService")
//
//                //实体类结尾名称
////                .entityName("%sDO")
//
//                //生成基本的resultMap
////                .setBaseResultMap(true)
//
//                //不使用AR模式
////                .setActiveRecord(false)
//
//                //生成基本的SQL片段
////                .setBaseColumnList(true);
//
//        //2. 数据源配置
//        DataSourceConfig.Builder dsConfig = new DataSourceConfig.Builder("jdbc:mysql://127.0.0.1:3306/manage?useSSL=false","gaoqian","123456");
//        // 设置数据库类型
////        dsConfig.setDbType(DbType.MYSQL)
////                .setDriverName("com.mysql.cj.jdbc.Driver")
////                .setUrl("jdbc:mysql://127.0.0.1:3306/xd_shop?useSSL=false")
////                .setUsername("root")
////                .setPassword("123");
//
//        //3. 策略配置globalConfiguration中
//        StrategyConfig.Builder stConfig = new StrategyConfig.Builder();
//
//        //全局大写命名
//        stConfig.enableCapitalMode()
//                // 数据库表映射到实体的命名策略
////                .naming(NamingStrategy.underline_to_camel)
//
//                //使用lombok
////                .setEntityLombokModel(true)
//
//                //使用restcontroller注解
////                .setRestControllerStyle(true)
//
//                // 生成的表, 支持多表一起生成，以数组形式填写
//                .addTableSuffix("user","role","user_role","permission","role_permission");
//        //.setInclude(scanner("表名，多个英文逗号分割").split(","));
//
//        //4. 包名策略配置
//        PackageConfig.Builder pkConfig = new PackageConfig.Builder();
//        pkConfig.parent("com.gulchan.manage")
//                .mapper("dao")
//                .service("service")
//                .controller("controller")
//                .entity("model")
//                .xml("mapper");
//
//        //5. 整合配置
//        AutoGenerator ag = new AutoGenerator(dsConfig.build());
//        ag.global(config)
////                .setDataSource(dsConfig)
//                .strategy(stConfig.build())
//                .packageInfo(pkConfig.build());
//
//        //6. 执行操作
//        ag.execute();
//        logger.info("=======  Done 相关代码生成完毕  ========");
//    }
//}
