package com.zy.newsource.util;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

/**
 * @Auther yuhz30333
 * @CreateDate 2020/5/7 - 16:23
 * @Version 1.0
 * @Description
 */
public class BaseUtils {
    /**
     * 根据表名转换为entity名
     * @param tableName
     * @return
     */
    public static String convertEntityNameByTable(String tableName){
        if (StringUtils.isBlank(tableName)) {
            return tableName;
        }
        StringBuilder entityName = new StringBuilder();
        tableName = tableName.toLowerCase();
        Arrays.asList(tableName.split("_")).forEach(temp -> entityName.append(StringUtils.capitalize(temp)));
        return entityName.toString();
    }
    /**
     * 根据表名转换为mapper的beanId
     * @param tableName
     * @return
     */
    public static String convertMapperBeanIdByTable(String tableName){
        if (StringUtils.isBlank(tableName)) {
            return tableName;
        }
        String mapperName = convertEntityNameByTable(tableName)+ "Mapper";
        String mapperBeanId;

        mapperBeanId = mapperName.substring(0,1).toLowerCase() + mapperName.substring(1,mapperName.length());
        return mapperBeanId;
    }
    /**
     * 根据表名转换为表的beanId
     * @param tableName
     * @return
     */
    public static String convertBeanIdByTable(String tableName){
        if (StringUtils.isBlank(tableName)) {
            return tableName;
        }
        String resultName = convertEntityNameByTable(tableName);
        String resultBeanId;

        resultBeanId = resultName.substring(0,1).toLowerCase() + resultName.substring(1,resultName.length());
        return resultBeanId;
    }
}
