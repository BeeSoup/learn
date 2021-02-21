/**
 * 软件版权: 恒生电子股份有限公司
 * 修改记录:
 * 修改日期     修改人员  修改说明
 * ========    =======  ============================================
 * 2020/7/17     qiucx28933  新增
 * ========    =======  ============================================
 */

package com.zy.newsource.util;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Supplier;


/**
 * @author dingxk30156
 * @date 2020/12/29 20:09
 */
public class BeanCopyUtil extends BeanUtils {


    /**
     * list转换
     * @param sources 源数据
     * @param target 转换类型
     * @return java.util.List<T>
     * @author dingxk30156
     * @date 2020/12/29 20:09
     */
    public static <S, T> List<T> copyListProperties(List<S> sources, Supplier<T> target) {
        return copyListProperties(sources, target, null);
    }

    /**
     * 带回调函数的集合数据的拷贝（可自定义字段拷贝规则）
     * @param sources 数据源类
     * @param target 目标类
     * @param callBack  回调函数
     * @return java.util.List<T>
     * @author dingxk30156
     * @date 2020/12/29 20:08
     */
    public static <S, T> List<T> copyListProperties(List<S> sources, Supplier<T> target, BiConsumer<S, T> callBack) {
        List<T> list = new ArrayList<>(sources.size());
        for (S source : sources) {
            T t = target.get();
            copyProperties(source, t);
            list.add(t);
            if (callBack != null) {
                // 回调
                callBack.accept(source, t);
            }
        }
        return list;
    }
}


