package com.flyme.core.generator;

/**
 * @author: flyme
 * @date: 2018/3/6 22:30
 * @desc: 代码生成器自定义配置参数
 */
public class GeneratorConfig {
    /**
     * 作者
     */
    private String author = "flyme";
    /**
     * 是否是父模块
     */
    private Boolean baseModule = false;
    /**
     * 生成表名称
     */
    private String tableName;

    public String getAuthor() {
        return author;
    }

    public GeneratorConfig setAuthor(String author) {
        this.author = author;
        return this;
    }

    public Boolean getBaseModule() {
        return baseModule;
    }

    public GeneratorConfig setBaseModule(Boolean baseModule) {
        this.baseModule = baseModule;
        return this;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
}
