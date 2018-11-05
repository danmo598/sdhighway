package com.highway.generator;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ResourceBundle;

/**
 * Creaed by fj on 2018/11/5
 */
public class AutoGeneratorHelper {


    public static void main(String[] args) {

        //用来获取Mybatis-Plus.properties文件的配置信息
        ResourceBundle rb =  ResourceBundle.getBundle("mybatis-plus");
        AutoGenerator mpg = new AutoGenerator();


        // 全局配置
        GlobalConfig gc = new GlobalConfig();


        gc.setOutputDir(rb.getString("OutputDir"));

        gc.setFileOverride(true);
        gc.setActiveRecord(true);// 开启 activeRecord 模式
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(false);// XML columList
        gc.setAuthor(rb.getString("author"));
        mpg.setGlobalConfig(gc);


        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setTypeConvert(new MySqlTypeConvert());
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername(rb.getString("userName"));
        dsc.setPassword(rb.getString("passWord"));
        dsc.setUrl(rb.getString("url"));
        mpg.setDataSource(dsc);


        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setTablePrefix(new String[] { "sd_"});// 此处可以修改为您的表前缀
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
        strategy.setInclude(new String[] { rb.getString("tableName")}); // 需要生成的表
        // 字段名生成策略
        // strategy.setFieldNaming(NamingStrategy.underline_to_camel);
        //strategy.setSuperServiceImplClass("com.baomidou.springwind.service.support.BaseServiceImpl");
        mpg.setStrategy(strategy);


        // 包配置
        PackageConfig pc = new PackageConfig();
        // pc.setModuleName("test");
        //pc.setParent(rb.getString("parent"));// 自定义包路径
        pc.setParent(null);

        pc.setEntity("com.highway.model");
        pc.setMapper("com.highway.mapper");
        pc.setXml("com.highway.mapper");

        pc.setController("com.highway.controller");
        pc.setService("com.highway.service");
        pc.setServiceImpl("com.highway.service.impl");
       /* pc.setController("controller."+rb.getString("className"));// 这里是控制器包名，默认 web
        pc.setEntity("model."+rb.getString("className"));
        pc.setMapper("dao."+rb.getString("className"));
        pc.setXml("mapping."+rb.getString("className"));
        pc.setService("service."+rb.getString("className"));
        pc.setServiceImpl("service."+rb.getString("className")+".impl");*/
        mpg.setPackageInfo(pc);


        // 自定义模板配置，可以 copy 源码 mybatis-plus/src/main/resources/templates 下面内容修改，
        // 放置自己项目的 src/main/resources/templates 目录下, 默认名称一下可以不配置，也可以自定义模板名称
        TemplateConfig tc = new TemplateConfig();
        tc.setController("/template/Controller.java.btl");
        tc.setService("/template/Service.java.btl");
        tc.setServiceImpl("/template/ServiceImpl.java.btl");
        tc.setEntity("/template/Model.java.btl");
        tc.setMapper("/template/Mapper.xml.btl");
        tc.setXml("/template/mapper.xml.btl");

        mpg.setTemplate(tc);
        // 执行生成
        mpg.execute();
    }


}
