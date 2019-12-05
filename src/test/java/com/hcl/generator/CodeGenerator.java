package com.hcl.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.jupiter.api.Test;

/**
 * @Author :liangHuang.
 * @Date :2019/6/17 16:54
 * @Description :mybatis-plus代码生成器类
 */
public class CodeGenerator {
    /**
     * 代码生成配置代码
     */
    @Test
    public void startCode() {
        //1.全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig
                //是否支持AR模式
                .setActiveRecord(false)
                //作者
                .setAuthor("liangHuang")
                //生成路径
                .setOutputDir("D:\\develope\\ideaworkspace\\ware-house-erp\\src\\main\\java")
                //是否开启文件覆盖
                .setFileOverride(true)
                //主键策略
                .setIdType(IdType.AUTO)
                //设置生成的service接口的名字首字母是否为I
                .setServiceName("I%sService")
                //是否生成基本的baseResultMap映射
                .setBaseResultMap(true)
                //是否生成sql片段
                .setBaseColumnList(true);
        //2. 数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig
                //数据库类型
                .setDbType(DbType.MYSQL)
                //驱动名称
                .setDriverName("com.mysql.cj.jdbc.Driver")
                //地址
                .setUrl("jdbc:mysql://localhost:3306/warehouse?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf-8")
                //用户名
                .setUsername("root")
                //密码
                .setPassword("123456");
        //3. 策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig
                //全局大写命名
                .setCapitalMode(true)
                //指定表名字段名是否使用下划线
              /*  .setDbColumnUnderline(true)*/
                //数据表命名到实体的命名策略
                .setNaming(NamingStrategy.underline_to_camel)
                //表名前缀
                /*.setTablePrefix("sys_")*/
                //要生成的表
                .setInclude("sys_loginfo");
        //4. 包名策略配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig
                //父包名称
                .setParent("com.hcl.warehouse.sys")
                //实体类
                .setEntity("entity")
                //mapper包
                .setMapper("mapper")
                //service包
                .setService("service")
                .setServiceImpl("service.impl")
                //controller包
                .setController("controller")
                //xml映射文件
                .setXml("mapper");
        //5.整合配置
        AutoGenerator autoGenerator = new AutoGenerator();
        autoGenerator
                .setGlobalConfig(globalConfig)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(packageConfig);
        //6.执行
        autoGenerator.execute();
    }
}
