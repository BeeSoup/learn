package practice.test.newsettle.util;

import com.xQuant.base.exception.IRBaseException;
import com.xQuant.base.utils.JSONUtils;
import com.xQuant.platform.app.newsettle.entity.settledefine.TaskInitParam;
import com.xQuant.platform.app.newsettle.entity.settledefine.TaskOperEntity;
import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * @author yu.zhang
 * @Description: 任务链单个任务的初始化参数配置工具类
 * @date 2019/8/13 14:31
 */
public class SettleTransSynchUtil {
    /**
     * 必备日志一份
     */
    private static final Logger logger = LoggerFactory.getLogger(SettleTransSynchUtil.class);

    /**
     * Object转Json
     */
    public static String objectToJson(Object obj) throws IRBaseException {
        return JSONUtils.objectToJson(obj);
    }


    /**
     * 数据库任务配置Json转成实体
     */
    public static TaskInitParam jsonToInitParam(String json) throws IRBaseException {
        if (StringUtils.isBlank(json)) {
            return new TaskInitParam();
        }
//        TaskInitParam
        TypeReference<TaskInitParam> typeReference = new TypeReference<TaskInitParam>() {
        };
        TaskInitParam initParam = JSONUtils.jsonToListObject(json, typeReference);
        return initParam;
    }

    /**
     * @Author yu.zhang
     * @Date 2019/8/19 17:58
     * 只支持单层
     */
    private static TaskInitParam mapToParam(Map<String, Object> map) {
        TaskInitParam param = new TaskInitParam();
        Field[] fields = param.getClass().getDeclaredFields();

//        //java.lang.reflect.ModifierPUBLIC: 1
//        //PRIVATE: 2
//        //PROTECTED: 4
//        //STATIC: 8
//        //FINAL: 16
//        //SYNCHRONIZED: 32
//        //VOLATILE: 64
//        //TRANSIENT: 128
//        //NATIVE: 256
//        //INTERFACE: 512
//        //ABSTRACT: 1024
//        //STRICT: 2048
//        try {
        for (Field field : fields) {
//                MyAnnotation annotation = field.getAnnotation(MyAnnotation.class);
//                annotation.id();
//                int mod = field.getModifiers();
////               静态的和final 的直接返回
//                if (Modifier.isStatic(mod) || Modifier.isFinal(mod)) {
//                    continue;
//                }
////              如果名字一直才转换
//                if (!map.containsKey(field.getName())) {
//                    continue;
//                }
//                field.setAccessible(true);
//                field.set(param, map.get(field.getName()));
//                field.setAccessible(false);
//            }
//        } catch (Exception e) {
////          报错不管了，说明转换异常
//            logger.error("咱能用String吗属性一样好吗");
//            return param;
        }
        return param;
    }

    /**
     * 同步大对象实体到数据库中
     */
    public static void synchOperEntiry(TaskOperEntity entity) throws IRBaseException {
        //同步大对象实体到数据库中
        System.out.println("我保存一下吧 : " + entity.getBussinessKey());
    }

}
