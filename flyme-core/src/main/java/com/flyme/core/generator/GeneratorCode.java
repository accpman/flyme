package com.flyme.core.generator;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.flyme.common.exception.BizException;
import com.flyme.common.utils.ObjectUtils;
import com.flyme.core.springmvc.base.MbsBaseController;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;

import java.util.Objects;


/**
 * @author  flyme
 * @date   2018/3/6 14:44
 * @desc:  代码生成器生成模板配置
 */
@Component
public class GeneratorCode {
    private static final Logger log = LoggerFactory.getLogger(GeneratorCode.class);
    @Autowired
    public DataSourceProperties dataSourceProperties;

    public void init(GeneratorConfig config) {
        String tableName = config.getTableName();
        Boolean baseModule = config.getBaseModule();
        if (StringUtils.isEmpty(tableName)) {
            log.error("请填写要生成的表名");
            return;
        }
        String parentModule = tableName.substring(tableName.indexOf("_") + 1, tableName.indexOf("_", 2));
        String moduleName = (tableName.substring(tableName.indexOf("_",2))).replace("_", "");
        System.out.println(parentModule);
        String tablePrefix = tableName.substring(0, tableName.indexOf("_", 2));
        System.out.println(tableName);
        String path = Objects.requireNonNull(Objects.requireNonNull(ClassUtils.getDefaultClassLoader()).getResource("")).getPath();
        System.out.println(path);
        String baseOutPath = path.substring(0, path.indexOf("target") - 1);
        System.out.println(baseOutPath);
        if (baseModule) {
            baseOutPath = baseOutPath.substring(0, baseOutPath.lastIndexOf("/")) + "/flyme-module/" + "flyme-" + parentModule;
            System.out.println(baseOutPath);
        }
        System.out.println(tablePrefix);
        AutoGenerator mpg = new AutoGenerator();
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(baseOutPath + "/src/main/java");
        gc.setFileOverride(false);
        //不需要ActiveRecord特性的请改为false
        gc.setActiveRecord(false);
        //XML 二级缓存
        gc.setEnableCache(false);
        //XML ResultMap
        gc.setBaseResultMap(false);
        //XML columList
        gc.setBaseColumnList(false);
        gc.setKotlin(false);
        //是否生成 kotlin 代码
        gc.setAuthor(config.getAuthor());
        mpg.setGlobalConfig(gc);
        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setTypeConvert(new MySqlTypeConvert() {
            // 自定义数据库表字段类型转换【可选】
            @Override
            public DbColumnType processTypeConvert(String fieldType) {
                System.out.println("转换类型：" + fieldType);
                // 注意！！processTypeConvert 存在默认类型转换，如果不是你要的效果请自定义返回、非如下直接返回。
                return super.processTypeConvert(fieldType);
            }
        });
        dsc.setDriverName(dataSourceProperties.getDriverClassName());
        dsc.setUsername(dataSourceProperties.getUsername());
        dsc.setPassword(dataSourceProperties.getPassword());
        dsc.setUrl(dataSourceProperties.getUrl());
        mpg.setDataSource(dsc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        // 此处可以修改为您的表前缀
        strategy.setTablePrefix(tablePrefix);
        // 表名生成策略(下划线转驼峰)
        strategy.setNaming(NamingStrategy.underline_to_camel);
        // 需要生成的表
        strategy.setInclude(tableName);
        // 自定义实体，公共字段
        strategy.setSuperEntityColumns("createDate", "modifyDate", "modifyUser");
        // 自定义实体父类
        strategy.setSuperEntityClass("com.flyme.core.mybatis.base.AbstractEntity");
        // 自定义 mapper 父类
        strategy.setSuperMapperClass("com.flyme.core.mybatis.base.SuperMapper");
        // 自定义 service 父类
        strategy.setSuperServiceClass("com.flyme.core.mybatis.service.IBaseService");
        // 自定义 service 实现类父类
        strategy.setSuperServiceImplClass("com.flyme.core.mybatis.service.BaseServiceImpl");
        // 自定义 controller 父类
        strategy.setSuperControllerClass("com.flyme.core.springmvc.base.MbsBaseController");
        // 实体是否为构建者模型
        strategy.setEntityBuilderModel(true);
        strategy.setControllerMappingHyphenStyle(true);
        mpg.setStrategy(strategy);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.flyme." + parentModule);
        pc.setModuleName(moduleName);
        pc.setController("controller");
        mpg.setPackageInfo(pc);
        mpg.execute();
    }
}