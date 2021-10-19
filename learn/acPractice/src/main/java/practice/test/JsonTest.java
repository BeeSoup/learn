/*
 * 软件版权: 恒生电子股份有限公司
 * 修改记录:
 * 修改日期     修改人员  修改说明
 * ========    =======  ============================================
 * 2021/10/11  zhangyu30939  新增
 * ========    =======  ============================================
 */
package practice.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringEscapeUtils;

import java.io.Serializable;
import java.lang.reflect.Field;

/**
 * 功能说明:
 *
 * @author zhangyu30939
 * @since 2021-10-11
 */
@Slf4j
public class JsonTest {


    public static void main(String[] args) throws IllegalAccessException {
        Test test = new Test(" ");
        log.info(test.toString());
        Test test1 = setNullValue(test);
        log.info(test1.toString());
    }


    @AllArgsConstructor
    @Data
    @NoArgsConstructor
    @Builder
    public static class Test implements Serializable {
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private String key;
    }

    public static <T> T setNullValue(T source) throws IllegalArgumentException, IllegalAccessException, SecurityException {
        Field[] fields = source.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.getGenericType().toString().equals(
                    "class java.lang.String")) {
                field.setAccessible(true);
                Object obj = field.get(source);
                if (obj != null && obj.equals("")) {
                    field.set(source, null);
                } else if (obj != null) {
                    String str = obj.toString();
                    str = StringEscapeUtils.escapeSql(str);//StringEscapeUtils是commons-lang中的通用类
                    field.set(source, str.replace("\\", "\\" + "\\").replace("(", "\\(").replace(")", "\\)")
                            .replace("%", "\\%").replace("*", "\\*").replace("[", "\\[").replace("]", "\\]")
                            .replace("|", "\\|").replace(".", "\\.").replace("$", "\\$").replace("+", "\\+").trim()
                    );
                }
            }
        }
        return source;
    }

}
