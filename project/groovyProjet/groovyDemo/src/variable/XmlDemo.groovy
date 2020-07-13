package variable

import groovy.xml.MarkupBuilder
import groovy.xml.XmlSlurper


/**            XML处理          */
// java 处理 dom文档或者是sax事件驱动解析
// 解析和创建xml
final String xml = '''<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE generatorConfiguration
        PUBLIC "-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN"
        "http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd">
<generatorConfiguration>
        <!--oracle的连接jar包-->
    <classPathEntry location="../obrain/libs/ojdbc8.jar"/>
    <context id="MybatisSQL" targetRuntime="mybatis3" defaultModelType="flat">
        <!-- 生成的Java文件的編碼 -->
        <property name="javaFileEncoding" value="UTF-8"/>
        <!-- 数据库关键字冲突,自动处理 -->
        <property name="autoDelimitKeywords" value="false"/>
        <!-- 格式化java代碼 -->
        <property name="javaFormatter" value="org.mybatis.generator.api.dom.DefaultJavaFormatter"/>

        <!-- 用反引号`包裹,默认是双引号"-->
        <property name="beginningDelimiter" value="`"/>
        <property name="endingDelimiter" value="`"/>
       <!-- <property name="ignoreFields" value="id,enabled,create_time,createBy,lastUpdateBy,lastUpdateTime"/>-->
        <plugin type="org.mybatis.generator.plugins.RenameExampleClassPlugin">
            <property name="searchString" value="Example$"/>
            <property name="replaceString" value="Criteria"/>
        </plugin>
        <plugin type="com.hundsun.obrain.mybatis.generator.plugins.OverIsMergeablePlugin">
            <property name="isMergeable" value="false"/>
        </plugin>
        <plugin type="org.mybatis.generator.plugins.SerializablePlugin"/>
        <plugin type="org.mybatis.generator.plugins.CaseInsensitiveLikePlugin"/>
        <plugin type="org.mybatis.generator.plugins.RowBoundsPlugin"/>
        <plugin type="com.hundsun.obrain.mybatis.generator.plugins.MapperAnnotationPlugin"/>
        <plugin type="com.hundsun.obrain.mybatis.generator.plugins.LombokPlugin"/>
        <commentGenerator type="com.hundsun.obrain.mybatis.generator.plugins.MyCommentGenerator"></commentGenerator>

        <jdbcConnection driverClass="oracle.jdbc.driver.OracleDriver"
                        connectionURL="jdbc:oracle:thin:@localhost:1521/orcl"
                        userId="bfam64"
                        password="bfam64">
            <property name="remarksReporting" value="true"></property>
        </jdbcConnection>

        <javaTypeResolver type="com.hundsun.obrain.mybatis.generator.common.MyJavaTypeResolver">
            <property name="forceBigDecimals" value="false"/>
        </javaTypeResolver>

        <!-- generate Model -->
        <javaModelGenerator targetPackage="com.hundsun.obrain.entity"
                            targetProject="../obrain/obrain-bampub/src/main/java">
            <property name="enableSubPackages" value="false"/>
            <property name="trimStrings" value="true"/>
            <!--<property name="immutable" value="false"/>-->
            <!--<property name="rootClass" value="com.hundsun.qin.platform.core.entity.BaseEntity"/>-->
            <property name="rootInterface" value="com.hundsun.qin.platform.core.basics.IdAndName"/>
        </javaModelGenerator>
       <!-- <javaModelGenerator targetPackage="com.hundsun.obrain.infodisclosure.entity.disclosurerule"
                            targetProject="../obrain/obrain-infodisclosure/src/main/java">
            <property name="enableSubPackages" value="false"/>
            <property name="trimStrings" value="true"/>
            &lt;!&ndash;<property name="immutable" value="false"/>&ndash;&gt;
            &lt;!&ndash;<property name="rootClass" value="com.hundsun.qin.platform.core.entity.BaseEntity"/>&ndash;&gt;
            <property name="rootInterface" value="com.hundsun.qin.platform.core.basics.IdAndName"/>
        </javaModelGenerator>-->

        <javaClientGenerator type="ANNOTATEDMAPPER" targetPackage="com.hundsun.obrain.dao"
                             targetProject="../obrain/obrain-bampub/src/main/java">
            <property name="enableSubPackages" value="false"/>
            <property name="addMapperAnnotation" value="true"/>
        </javaClientGenerator>
        <!--<javaClientGenerator type="ANNOTATEDMAPPER" targetPackage="com.hundsun.obrain.infodisclosure.dao.disclosurerule"
                             targetProject="../obrain/obrain-infodisclosure/src/main/java">
            <property name="enableSubPackages" value="false"/>
            <property name="addMapperAnnotation" value="true"/>
        </javaClientGenerator>-->
        <!--银行产品相关表-->
<!--        <table tableName="ts_reportfileinfo" domainObjectName="TsReportFileInfo">-->
<!--        </table>-->
        <!--<table tableName="ts_reportcolumnrelation" domainObjectName="TsReportColumnRelation">-->
        <!--</table>-->
        <!--<table tableName="ts_report_indicators" domainObjectName="TsReportIndicators">-->
        <!--</table>-->
        <!--<table tableName="ts_prdinfo" domainObjectName="TsPrdInfo">-->
        <!--</table>-->
        <!--<table tableName="ts_prdcaldata" domainObjectName="TsPrdCalData">-->
        <!--</table>-->
        <!--<table tableName="ts_currency" domainObjectName="TsCurrency">-->
        <!--</table>-->
        <!--<table tableName="ti_prdinterestrateinfo_tmp" domainObjectName="TiPrdInterestrateInfoTmp" schema="bfam60" >-->
            <!--<property name="ignoreQualifiersAtRuntime" value="true"/>-->
        <!--</table>-->
        <!--<table tableName="ti_prdinterestrateinfo" domainObjectName="TiPrdInterestrateInfo" schema="bfam60" >-->
            <!--<property name="ignoreQualifiersAtRuntime" value="true"/>-->
        <!--</table>-->
        <!--<table tableName="ts_prdinterestrateinfo" domainObjectName="TsPrdInterestrateInfo" schema="bfam60" >-->
            <!--<property name="ignoreQualifiersAtRuntime" value="true"/>-->
        <!--</table>-->
        <table tableName="AAA" domainObjectName="AAA" schema="bfam64" >
        <property name="ignoreQualifiersAtRuntime" value="true"/>
        </table>


    </context>

</generatorConfiguration>
'''
def myLangXml = '''
<response version-api="2.0">
 <langs type="myXml" count="5">
   <lang fast="1">
       false
   </lang>
   <lang fast="2">
       true
   </lang>
 </langs>
</response>'''
// 解析
def slurper = new XmlSlurper(false, true, true)

def response = slurper.parseText(myLangXml);

println response.langs.@type
def langs = response.langs.children()
// 通过.来访问标签  通过@属性，来访问，标签的值 比如@id 就是<text id='1' > 也可以用children() 获取子节点

/**
 * 生成XML
 * <langs type='myxml' count='5'>
 *  <lang fast='1'>
 *      false
 *  </lang>
 *  <lang fast='2'>
 *      true
 *  </lang>
 * </langs>
 */

def sw = new StringWriter()
def writeXmlBuilder = new MarkupBuilder(sw); // 用来生成xml的核心类
writeXmlBuilder.langs(type: 'myXml', count: '5') {
    lang(fast:'1', false) //第一个节点
    lang(fast:'2', true) {
        ko(ko: 'ok', 'heihei')
    }//第一个节点
}
// <langs type='myXml' count='5'>
//  <lang fast='1'>false</lang>
//  <lang fast='2'>true
//    <ko ko='ok'>heihei</ko>
//  </lang>
//</langs>

println sw


// 文件处理 JAVA 文件 节点流 InputStream/OutSteam  处理流Reader/Writer